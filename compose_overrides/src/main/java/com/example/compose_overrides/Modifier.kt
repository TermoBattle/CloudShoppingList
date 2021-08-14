package com.example.compose_overrides

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.defaultPadding() = padding(16.dp)
fun Modifier.buttonPadding() = padding(8.dp)
fun Modifier.innerPadding() = padding(4.dp)