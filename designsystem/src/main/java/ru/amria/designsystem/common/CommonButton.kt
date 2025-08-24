package ru.amria.designsystem.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.theme.KingsmanTheme

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color = KingsmanTheme.extraColors.white,
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
    textColor: Color = KingsmanTheme.extraColors.textPrimary,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) {
    Row(
        modifier = modifier
            .background(
                color = bgColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(paddingValues)
    ) {
        Text(
            modifier = modifier,
            text = text,
            color = textColor,
            style = textStyle
        )
    }
}

@Preview
@Composable
fun CommonButtonPreview() {
    KingsmanTheme {
        CommonButton(
            text = "Посмотреть"
        )
    }
}