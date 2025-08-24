package ru.amria.designsystem.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.R
import ru.amria.designsystem.common.CommonText
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.domain.models.dress.CategoryType

data class CategoryItem(
    val name: String,
    val isSelected: Boolean,
    val categoryType: CategoryType,
    val icon: Int,
)

val list = listOf<CategoryItem>(
    CategoryItem(
        "Обувь",
        true,
        CategoryType.Keda,
        R.drawable.foot
    ),
    CategoryItem(
        "Часы",
        false,
        CategoryType.Watch,
        R.drawable.ic_watch_category
    ),
)

@Composable
fun CategoryWidget(
    modifier: Modifier = Modifier,
    categoryItem: CategoryItem,
    onClick: (CategoryType) -> Unit = {}
) {
    val isSelected = categoryItem.isSelected
    Row(
        modifier = modifier
            .background(
                color = if (isSelected)
                    KingsmanTheme.extraColors.bannerBGColor
                else
                    KingsmanTheme.extraColors.unselectBGColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick(categoryItem.categoryType)
            }
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(categoryItem.icon),
            contentDescription = null,
            tint = if (isSelected)
                KingsmanTheme.extraColors.white
            else
                KingsmanTheme.extraColors.textDark
        )
        Spacer(modifier = Modifier.width(4.dp))
        CommonText(
            text = categoryItem.name,
            textColor = if (isSelected)
                KingsmanTheme.extraColors.white
            else
                KingsmanTheme.extraColors.textDark
        )
    }
}

@Preview
@Composable
fun CategoryWidgetPreview() {
    KingsmanTheme {
        CategoryWidget(
            categoryItem = CategoryItem(
                "Обувь",
                true,
                CategoryType.Keda,
                R.drawable.foot
            )
        )
    }
}