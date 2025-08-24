package ru.amria.domain.models.dress

import kotlinx.serialization.Serializable

@Serializable
sealed class CategoryType {
    @Serializable
    object Shirt: CategoryType()
    @Serializable
    object Keda: CategoryType()
    @Serializable
    object Watch: CategoryType()
    @Serializable
    object Britches: CategoryType()
    @Serializable
    object Glass: CategoryType()
    @Serializable
    object Cap: CategoryType()
}