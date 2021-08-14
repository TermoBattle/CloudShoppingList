package com.example.cloudshoppinglist.viewModels.accountScreen.dialogs

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_extensions.launch
import com.example.cloudshoppinglist.data.textFieldTypes.Email
import com.example.cloudshoppinglist.data.textFieldTypes.Password
import com.example.cloudshoppinglist.data.textFieldTypes.validate
import com.example.cloudshoppinglist.models.firebase.FirebaseAuthenticator

class RegisterDialogViewModel : ViewModel(){
    val email = mutableStateOf<Email?>(value = null)
    val password = mutableStateOf<Password?>(value = null)

    fun register(context: Context): Unit = viewModelScope.launch {
        context.validate(
            email = email.value,
            password = password.value,
        ) { email, password ->
            FirebaseAuthenticator.register(email, password)
        }
    }

}