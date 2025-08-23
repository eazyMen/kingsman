package ru.amria.designsystem.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.R
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.KingsmanTheme

@Composable
fun CategoryWidget(
    isSelected: Boolean = false
) {
    Row(
        modifier = Modifier
            .background(
                color = KingsmanTheme.extraColors.bannerBGColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(32.dp),
            painter = painterResource(R.drawable.foot),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        CommonText(
            text = "Обувь"
        )
    }
}

@Preview
@Composable
fun CategoryWidgetPreview() {
    KingsmanTheme {
        CategoryWidget()
    }
}