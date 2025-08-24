package ru.amria.kingman.ui.navigation

import kotlinx.serialization.Serializable
import ru.amria.domain.models.dress.Dress

@Serializable
object Home

@Serializable
data class FashnScreen(
    val img: String,
    val name: String
)
