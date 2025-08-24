package ru.amria.kingman.ui.fashn

import ru.amria.domain.models.MyImage


data class FashnUiState(
    val myImages: List<MyImage> = emptyList<MyImage>(),
    val resultImage: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)