@file:Suppress("ObjectPropertyName")

package com.example.cloudshoppinglist.ui.navigation

import androidx.navigation.NavHostController
import com.example.cloudshoppinglist.ui.screens.mainScreen.MainScreenNavigator
import com.example.cloudshoppinglist.ui.navigation.Screens.AccountScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppNavigator : MainScreenNavigator {

    override val startScreen: Screen = AccountScreen

    private val _currentScreen = MutableStateFlow(startScreen)

    private val _currentScreenTitle = MutableStateFlow(startScreen.title)
    override val currentScreenTitle: StateFlow<Int> = _currentScreenTitle.asStateFlow()


    override fun isScreenCurrent(screen: Screen) = _currentScreen == screen

    override suspend fun navigateTo(screen: Screen, navController: NavHostController) {
        navController.navigate(route = screen.route)
        emitScreen(screen = screen)
    }

    private suspend fun emitScreen(screen: Screen) {
        _currentScreen.emit(value = screen)
        _currentScreenTitle.emit(value = screen.title)
    }
}