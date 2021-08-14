package com.example.cloudshoppinglist.models.firebase

import com.example.cloudshoppinglist.data.textFieldTypes.Email
import com.example.cloudshoppinglist.data.textFieldTypes.Password
import com.google.firebase.auth.ktx.*
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

object FirebaseAuthenticator {

    suspend fun register(email: Email, password: Password) {
        Firebase.auth
            .createUserWithEmailAndPassword(email.toString(), password.toString())
            .await()
    }

    fun signIn(email: Email, password: Password) {
        Firebase.auth.signInWithEmailAndPassword(email.toString(), password.toString())

    }

    fun signOut() = Firebase.auth.signOut()
}
