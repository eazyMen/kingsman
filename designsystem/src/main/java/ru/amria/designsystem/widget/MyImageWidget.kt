package ru.amria.designsystem.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.common.CommonImage
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.BodyLightStyle16
import ru.amria.designsystem.theme.BodyMediumStyle
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.domain.models.MyImage

@Composable
fun MyImageWidget(
    image: MyImage,
    onSelect: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .background(
                    color = KingsmanTheme.extraColors.clothCardBG,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Box {
                CommonImage(
                    modifier = Modifier
                        .width(117.dp)
                        .height(137.dp)
                        .clickable {
                            onSelect(image.imgUrl)
                        },
                    imageUrl = image.imgUrl
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        CommonText(
            textColor = KingsmanTheme.extraColors.textDark,
            text = image.name,
            textStyle = BodyMediumStyle
        )
    }
}

@Preview
@Composable
fun MyImageWidgetPreview() {
    KingsmanTheme {
        MyImageWidget(MyImage("name", "url"))
    }
}