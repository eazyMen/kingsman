package ru.amria.kingman.ui.home

import ru.amria.designsystem.widget.CategoryItem
import ru.amria.domain.models.dress.Dress

data class HomeUiState(
    val dresses: List<Dress> = emptyList<Dress>(),
    val categories: List<CategoryItem> = emptyList<CategoryItem>(),
    val basket: List<Dress> = emptyList<Dress>(),
    val isLoading: Boolean = false,
    val error: String? = null,
)