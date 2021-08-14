package com.example.cloudshoppinglist.viewModels.accountScreen.dialogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_extensions.launch
import com.example.cloudshoppinglist.ui.screens.accountScreen.AccountScreenDialogsOpener
import com.example.cloudshoppinglist.viewModels.accountScreen.dialogs.AccountScreenDialogs.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class AccountScreenDialogs {
    RegisterDialog,
    SignInDialog,
    Empty
}

class AccountScreenDialogsViewModel : ViewModel() {

    private val _currentDialog = MutableStateFlow(Empty)

    val currentDialog = _currentDialog.asStateFlow()

    fun emitNewDialog(dialog: AccountScreenDialogs) = viewModelScope.launch {
        _currentDialog.emit(dialog)
    }

}