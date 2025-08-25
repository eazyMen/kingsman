package ru.amria.designsystem.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.R
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.designsystem.theme.TitleStyle

@Composable
fun CommonTopBar(
    titleText: String = "",
    titleTextColor: Color = KingsmanTheme.extraColors.textDark,
    iconColor: Color = KingsmanTheme.extraColors.iconColor,
    titleAlignment: TextAlign = TextAlign.Center,
    icBack: Int = R.drawable.ic_back,
    icEnd: Int? = null,
    onBackClick: (() -> Unit)? = null,
    onEndButtonClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (onBackClick == null) {
            IconButton(onClick = { }) {
                Spacer(Modifier.width(24.dp))
            }
        }
        onBackClick?.let {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(icBack),
                    contentDescription = null,
                    tint = iconColor
                )
            }
        }
        Text(
            modifier = Modifier.weight(1f),
            style = TitleStyle,
            text = titleText,
            color = titleTextColor,
            textAlign = titleAlignment
        )
        if (icEnd == null) {
            IconButton(onClick = { }) {
                Spacer(Modifier.width(24.dp))
            }
        }
        icEnd?.let {
            IconButton(onClick = onEndButtonClick) {
                Image(
                    painter = painterResource(icEnd),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}


@Preview
@Composable
fun TopBarPreview() {
    CommonTopBar()
}