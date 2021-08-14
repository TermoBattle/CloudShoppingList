package com.example.cloudshoppinglist.viewModels.accountScreen

import androidx.lifecycle.ViewModel
import com.example.android_extensions.collectInScopeOf
import com.example.cloudshoppinglist.data.other.User
import com.example.cloudshoppinglist.models.firebase.FirestoreDataProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AccountScreenViewModel : ViewModel() {

    private val _isCurrentUserLogged = MutableStateFlow(isUserLogged)
    val isCurrentUserLogged = _isCurrentUserLogged.asStateFlow()

    private val _userData = MutableStateFlow<User?>(value = null)
    val userData = _userData.asStateFlow()

    init {
        FirestoreDataProvider.currentUser.collectInScopeOf(viewModel = this) {
            refreshAll(userData = it)
        }
    }

    private val isUserLogged: Boolean
        inline get() = FirestoreDataProvider.currentUser.value != null

    private fun CoroutineScope.refreshAll(userData: User?) {
        launch { _isCurrentUserLogged.emit(value = isUserLogged) }
        launch { _userData.emit(value = userData) }
    }
}