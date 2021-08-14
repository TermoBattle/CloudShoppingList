package com.example.cloudshoppinglist.models.firebase

import com.example.cloudshoppinglist.data.other.User
import com.example.cloudshoppinglist.data.textFieldTypes.Login
import com.example.cloudshoppinglist.data.textFieldTypes.toEmail
import com.example.cloudshoppinglist.exceptions.UnreachableException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

object FirestoreDataProvider{

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser = _currentUser.asStateFlow()

    init {
        Firebase.auth.addAuthStateListener { firebaseAuth ->
            GlobalScope.launch {
                _currentUser.emit(firebaseAuth.currentUser?.createUser()?.getOrNull())
            }
        }
    }

    private suspend fun FirebaseUser.createUser(): Result<User> {
        val email =
            email?.toEmail() ?: throw UnreachableException("FirebaseUser must have a [email] field")

        val login: Login = FirestoreFinder
            .fetchLogin(uid = uid)
            .getOrElse {
                return failure(it)
            }

        return success(value = User(email, login))
    }
}

