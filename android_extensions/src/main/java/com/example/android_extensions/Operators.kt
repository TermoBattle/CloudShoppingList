package com.example.android_extensions

inline operator fun (() -> Unit).plus(crossinline other: () -> Unit): () -> Unit = {
    this()
    other()
}