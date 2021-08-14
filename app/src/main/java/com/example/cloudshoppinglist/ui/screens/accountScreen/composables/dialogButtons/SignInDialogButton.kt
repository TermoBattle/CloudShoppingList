package com.example.cloudshoppinglist.ui.screens.accountScreen.composables.dialogButtons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import com.example.cloudshoppinglist.R
import com.example.compose_overrides.buttonPadding

@Composable
fun SignInDialogButton(
    modifier: Modifier = Modifier,
    openSignInDialog: () -> Unit,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = ButtonDefaults.outlinedBorder,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    contentDescription: String? = null,
) = OutlinedButton(
    onClick = openSignInDialog,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    elevation = elevation,
    shape = shape,
    border = border,
    colors = colors,
    contentPadding = contentPadding,
    content = {
        Icon(imageVector = Icons.Default.ExitToApp,
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.buttonPadding())
        Text(text = stringResource(id = R.string.sign_in
        ),
            style = MaterialTheme.typography.button)
    }
)
