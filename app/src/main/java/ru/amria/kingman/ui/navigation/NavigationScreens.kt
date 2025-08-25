package ru.amria.kingman.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class FashnScreen(
    val img: String,
    val name: String,
    val price: Int,
)

@Serializable
object Tutorial

@Serializable
object Account
