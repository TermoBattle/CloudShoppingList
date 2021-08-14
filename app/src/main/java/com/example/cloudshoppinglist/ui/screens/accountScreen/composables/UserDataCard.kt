package com.example.cloudshoppinglist.ui.screens.accountScreen.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cloudshoppinglist.R.string.userData_not_found
import com.example.cloudshoppinglist.data.other.User
import com.example.compose_overrides.defaultPadding


@Composable
fun UserDataCard(modifier: Modifier = Modifier, userData: User?) =
    Card(modifier = modifier.defaultPadding()) {
        if (userData == null)
            Text(
                text = stringResource(id = userData_not_found)
            )
        else
            Column(
                verticalArrangement = SpaceEvenly,
                horizontalAlignment = CenterHorizontally
            ) {
                Row(horizontalArrangement = SpaceEvenly, verticalAlignment = CenterVertically) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                    Text(
                        text = userData.login.toFieldText()
                    )
                }
                Text(
                    text = userData.email.toFieldText()
                )
            }
    }
