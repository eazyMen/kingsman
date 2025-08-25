package ru.amria.kingman.ui.account

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.amria.designsystem.R
import ru.amria.designsystem.base.BaseScaffoldContainer
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.BodyMediumStyle
import ru.amria.designsystem.theme.BodyMediumStyle12
import ru.amria.designsystem.theme.BodyMediumStyle14
import ru.amria.designsystem.theme.BodyMediumStyle22
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.designsystem.widget.MyImageWidget
import ru.amria.kingman.ui.fashn.FashnViewModel

@Composable
fun AccountScreen(
    onBackClick: () -> Unit = {}
) {
    val viewModel = hiltViewModel<FashnViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    BaseScaffoldContainer(
        title = "Mr.Kingsman",
        onBackClick = onBackClick
    ) { pv, ss ->

        Column(
            modifier = Modifier.padding(horizontal = 12.dp).padding(pv)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 10.dp),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    CommonText(
                        text = "Магомед",
                        textColor = KingsmanTheme.extraColors.textPrimary,
                        textStyle = BodyMediumStyle22
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.ic_location),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        CommonText(
                            text = "Магомед",
                            textColor = KingsmanTheme.extraColors.textPrimary,
                            textStyle = BodyMediumStyle14
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.card),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            val listCat = listOf<AccountCategory>(
                AccountCategory(
                    R.drawable.ic_fav,
                    "Избранное",
                    "5 товаров"
                ),
                AccountCategory(
                    R.drawable.ic_bask,
                    "Корзина",
                    "10 товаров"
                ),
                AccountCategory(
                    R.drawable.ic_star,
                    "Отзывы",
                    "2 товара"
                ),
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(listCat) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth().weight(1f)
                            .background(
                                color = _root_ide_package_.androidx.compose.ui.graphics.Color(
                                    0xFFE9E7F7
                                ),
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(
                                    size = 10.dp
                                )
                            )
                            .padding(vertical = 8.dp, horizontal = 14.dp)
                    ) {
                        Image(painter = painterResource(it.iconId), contentDescription = null)
                        Spacer(modifier = Modifier.height(8.dp))
                        CommonText(
                            text = it.name,
                            textColor = KingsmanTheme.extraColors.textPrimary,
                            textStyle = BodyMediumStyle
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        CommonText(
                            text = it.goodsCount,
                            textColor = KingsmanTheme.extraColors.textPrimary,
                            textStyle = BodyMediumStyle14
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                CommonText(
                    text = "Мои образы",
                    textColor = KingsmanTheme.extraColors.textDark,
                    textStyle = BodyMediumStyle
                )
                Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
                CommonText(
                    text = "добавить",
                    textColor = Color.Blue,
                    textStyle = BodyMediumStyle
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(uiState.value.myImages) {
                    MyImageWidget(it)
                }
            }
        }
    }
}

data class AccountCategory(
    val iconId: Int,
    val name: String,
    val goodsCount: String
)

