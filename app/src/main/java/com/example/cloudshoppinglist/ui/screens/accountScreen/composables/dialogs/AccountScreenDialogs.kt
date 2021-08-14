package com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cloudshoppinglist.viewModels.accountScreen.dialogs.AccountScreenDialogs.*
import com.example.cloudshoppinglist.viewModels.accountScreen.dialogs.AccountScreenDialogsViewModel

@Composable
fun AccountScreenDialogs(viewModel: AccountScreenDialogsViewModel = viewModel()) {
    val currentDialog by viewModel.currentDialog.collectAsState()
    when (currentDialog) {
        RegisterDialog -> RegisterDialog(onClose = { viewModel.emitNewDialog(Empty) })
        SignInDialog -> SignInDialog(onClose = { viewModel.emitNewDialog(Empty) })
        Empty -> Unit
    }
}