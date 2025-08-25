package ru.amria.kingman.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class FashnScreen(
    val img: String,
    val name: String
)

@Serializable
object Tutorial
