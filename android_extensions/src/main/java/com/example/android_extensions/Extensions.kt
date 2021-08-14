package com.example.android_extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    launch(context, start, block)
}

fun <T> StateFlow<T>.collectInScopeOf(viewModel: ViewModel, action: suspend CoroutineScope.(value: T) -> Unit) {
    viewModel.viewModelScope.launch {
        this@collectInScopeOf.collect { action(it) }
    }
}
