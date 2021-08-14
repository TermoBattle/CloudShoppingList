package com.example.cloudshoppinglist.models.firebase

import com.example.cloudshoppinglist.data.textFieldTypes.Login
import com.example.cloudshoppinglist.data.textFieldTypes.toLogin
import com.example.cloudshoppinglist.exceptions.TooMuchUsersFoundException
import com.example.cloudshoppinglist.exceptions.UserNotFoundException
import com.example.cloudshoppinglist.models.firebase.utils.UID
import com.example.cloudshoppinglist.models.firebase.utils.login
import com.example.cloudshoppinglist.models.firebase.utils.users
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

object FirestoreFinder {

    suspend fun fetchLogin(uid: String): Result<Login> = Firebase.firestore
            .users
            .findUserDocumentSnapshot(uid = uid)
            .map { userSnapshot: DocumentSnapshot ->
                userSnapshot.login.toLogin()
            }


    private suspend fun CollectionReference.findUserDocumentSnapshot(uid: String): Result<DocumentSnapshot> =
        whereEqualTo(UID, uid)
            .get()
            .await()
            .documents.let { searchedUsers: MutableList<DocumentSnapshot> ->

                when (searchedUsers.size) {

                    1 -> success(searchedUsers.first())

                    0 -> failure(UserNotFoundException("No users found"))

                    else -> failure(TooMuchUsersFoundException("More than 1 users found"))

                }

            }
}