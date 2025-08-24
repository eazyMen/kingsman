package ru.amria.kingman.ui.fashn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.amria.designsystem.base.BaseScaffoldContainer
import ru.amria.designsystem.common.CommonImage
import ru.amria.designsystem.common.CommonProgress
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.designsystem.widget.ClothCardWidget
import ru.amria.designsystem.widget.MyImageWidget

@Composable
fun FashnScreen(
    selectCloth: String = "https://ussuriysk.diamondelectric.ru/images/838/837826/pidjak_mango_1.jpg", //пиджак по умолчанию
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
                            color = KingsmanTheme.extraColors.clothCardBG,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    verticalArrangement = Arrangement.Center,
                ) {
                    CommonImage(modifier = Modifier.size(106.dp), imageUrl = selectCloth)
                }
                Spacer(modifier = Modifier.height(6.dp))
                Column {
                    CommonText(
                        text = "Кожанные кеды",
                        textColor = KingsmanTheme.extraColors.textDark
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    CommonText(
                        text = "Идеально подойдут под повседневный образ",
                        textColor = KingsmanTheme.extraColors.textDark
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state.value.myImages) {
                    MyImageWidget(it) { img ->
                        viewModel.changeImage(img, viewModel.imgUrl)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                contentAlignment = Alignment.Center
            ) {
                if (state.value.isLoading) {
                    CommonProgress("Идет примерка")
                } else {
                    state.value.resultImage?.let {
                        CommonImage(imageUrl = it)
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
        FashnScreen("")
    }
}