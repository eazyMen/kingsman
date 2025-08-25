package ru.amria.designsystem.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.R
import ru.amria.designsystem.theme.BodyLightStyle
import ru.amria.designsystem.theme.BodyMediumStyle
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.designsystem.theme.TitleStyle

@Composable
fun PagerWithIndicator(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val pagerState = rememberPagerState(pageCount = { 4 })

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) { page ->
            when (page) {
                0 -> {
                    FirstTutorial(
                        icon = R.drawable.ic_clear_logo,
                        title = "Добро пожаловать в\n" + "Mr.Kingsman",
                        description = "Твой гид в мире\n" + "классического стиля",
                        false
                    )
                }

                1 -> {
                    FirstTutorial(
                        icon = R.drawable.second,
                        title = "ПОПРОБУЙ \n" + "ЧЕРЕЗ КАМЕРУ",
                        description = "Примеряй аксессуары в режиме \nдополненной реальности",
                        false
                    )
                }

                2 -> {
                    FirstTutorial(
                        icon = R.drawable.thrid,
                        title = "ПРИМЕРЯЙ ОДЕЖДУ\n" + "В ПРИЛОЖЕНИИ",
                        description = "Загрузи свое фото в личном \nкабинете и примеряй одежду из \nкаталога прямо на себе",
                        false
                    )
                }

                3 -> {
                    FirstTutorial(
                        icon = R.drawable.four,
                        title = "СТАНЬ УЧАСТНИКОМ \nКЛУБА",
                        description = "Получай бонусы за каждую \nпокупку",
                        true,
                        onClick = onClick
                    )
                }
            }

        }

        Spacer(Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pagerState.pageCount) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .size(if (isSelected) 12.dp else 8.dp)
                        .clip(CircleShape)
                        .background(
                            if (isSelected) Color.White else Color.LightGray
                        )
                )
            }
        }
    }
}

@Composable
fun FirstTutorial(
    icon: Int,
    title: String,
    description: String,
    showBtn: Boolean,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(
                color = KingsmanTheme.extraColors.bannerBGColor,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(12.dp))
        CommonText(
            text = title,
            textStyle = TitleStyle,
            textColor = KingsmanTheme.extraColors.textPrimary2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(26.dp))
        CommonText(
            text = description,
            textStyle = BodyLightStyle,
            textColor = KingsmanTheme.extraColors.textPrimary2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(34.dp))
        if (showBtn)
            CommonButton(
                modifier = Modifier
                    .clickable {
                        onClick()
                    }
                    .padding(
                        horizontal = 34.dp,
                        vertical = 8.dp
                    ),
                textStyle = BodyMediumStyle,
                text = "НАЧАТЬ",
            )
    }
}
