package com.example.cloudshoppinglist.data.textFieldTypes

import android.content.Context
import com.example.android_extensions.toast
import com.example.cloudshoppinglist.R.string.toast_null_email
import com.example.cloudshoppinglist.R.string.toast_null_password
import com.example.cloudshoppinglist.data.textFieldTypes.Email
import com.example.cloudshoppinglist.data.textFieldTypes.Password

inline fun Context.validate(
    email: Email?,
    password: Password?,
    onValid: (email: Email, password: Password) -> Unit
) = when {
    email == null -> toast(toast_null_email)
    password == null -> toast(toast_null_password)
    else -> onValid(email, password)
}