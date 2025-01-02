package com.wearerommies.roomie.presentation.core.util

import java.text.DecimalFormat

object PriceFormatter {
    fun formatPrice(price: Int): String {
        return DecimalFormat("#,###").format(price)
    }

    fun formatPriceWon(price: Int): String {
        return DecimalFormat("#,###").format(price) + "원"
    }
}
