package ru.amria.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.amria.designsystem.R

val RubikFontFamilyBold = FontFamily(
    Font(R.font.futura, FontWeight.Bold),
)

val RubikFontFamilyMedium = FontFamily(
    Font(R.font.rubik_one, FontWeight.Medium),
)

val RubikFontFamilyNormal = FontFamily(
    Font(R.font.rubik_one, FontWeight.Normal),
)

val RubikFontFamilyLight = FontFamily(
    Font(R.font.rubik_one, FontWeight.ExtraLight),
)

val GothamProFontFamilyLight = FontFamily(
    Font(R.font.gothampro_light),
)

val GothamProFontFamilyMedium = FontFamily(
    Font(R.font.gothampro_medium),
)


val Typography = Typography(
    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight(700),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyBold,
    ),
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(300),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyBold,
    ),
    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(300),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyBold,
    ),
    bodyLarge = TextStyle(
        fontSize = 26.sp,
        letterSpacing = 0.2.sp,
        fontFamily = RubikFontFamilyNormal,
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        letterSpacing = 0.2.sp,
        fontFamily = RubikFontFamilyLight,
        lineHeight = 16.sp * 1.4f
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyNormal,
        lineHeight = 14.sp * 1.4f
    ),

    labelSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(700),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyNormal,
        lineHeight = 14.sp * 1.4f
    ),
    labelMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(700),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyNormal,
        lineHeight = 14.sp * 1.4f
    ),
)


val TitleStyle = TextStyle(
    fontSize = 28.sp,
    fontWeight = FontWeight(700),
    letterSpacing = 0.1.sp,
    fontFamily = RubikFontFamilyBold
)

val Title2Style = TextStyle(
    fontSize = 26.sp,
    fontWeight = FontWeight(500),
    letterSpacing = 0.2.sp,
    fontFamily = RubikFontFamilyNormal
)

val TitlePlashStyle = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight(700),
    letterSpacing = 0.2.sp,
    fontFamily = RubikFontFamilyNormal
)

val BodyLightStyle = TextStyle(
    fontSize = 18.sp,
    letterSpacing = 0.2.sp,
    fontFamily = GothamProFontFamilyLight,
    lineHeight = 18.sp * 1.4f
)

val BodyMediumStyle = TextStyle(
    fontSize = 16.sp,
    letterSpacing = 0.2.sp,
    fontFamily = GothamProFontFamilyMedium,
    lineHeight = 16.sp * 1.4f
)

val SemiBoldDescrStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight(700),
    letterSpacing = 0.2.sp,
    fontFamily = RubikFontFamilyNormal
)