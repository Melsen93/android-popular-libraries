package com.example.android.popularlibraries.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String): String {
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return simpleDateFormat.format(this)
}