package ru.amria.kingman.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.amria.designsystem.base.BaseScaffoldContainer
import ru.amria.designsystem.theme.KingsmanTheme
import ru.amria.designsystem.widget.BannerWidget
import ru.amria.designsystem.widget.CategoryWidget
import ru.amria.designsystem.widget.ClothCardWidget

@Composable
fun HomeScreen(
    onDetail: () -> Unit = {},
    onFitting: (String, String) -> Unit = {_,_->},
    onAR: (String) -> Unit = {},
) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val state = viewModel.uiState.collectAsState()

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
                    val categories = state.value.categories
                    items(categories.size) {
                        CategoryWidget(
                            categoryItem = categories[it],
                            modifier = Modifier,
                            onClick = {
                                viewModel.changeCategory(it)
                            }
                        )
                    }
                }
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(2.dp))
            }
            items(state.value.dresses) { dress ->
                ClothCardWidget(dress, onAR, onFitting = {
                    onFitting(it.img, it.name)
                }, onDetail)
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