package ru.amria.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class MyImage(
    val name: String,
    val imgUrl: String
)