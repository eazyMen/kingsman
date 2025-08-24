package ru.amria.designsystem.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.R
import ru.amria.designsystem.common.CommonButton
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.KingsmanTheme

@Composable
fun BannerWidget(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(158.dp)
            .background(
                color = KingsmanTheme.extraColors.bannerBGColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(start = 16.dp)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CommonText(
                text = "Новое поступление",
                textStyle = MaterialTheme.typography.titleMedium
            )
            CommonText(
                text = "Скидка на обувь из\n" +
                        "новой коллекции 30%",
                textStyle = MaterialTheme.typography.bodyMedium
            )
            CommonButton(
                text = "Посмотреть"
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .height(155.dp)
                .fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.bg_banner_logo),
                contentDescription = null
            )
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.boots),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun BannerWidgetPreview() {
    KingsmanTheme {
        BannerWidget()
    }
}