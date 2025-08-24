package ru.amria.domain.home

import ru.amria.domain.models.dress.CategoryType
import ru.amria.domain.models.dress.Dress

interface HomeRepository {
    fun getDress(categoryType: CategoryType): List<Dress>
}