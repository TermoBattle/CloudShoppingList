package com.example.cloudshoppinglist.ui.screens.accountScreen.composables.otherButtons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cloudshoppinglist.R
import com.example.cloudshoppinglist.data.*
import com.example.cloudshoppinglist.data.textFieldTypes.*
import com.example.compose_overrides.OutlinedTextField
import com.example.compose_overrides.Text
import com.example.compose_overrides.buttonPadding

@Composable
fun OutlinedEmailField(state: MutableState<Email?>) {
    OutlinedTextField(state = state, toValue = String::toEmailOrNull)
}

@Composable
fun OutlinedPasswordField(state: MutableState<Password?>) {
    OutlinedTextField(state = state, toValue = String::toPasswordOrNull)
}

@Composable
fun OutlinedLoginField(state: MutableState<Login?>) {
    OutlinedTextField(state = state, toValue = String::toLoginOrNull)
}

@Composable
fun OutlinedIconButton(
    @StringRes text: Int,
    icon: ImageVector,
    onClick: () -> Unit
) = OutlinedButton(onClick = onClick) {
    Icon(imageVector = icon, contentDescription = null)
    Spacer(modifier = Modifier.buttonPadding())
    Text(text = text)
}

@Composable
fun RegisterButton(onClick: () -> Unit) = OutlinedIconButton(
    text = R.string.register,
    icon = Icons.Default.AccountBox,
    onClick = onClick
)

@Composable
fun SignInButton(onClick: () -> Unit) = OutlinedIconButton(
    text = R.string.sign_in,
    icon = Icons.Default.ExitToApp,
    onClick = onClick
)