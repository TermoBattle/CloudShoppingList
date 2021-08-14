package com.example.cloudshoppinglist.ui.screens.mainScreen

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cloudshoppinglist.R
import com.example.cloudshoppinglist.ui.navigation.Screen
import com.example.cloudshoppinglist.ui.navigation.Screens.AccountScreen
import com.example.cloudshoppinglist.ui.screens.accountScreen.AccountScreen
import com.example.compose_overrides.Text
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@Composable
fun MainScreen(
    navigator: MainScreenNavigator = get(),
) {
    val coroutineScope = rememberCoroutineScope()

    val navController = rememberNavController()

    fun Screen.navigate() = coroutineScope.launch {
        navigator
            .navigateTo(
                screen = this@navigate,
                navController = navController
            )
    }

    val currentScreenTitle by navigator.currentScreenTitle.collectAsState()

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerButton(
                icon = Icons.Default.AccountBox,
                text = R.string.account_screen,
                isSelected = navigator.isScreenCurrent(AccountScreen),
                onClick = AccountScreen::navigate
            )
        },
        topBar = {
            MainTopAppBar(currentScreenTitle, scaffoldState)
        },
        content = {
            NavHost(navController = navController, startDestination = navigator.startScreen.route) {
                composable(route = AccountScreen.route) {
                    AccountScreen()
                }
            }
        }
    )
}

@Composable
private fun MainTopAppBar(
    title: Int,
    scaffoldState: ScaffoldState
) {
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null
                    )
                }
            )
        }
    )
}

@Composable
fun DrawerButton(
    icon: ImageVector,
    @StringRes text: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colors

    val imageAlpha = if (isSelected) 1f else 0.6f

    val textIconColor = if (isSelected) colors.primary else colors.onSurface.copy(alpha = 0.6f)

    val backgroundColor = if (isSelected) colors.primary.copy(alpha = 0.12f) else Color.Transparent

    val surfaceModifier = modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
        .fillMaxWidth()

    Surface(
        modifier = surfaceModifier,
        color = backgroundColor,
        shape = MaterialTheme.shapes.small
    ) {

        TextButton(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    imageVector = icon,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(textIconColor),
                    alpha = imageAlpha
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = stringResource(id = text),
                    color = textIconColor,
                    style = MaterialTheme.typography.body2
                )

            }
        }
    }
}


interface MainScreenNavigator {
    val currentScreenTitle: StateFlow<Int>
    val startScreen: Screen

    suspend fun navigateTo(screen: Screen, navController: NavHostController)
    fun isScreenCurrent(screen: Screen): Boolean
}