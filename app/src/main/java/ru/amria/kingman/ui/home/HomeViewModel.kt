package ru.amria.kingman.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.amria.designsystem.R
import ru.amria.designsystem.widget.CategoryItem
import ru.amria.domain.home.HomeRepository
import ru.amria.domain.models.dress.CategoryType
import ru.amria.domain.models.dress.Dress
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(
        HomeUiState(
            categories = categories
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        _uiState.update {
            it.copy(dresses = homeRepository.getDress(it.categories.first().categoryType))
        }
    }

    fun setBasket(dress: Dress) {
        _uiState.update {
            it.copy(basket = it.basket.plus(dress))
        }
    }

    fun changeCategory(categoryType: CategoryType) {
        _uiState.update {
            it.copy(
                dresses = homeRepository.getDress(categoryType),
                categories = it.categories.map { it.copy(isSelected = it.categoryType == categoryType) }
            )
        }
    }

}

private val categories = listOf<CategoryItem>(
    CategoryItem(
        "Верх",
        true,
        CategoryType.Shirt,
        R.drawable.ic_wear
    ),
    CategoryItem(
        "Очки",
        false,
        CategoryType.Glass,
        R.drawable.ic_glass
    ),
    CategoryItem(
        "Часы",
        false,
        CategoryType.Watch,
        R.drawable.ic_watch_category
    ),
    CategoryItem(
        "Обувь",
        false,
        CategoryType.Keda,
        R.drawable.foot
    ),
    CategoryItem(
        "Кепки",
        false,
        CategoryType.Cap,
        R.drawable.ic_cap
    ),
)