package com.example.cloudshoppinglist.models.firebase.utils

import com.google.firebase.firestore.FirebaseFirestore

// Global collections /////////////////////
const val USERS = "users"
val FirebaseFirestore.users inline get() = collection(USERS)

const val GROUPS = "GROUPS"
val FirebaseFirestore.groups inline get() = collection(GROUPS)