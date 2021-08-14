package com.example.cloudshoppinglist.ui.screens.accountScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cloudshoppinglist.data.other.User
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.UserDataCard
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogButtons.RegisterDialogButton
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogButtons.SignInDialogButton
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogButtons.SignOutButton
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogs.AccountScreenDialogs
import com.example.cloudshoppinglist.viewModels.accountScreen.AccountScreenViewModel
import com.example.cloudshoppinglist.viewModels.accountScreen.dialogs.AccountScreenDialogs.RegisterDialog
import com.example.cloudshoppinglist.viewModels.accountScreen.dialogs.AccountScreenDialogs.SignInDialog
import com.example.cloudshoppinglist.viewModels.accountScreen.dialogs.AccountScreenDialogsViewModel
import com.example.compose_overrides.*
import org.koin.androidx.compose.getViewModel


@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    viewModel: AccountScreenViewModel = viewModel()
) = Box(modifier = modifier.defaultPadding()) {
    AccountScreenDialogs()

    val userData by viewModel.userData.collectAsState()
    val logged by viewModel.isCurrentUserLogged.collectAsState()
    AccountScreenTrueLayout(
        Modifier.fillMaxSize(),
        userData,
        logged,
    )
}

@Composable
fun AccountScreenTrueLayout(
    modifier: Modifier = Modifier,
    userData: User?,
    logged: Boolean
) = ConstraintLayout(modifier = modifier) {
    val (userDataCard, accountActions) = createRefs()

    UserDataCard(
        modifier = Modifier.constrainAs(userDataCard) {
            topToTop()
            startToStart()
            endToEnd()
        },
        userData = userData
    )

    AccountActions(
        modifier = Modifier.constrainAs(accountActions) {
            startToStart()
            endToEnd()
            bottomToBottom()
        },
        logged = logged
    )

}

@Composable
fun AccountActions(
    modifier: Modifier = Modifier,
    accountScreenDialogsViewModel: AccountScreenDialogsViewModel = getViewModel(),
    logged: Boolean
) {
    if (logged)
        SignOutButton(modifier = modifier.fillMaxWidth())
    else {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignInDialogButton(
                openSignInDialog = { accountScreenDialogsViewModel.emitNewDialog(SignInDialog) }
            )
            Spacer(modifier = Modifier.innerPadding())
            RegisterDialogButton(
                openRegisterDialog = { accountScreenDialogsViewModel.emitNewDialog(RegisterDialog) }
            )
        }
    }
}

interface AccountScreenDialogsOpener {

    fun openSignInDialog()
    fun openRegisterDialog()

}
