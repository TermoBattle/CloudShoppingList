package com.example.compose_overrides

import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference

fun ConstrainScope.topToTopOf(anchor: ConstrainedLayoutReference) = top.linkTo(anchor = anchor.top)
fun ConstrainScope.bottomToTopOf(anchor: ConstrainedLayoutReference) = bottom.linkTo(anchor = anchor.top)
fun ConstrainScope.bottomToBottom() = bottom.linkTo(anchor = parent.bottom)
fun ConstrainScope.bottomToBottomOf(anchor: ConstrainedLayoutReference) = bottom.linkTo(anchor = anchor.bottom)
fun ConstrainScope.endToEnd() = end.linkTo(anchor = parent.end)
fun ConstrainScope.endToEndOf(anchor: ConstrainedLayoutReference) = end.linkTo(anchor = anchor.end)
fun ConstrainScope.startToStart() = start.linkTo(anchor = parent.start)
fun ConstrainScope.startToStartOf(anchor: ConstrainedLayoutReference) = start.linkTo(anchor = anchor.start)
fun ConstrainScope.topToTop() = top.linkTo(anchor = parent.top)