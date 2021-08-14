package com.example.android_extensions.common

inline operator fun (() -> Unit).plus(crossinline other: () -> Unit): () -> Unit = {
    this()
    other()
}