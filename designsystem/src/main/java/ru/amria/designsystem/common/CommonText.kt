package ru.amria.designsystem.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import ru.amria.designsystem.theme.KingsmanTheme

@Composable
fun CommonText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = KingsmanTheme.extraColors.white,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        style = textStyle
    )
}