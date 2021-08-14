package com.example.cloudshoppinglist.models.firebase.utils

import com.example.cloudshoppinglist.data.textFieldTypes.Email
import com.example.cloudshoppinglist.data.textFieldTypes.Login
import com.google.firebase.firestore.DocumentSnapshot

// FirestoreUser document fields /////////////////////////
const val UID = "uid"
val DocumentSnapshot.uid inline get() = this[UID] as String

const val LOGIN = "login"
val DocumentSnapshot.login inline get() = this[LOGIN] as String