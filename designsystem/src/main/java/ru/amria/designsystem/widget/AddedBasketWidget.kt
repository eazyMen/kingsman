package ru.amria.designsystem.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.R
import ru.amria.designsystem.common.CommonButton
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.BodyLightStyle16
import ru.amria.designsystem.theme.BodyMediumStyle
import ru.amria.designsystem.theme.KingsmanTheme

@Composable
fun AddedBasketWidget(modifier: Modifier, price: Int, count: Int) {
    Row(
        modifier = modifier
            .padding(vertical = 12.dp)
            .padding(end = 16.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CommonButton(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            text = "$price ₽",
            textStyle = BodyMediumStyle,
            bgColor = Color(0xFFEEEEEE),
            textColor = KingsmanTheme.extraColors.textPrimary
        )
        Spacer(modifier = Modifier
            .width(12.dp)
            .weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = KingsmanTheme.extraColors.textPrimary,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CommonText(
                text = "$count товаров"
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(R.drawable.ic_basket_add),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun AddedBasketWidgetPreview() {
    KingsmanTheme {
        AddedBasketWidget(Modifier, 2133, 2)
    }
}