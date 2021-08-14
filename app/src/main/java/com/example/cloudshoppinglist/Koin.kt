package com.example.cloudshoppinglist

import android.app.Application
import com.example.cloudshoppinglist.ui.navigation.AppNavigator
import com.example.cloudshoppinglist.ui.screens.accountScreen.AccountScreenDialogsOpener
import com.example.cloudshoppinglist.ui.screens.mainScreen.MainScreenNavigator
import com.example.cloudshoppinglist.viewModels.accountScreen.AccountScreenViewModel
import com.example.cloudshoppinglist.viewModels.accountScreen.dialogs.AccountScreenDialogsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mainModule, accountScreenModule)
        }
    }
}

val mainModule = module {
    single<MainScreenNavigator>{ AppNavigator }
}

val accountScreenModule = module {
    viewModel { AccountScreenViewModel() }
    viewModel { AccountScreenDialogsViewModel() }
}