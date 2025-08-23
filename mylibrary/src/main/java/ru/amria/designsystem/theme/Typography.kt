package ru.amria.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.amria.designsystem.R

val RubikFontFamilyBold = FontFamily(
    Font(R.font.rubik_one, FontWeight.Bold),
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


val Typography = Typography(
    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight(300),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyNormal,
    ),
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(300),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyNormal,
    ),
    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(300),
        letterSpacing = 0.1.sp,
        fontFamily = RubikFontFamilyNormal,
    ),
    bodyLarge = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(400),
        letterSpacing = 0.2.sp,
        fontFamily = RubikFontFamilyNormal,
        lineHeight = 20.sp * 1.4f
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
    fontFamily = RubikFontFamilyNormal
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

val BodyPlashStyle = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight(400),
    letterSpacing = 0.2.sp,
    fontFamily = RubikFontFamilyNormal
)

val SemiBoldDescrStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight(700),
    letterSpacing = 0.2.sp,
    fontFamily = RubikFontFamilyNormal
)