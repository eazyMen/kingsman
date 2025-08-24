package ru.amria.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme()

private val LightColorScheme = darkColorScheme()

@Immutable
data class KingsmanExtraColors(
    val textPrimary: Color = Color.Unspecified,
    val textDark: Color = Color.Unspecified,
    val secondaryText: Color = Color.Unspecified,
    val lightBannerTextColor: Color = Color.Unspecified,
    val backgroundColor: Color = Color.Unspecified,
    val white: Color = Color.Unspecified,
    val containerColor: Color = Color.Unspecified,
    val primaryButtonBGColor: Color = Color.Unspecified,
    val italyContainerColor: Color = Color.Unspecified,
    val frenchContainerColor: Color = Color.Unspecified,
    val clothCardBG: Color = Color.Unspecified,
    val bannerBGColor: Color = Color.Unspecified,
    val unselectBGColor: Color = Color.Unspecified,
    val chainEducationBGColor: List<Pair<Float, Color>> = emptyList<Pair<Float, Color>>(),
    val foreignWordsEducationBGColor: List<Pair<Float, Color>> = emptyList<Pair<Float, Color>>(),
    val numberEducationBGColor: List<Pair<Float, Color>> = emptyList<Pair<Float, Color>>(),
    val iconColor: Color = Color.Unspecified,
    val trackColor: Color = Color.Unspecified,
    val dividerColor: Color = Color.Unspecified,
    val trackIndicatorColor: Color = Color.Unspecified,
    val learnWordContainerColor: List<Pair<Float, Color>> = emptyList<Pair<Float, Color>>(),
    val repeatWordContainerColor: List<Pair<Float, Color>> = emptyList<Pair<Float, Color>>(),
    val shimmerColors: List<Color> = emptyList<Color>(),
)

private val LocalExtraColors = staticCompositionLocalOf {
    DarkExtraColors
}

private val DarkExtraColors = KingsmanExtraColors(
    textPrimary = TEXT_WHITE,
    textDark = TEXT_DARK,
    secondaryText = TEXT_SECONDARY,
    lightBannerTextColor = LIGHT_BANNER_TEXT,
    backgroundColor = WHITE_BG,
    white = WHITE_BG,
    containerColor = DARK_CONTAINER,
    primaryButtonBGColor = BG_BUTTON_PRIMARY,
    italyContainerColor = BG_ITALY_CATEGORY,
    frenchContainerColor = BG_FRENCH_CATEGORY,
    clothCardBG = CLOTH_CARD_BG,
    bannerBGColor = BG_BANNER_COLOR,
    iconColor = DARK_ICON_COLOR,
    trackColor = TRACK_COLOR,
    unselectBGColor = UNSELECT_COLOR,
    trackIndicatorColor = TRACK_INDICATOR_COLOR,
    learnWordContainerColor = LEARN_WORD_CONTAINER_BG,
    repeatWordContainerColor = REPEAT_WORD_CONTAINER_BG,
    chainEducationBGColor = CHAIN_EDUCATION_BG,
    foreignWordsEducationBGColor = FOREIGN_WORDS_EDUCATION_BG,
    numberEducationBGColor = NUMBER_EDUCATION_BG,
    dividerColor = DIVIDER,
    shimmerColors = listOf(SHIMMER_LIGHT, SHIMMER_DARK, SHIMMER_LIGHT)
)

@Composable
fun KingsmanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    var extraColors: KingsmanExtraColors
    val colorScheme: ColorScheme
    when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
        darkTheme -> {
            colorScheme = DarkColorScheme
            extraColors = DarkExtraColors
        }

        else -> {
            colorScheme = DarkColorScheme
            extraColors = DarkExtraColors
        }
    }
    CompositionLocalProvider(LocalExtraColors provides extraColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

object KingsmanTheme {
    val extraColors: KingsmanExtraColors
        @Composable
        get() = LocalExtraColors.current
}
