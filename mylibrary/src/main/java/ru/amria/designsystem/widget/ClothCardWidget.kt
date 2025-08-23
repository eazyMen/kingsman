package ru.amria.designsystem.widget

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun ClothCardWidget(
    onAR: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = KingsmanTheme.extraColors.clothCardBG,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(152.dp),
                    painter = painterResource(R.drawable.boots),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .padding(bottom = 10.dp, end = 10.dp)
                        .size(30.dp)
                        .align(Alignment.BottomEnd)
                        .clickable {
                            onAR()
                        },
                    painter = painterResource(R.drawable.ic_ar),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        CommonText(
            textColor = KingsmanTheme.extraColors.textDark,
            text = "Кожанные кеды"
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CommonText(
                textColor = KingsmanTheme.extraColors.textDark,
                modifier = Modifier,
                text = "12 000 ₽"
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(R.drawable.ic_basket_add),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview
@Composable
fun ClothCardWidgetPreview() {
    KingsmanTheme {
        ClothCardWidget()
    }
}