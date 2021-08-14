@file:Suppress("unused", "unused")

package com.example.cloudshoppinglist.data.textFieldTypes

import androidx.compose.runtime.Composable
import com.example.cloudshoppinglist.R
import com.example.compose_overrides.Showable

@JvmInline
value class Email(private val email: String) : Showable {

    companion object{
        val String.isValidEmail inline get() = '@' in this && isNotBlank()
    }

    init {
        require(email.isValidEmail) { "Email must [isNotBlank]" }
    }

    @Composable
    override fun toFieldText() = "${R.string.email}: $email"


    override fun toString() = email

}

fun String.toEmail() = Email(email = this)

fun String.toEmailOrNull() = if (isNotBlank()) Email(this) else null