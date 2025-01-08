package com.wearerommies.roomie.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

// Primary
val Primary = Color(0xFF626CF6)
val PrimaryLight1 = Color(0xFF949BFF)
val PrimaryLight2 = Color(0xFFB0B5FF)
val PrimaryLight3 = Color(0xFFD2D4FC)
val PrimaryLight4 = Color(0xFFEFF0FF)
val PrimaryLight5 = Color(0xFFFAFAFF)
val PrimaryDark1 = Color(0xFF3C43A9)
val PrimaryDark2 = Color(0xFF1B1F5A)

// Secondary
val Secondary = Color(0xFFFE885C)
val SecondaryLight1 = Color(0xFFFEBD9A)
val SecondaryLight2 = Color(0xFFFEE4CB)
val SecondaryLight3 = Color(0xFFFFF7F0)


// Gray Scale
val GrayScale1 = Color(0xFFFFFFFF)
val GrayScale2 = Color(0xFFFAFAFA)
val GrayScale3 = Color(0xFFF4F4F4)
val GrayScale4 = Color(0xFFEDEDED)
val GrayScale5 = Color(0xFFD6D6D6)
val GrayScale6 = Color(0xFFBCBCBC)
val GrayScale7 = Color(0xFFA1A1A1)
val GrayScale8 = Color(0xFF858585)
val GrayScale9 = Color(0xFF696969)
val GrayScale10 = Color(0xFF4D4D4D)
val GrayScale11 = Color(0xFF323232)
val GrayScale12 = Color(0xFF1A1A1A)

// Transparent
val TransparentGray1260 = Color(0x99000000)
val TransparentGray1250 = Color(0x80000000)
val TransparentGray140 = Color(0x4DFFFFFF)
val TransparentGray160 = Color(0x99FFFFFF)
val TransparentGray1210 = Color(0x1A1A1A1A)

// Action
val ActionError = Color(0xFFEA0000)

@Stable
class RommieColors(
    primary: Color,
    primaryLight1: Color,
    primaryLight2: Color,
    primaryLight3: Color,
    primaryLight4: Color,
    primaryLight5: Color,
    primaryDark1: Color,
    primaryDark2: Color,
    secondary: Color,
    secondaryLight1: Color,
    secondaryLight2: Color,
    secondaryLight3: Color,
    grayScale1: Color,
    grayScale2: Color,
    grayScale3: Color,
    grayScale4: Color,
    grayScale5: Color,
    grayScale6: Color,
    grayScale7: Color,
    grayScale8: Color,
    grayScale9: Color,
    grayScale10: Color,
    grayScale11: Color,
    grayScale12: Color,
    transparentGray1260: Color,
    transparentGray1250: Color,
    transparentGray140: Color,
    transparentGray160: Color,
    transparentGray1210: Color,
    actionError: Color
) {
    var primary: Color by mutableStateOf(primary)
        private set
    var primaryLight1: Color by mutableStateOf(primaryLight1)
        private set
    var primaryLight2: Color by mutableStateOf(primaryLight2)
        private set
    var primaryLight3: Color by mutableStateOf(primaryLight3)
        private set
    var primaryLight4: Color by mutableStateOf(primaryLight4)
        private set
    var primaryLight5: Color by mutableStateOf(primaryLight5)
        private set
    var primaryDark1: Color by mutableStateOf(primaryDark1)
        private set
    var primaryDark2: Color by mutableStateOf(primaryDark2)
        private set
    var secondary: Color by mutableStateOf(secondary)
        private set
    var secondaryLight1: Color by mutableStateOf(secondaryLight1)
        private set
    var secondaryLight2: Color by mutableStateOf(secondaryLight2)
        private set
    var secondaryLight3: Color by mutableStateOf(secondaryLight3)
        private set
    var grayScale1: Color by mutableStateOf(grayScale1)
        private set
    var grayScale2: Color by mutableStateOf(grayScale2)
        private set
    var grayScale3: Color by mutableStateOf(grayScale3)
        private set
    var grayScale4: Color by mutableStateOf(grayScale4)
        private set
    var grayScale5: Color by mutableStateOf(grayScale5)
        private set
    var grayScale6: Color by mutableStateOf(grayScale6)
        private set
    var grayScale7: Color by mutableStateOf(grayScale7)
        private set
    var grayScale8: Color by mutableStateOf(grayScale8)
        private set
    var grayScale9: Color by mutableStateOf(grayScale9)
        private set
    var grayScale10: Color by mutableStateOf(grayScale10)
        private set
    var grayScale11: Color by mutableStateOf(grayScale11)
        private set
    var grayScale12: Color by mutableStateOf(grayScale12)
        private set
    var transparentGray1260: Color by mutableStateOf(transparentGray1260)
        private set
    var transparentGray1250: Color by mutableStateOf(transparentGray1250)
        private set
    var transparentGray140: Color by mutableStateOf(transparentGray140)
        private set
    var transparentGray160: Color by mutableStateOf(transparentGray160)
        private set
    var transparentGray1210: Color by mutableStateOf(transparentGray1210)
        private set
    var actionError: Color by mutableStateOf(actionError)
        private set

    fun copy(
        primary: Color = this.primary,
        primaryLight1: Color = this.primaryLight1,
        primaryLight2: Color = this.primaryLight2,
        primaryLight3: Color = this.primaryLight3,
        primaryLight4: Color = this.primaryLight4,
        primaryLight5: Color = this.primaryLight5,
        primaryDark1: Color = this.primaryDark1,
        primaryDark2: Color = this.primaryDark2,
        secondary: Color = this.secondary,
        secondaryLight1: Color = this.secondaryLight1,
        secondaryLight2: Color = this.secondaryLight2,
        secondaryLight3: Color = this.secondaryLight3,
        grayScale1: Color = this.grayScale1,
        grayScale2: Color = this.grayScale2,
        grayScale3: Color = this.grayScale3,
        grayScale4: Color = this.grayScale4,
        grayScale5: Color = this.grayScale5,
        grayScale6: Color = this.grayScale6,
        grayScale7: Color = this.grayScale7,
        grayScale8: Color = this.grayScale8,
        grayScale9: Color = this.grayScale9,
        grayScale10: Color = this.grayScale10,
        grayScale11: Color = this.grayScale11,
        grayScale12: Color = this.grayScale12,
        transparentGray1260: Color = this.transparentGray1260,
        transparentGray1250: Color = this.transparentGray1250,
        transparentGray140: Color = this.transparentGray140,
        transparentGray160: Color = this.transparentGray160,
        transparentGray1210: Color = this.transparentGray1210,
        actionError: Color = this.actionError
    ): RommieColors = RommieColors(
        primary,
        primaryLight1,
        primaryLight2,
        primaryLight3,
        primaryLight4,
        primaryLight5,
        primaryDark1,
        primaryDark2,
        secondary,
        secondaryLight1,
        secondaryLight2,
        secondaryLight3,
        grayScale1,
        grayScale2,
        grayScale3,
        grayScale4,
        grayScale5,
        grayScale6,
        grayScale7,
        grayScale8,
        grayScale9,
        grayScale10,
        grayScale11,
        grayScale12,
        transparentGray1260,
        transparentGray1250,
        transparentGray140,
        transparentGray160,
        transparentGray1210,
        actionError
    )

    fun update(other: RommieColors) {
        primary = other.primary
        primaryLight1 = other.primaryLight1
        primaryLight2 = other.primaryLight2
        primaryLight3 = other.primaryLight3
        primaryLight4 = other.primaryLight4
        primaryLight5 = other.primaryLight5
        primaryDark1 = other.primaryDark1
        primaryDark2 = other.primaryDark2
        secondary = other.secondary
        secondaryLight1 = other.secondaryLight1
        secondaryLight2 = other.secondaryLight2
        secondaryLight3 = other.secondaryLight3
        grayScale1 = other.grayScale1
        grayScale2 = other.grayScale2
        grayScale3 = other.grayScale3
        grayScale4 = other.grayScale4
        grayScale5 = other.grayScale5
        grayScale6 = other.grayScale6
        grayScale7 = other.grayScale7
        grayScale8 = other.grayScale8
        grayScale9 = other.grayScale9
        grayScale10 = other.grayScale10
        grayScale11 = other.grayScale11
        grayScale12 = other.grayScale12
        transparentGray1260 = other.transparentGray1260
        transparentGray1250 = other.transparentGray1250
        transparentGray140 = other.transparentGray140
        transparentGray160 = other.transparentGray160
        transparentGray1210 = other.transparentGray1210
        actionError = other.actionError
    }
}

fun rommieColors(
    primary: Color = Primary,
    primaryLight1: Color = PrimaryLight1,
    primaryLight2: Color = PrimaryLight2,
    primaryLight3: Color = PrimaryLight3,
    primaryLight4: Color = PrimaryLight4,
    primaryLight5: Color = PrimaryLight5,
    primaryDark1: Color = PrimaryDark1,
    primaryDark2: Color = PrimaryDark2,
    secondary: Color = Secondary,
    secondaryLight1: Color = SecondaryLight1,
    secondaryLight2: Color = SecondaryLight2,
    secondaryLight3: Color = SecondaryLight3,
    grayScale1: Color = GrayScale1,
    grayScale2: Color = GrayScale2,
    grayScale3: Color = GrayScale3,
    grayScale4: Color = GrayScale4,
    grayScale5: Color = GrayScale5,
    grayScale6: Color = GrayScale6,
    grayScale7: Color = GrayScale7,
    grayScale8: Color = GrayScale8,
    grayScale9: Color = GrayScale9,
    grayScale10: Color = GrayScale10,
    grayScale11: Color = GrayScale11,
    grayScale12: Color = GrayScale12,
    transparentGray1260: Color = TransparentGray1260,
    transparentGray1250: Color = TransparentGray1250,
    transparentGray140: Color = TransparentGray140,
    transparentGray160: Color = TransparentGray160,
    transparentGray1210: Color = TransparentGray1210,
    actionError: Color = ActionError
) = RommieColors(
    primary,
    primaryLight1,
    primaryLight2,
    primaryLight3,
    primaryLight4,
    primaryLight5,
    primaryDark1,
    primaryDark2,
    secondary,
    secondaryLight1,
    secondaryLight2,
    secondaryLight3,
    grayScale1,
    grayScale2,
    grayScale3,
    grayScale4,
    grayScale5,
    grayScale6,
    grayScale7,
    grayScale8,
    grayScale9,
    grayScale10,
    grayScale11,
    grayScale12,
    transparentGray1260,
    transparentGray1250,
    transparentGray140,
    transparentGray160,
    transparentGray1210,
    actionError
)