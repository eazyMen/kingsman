package ru.amria.kingman.ui.fashn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.amria.designsystem.R
import ru.amria.designsystem.base.BaseScaffoldContainer
import ru.amria.designsystem.common.CommonImage
import ru.amria.designsystem.common.CommonProgress
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.BodyMediumStyle
import ru.amria.designsystem.theme.BodyMediumStyle12
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.designsystem.widget.ClothCardWidget
import ru.amria.designsystem.widget.MyImageWidget
import ru.amria.domain.models.dress.CategoryType
import ru.amria.domain.models.dress.Dress

@Composable
fun FashnScreenCompose(
    image: String,
    name: String,
    price: Int,
) {
    val viewModel = hiltViewModel<FashnViewModel>()
    val state = viewModel.uiState.collectAsState()

    BaseScaffoldContainer(
        title = "Примерка"
    ) { pv, sc ->
        Column(
            modifier = Modifier.padding(pv)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .background(
                            color = KingsmanTheme.extraColors.white,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    verticalArrangement = Arrangement.Center,
                ) {
                    CommonImage(
                        modifier = Modifier.size(130.dp),
                        imageUrl = "https://s3.regru.cloud/images-zapominashka/uploads/${image}",
                        contentScale = ContentScale.Fit
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Column {
                    CommonText(
                        text = name,
                        textColor = KingsmanTheme.extraColors.textDark,
                        textStyle = BodyMediumStyle
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    CommonText(
                        text = "Идеально подойдет под \nповседневный образ",
                        textColor = KingsmanTheme.extraColors.secondaryText,
                        textStyle = BodyMediumStyle12
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CommonText(
                            text = "$price ₽",
                            textColor = KingsmanTheme.extraColors.textDark,
                            textStyle = BodyMediumStyle
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )
                        Image(
                            modifier = Modifier
                                .weight(1f)
                                .size(30.dp),
                            painter = painterResource(R.drawable.ic_basket_add),
                            contentDescription = null
                        )
                    }
                }
            }
            if (!state.value.isLoading && state.value.resultImage == null) {
                Spacer(modifier = Modifier.height(12.dp))
                CommonText(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Выберите образ",
                    textColor = KingsmanTheme.extraColors.textDark,
                    textStyle = BodyMediumStyle
                )
                Spacer(modifier = Modifier.height(14.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(state.value.myImages) {
                        MyImageWidget(it) { img ->
                            viewModel.changeImage(
                                img,
                                "https://s3.regru.cloud/images-zapominashka/uploads/${image}"
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                if (state.value.isLoading) {
                    CommonProgress("Идет примерка")
                } else {
                    if (state.value.resultImage != null) {
                        Column {
                            Spacer(modifier = Modifier.height(16.dp))
                            state.value.resultImage?.let {
                                CommonImage(
                                    modifier = Modifier.height(390.dp),
                                    imageUrl = it,
                                    contentScale = ContentScale.FillHeight
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            CommonText(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                text = "Примерьте к этому кардигану",
                                textColor = KingsmanTheme.extraColors.textDark,
                                textStyle = BodyMediumStyle
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                contentPadding = PaddingValues(horizontal = 16.dp)
                            ) {
                                items(mockData) {
                                    ClothCardWidget(it, isAddBtnShow = false)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun FashnScreenPreview() {
    KingsmanTheme {
        FashnScreenCompose("", "", 10)
    }
}

private val mockData = listOf<Dress>(
    Dress(
        name = "Очки для работы",
        img = "2d290275-6513-4a8b-acd6-f2f22b1c3316_3.png",
        categoryType = CategoryType.Glass,
        price = 5000,
        isAr = true,
        lensId = "48cc7ac6-9df4-454d-8443-943575609977",
        isFitting = true,
        color = "Черный",
        sizes = listOf(22, 23, 24, 25, 26, 27),
    ),
    Dress(
        name = "Очки отечественные",
        img = "1498afcb-9883-497d-896f-d558cac26631_1.png",
        categoryType = CategoryType.Glass,
        price = 12000,
        isAr = true,
        lensId = "48cc7ac6-9df4-454d-8443-943575609977",
        isFitting = true,
        color = "Черный",
        sizes = listOf(22, 23, 24, 25, 26, 27),
    ),
    Dress(
        name = "Очки Матрица",
        img = "2de8f1aa-45ca-46d6-b67e-2c6b46f1c52d_2.png",
        categoryType = CategoryType.Glass,
        price = 20000,
        isAr = true,
        lensId = "48cc7ac6-9df4-454d-8443-943575609977",
        isFitting = true,
        color = "Черный",
        sizes = listOf(22, 23, 24, 25, 26, 27),
    ),
)