package ru.amria.kingman.ui.home

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.base.BaseScaffoldContainer
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.designsystem.widget.BannerWidget
import ru.amria.designsystem.widget.CategoryWidget
import ru.amria.designsystem.widget.ClothCardWidget

@Composable
fun HomeScreen(
    onDetail: () -> Unit = {},
    onAR: () -> Unit = {},
) {
    BaseScaffoldContainer(
        title = "Mr.Kingsman"
    ) { pv, ss ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(pv)
                .padding(vertical = 12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column {
                    BannerWidget()
                    Spacer(Modifier.height(16.dp))
                }
            }

            item(span = { GridItemSpan(maxLineSpan) }) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(10) { CategoryWidget() }
                }
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(2.dp))
            }
            items(10) {
                ClothCardWidget(onAR)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    KingsmanTheme {
        HomeScreen()
    }
}