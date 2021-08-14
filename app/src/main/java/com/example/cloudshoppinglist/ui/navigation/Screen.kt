package com.example.cloudshoppinglist.ui.navigation

import androidx.annotation.StringRes
import com.example.cloudshoppinglist.R

sealed interface Screen {
    @get:StringRes val title: Int
    val route: String
}

object Screens{
    object AccountScreen: Screen {
        override val title = R.string.account_screen
        override val route = "account"
    }
}
