package com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogButtons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import com.example.cloudshoppinglist.R.string.sign_out
import org.koin.androidx.compose.get


@Composable
fun SignOutButton(
    modifier: Modifier = Modifier,
    signOutButtonController: SignOutButtonController = get(),
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = ButtonDefaults.outlinedBorder,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding
) = OutlinedButton(
    onClick = signOutButtonController::signOut,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    elevation = elevation,
    shape = shape,
    border = border,
    colors = colors,
    contentPadding = contentPadding,
    content = {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null
        )
        Text(
            text = stringResource(id = sign_out),
            style = MaterialTheme.typography.button
        )
    }
)

fun interface SignOutButtonController {
    fun signOut()
}
