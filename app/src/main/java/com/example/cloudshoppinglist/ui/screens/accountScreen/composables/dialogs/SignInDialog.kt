package com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogs

import android.content.Context
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.window.Dialog
import com.example.cloudshoppinglist.data.textFieldTypes.Email
import com.example.cloudshoppinglist.data.textFieldTypes.Password
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.otherButtons.OutlinedEmailField
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.otherButtons.OutlinedPasswordField
import com.example.cloudshoppinglist.ui.screens.accountScreen.composables.otherButtons.SignInButton
import org.koin.androidx.compose.get

@Composable
fun SignInDialog(
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    controller: SignInDialogController = get()
) = Dialog(onDismissRequest = onClose) {
    Column(
        modifier = modifier,
        verticalArrangement = SpaceEvenly,
        horizontalAlignment = CenterHorizontally
    ) {
        OutlinedEmailField(state = controller.email)
        OutlinedPasswordField(state = controller.password)


        val context = LocalContext.current
        SignInButton {
            controller.signIn(context = context)
            onClose()
        }
    }
}

interface SignInDialogController {
    val email: MutableState<Email?>
    val password: MutableState<Password?>

    fun signIn(context: Context)
}
