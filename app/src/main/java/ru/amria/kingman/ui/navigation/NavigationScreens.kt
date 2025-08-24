package ru.amria.kingman.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class FashnScreen(
    val imgUrl: String
)
