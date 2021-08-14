package com.example.cloudshoppinglist.data.textFieldTypes

import androidx.compose.runtime.Composable
import com.example.cloudshoppinglist.R
import com.example.compose_overrides.Showable

const val passwordErrorMessage = "Password must [isNotBlank]"

@JvmInline
value class Password(private val password: String) : Showable {

    init {
        require(password.isNotBlank()) { passwordErrorMessage }
    }

    @Composable
    override fun toFieldText() = "${R.string.password}: $password"

    override fun toString() = password

}

fun String.toPasswordOrNull() = if (isNotBlank()) Password(this) else null