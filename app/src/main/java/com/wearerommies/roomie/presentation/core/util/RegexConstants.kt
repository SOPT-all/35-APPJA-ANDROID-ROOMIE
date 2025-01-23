package com.wearerommies.roomie.presentation.core.util

object RegexConstants {
    val DATE_SPLIT_REGEX = Regex("[^\\-]+|-")
    val PHONE_NUMBER_REGEX = Regex("^01[0-9]{1}[0-9]{4}[0-9]{4}$")
}