package com.wearerommies.roomie.presentation.core.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toFormattedString(pattern: String = "yyyy/MM/dd"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(this)
}

fun todayFormatted(pattern: String = "yyyy/MM/dd"): String {
    return Date().toFormattedString(pattern)
}

fun String.toFormattedDto(): String {
    return this.replace("/", "-")
}

