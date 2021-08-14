package com.example.cloudshoppinglist.data.textFieldTypes

import androidx.compose.runtime.Composable
import com.example.cloudshoppinglist.R
import com.example.compose_overrides.Showable

@JvmInline
value class Login(private val login: String) : Showable {

    init {
        require(login.isNotBlank()) { "Login must [isNotBlank]" }
    }

    @Composable
    override fun toFieldText() = "${R.string.login}: $login"

    override fun toString() = login
}

fun String.toLogin(): Login {
    require(isNotBlank()) { "Login must [isNotBlank]" }
    return Login(login = this)
}

fun String.toLoginOrNull() = if (isNotBlank()) Login(this) else null