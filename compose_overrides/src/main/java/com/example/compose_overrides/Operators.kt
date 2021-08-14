package com.example.compose_overrides

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
operator fun @receiver:StringRes Int.plus(other:String): String = stringResource(id = this) + other