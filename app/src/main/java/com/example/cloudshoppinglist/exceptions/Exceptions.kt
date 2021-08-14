package com.example.cloudshoppinglist.exceptions

class UnreachableException(message: String = "Programmer error") : Exception(message)

sealed class FirebaseException(message: String) : Exception(message)

class UserNotFoundException(message: String): FirebaseException(message)
class TooMuchUsersFoundException(message: String): FirebaseException(message)