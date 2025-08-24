package ru.amria.domain.models.dress

import android.graphics.Color
import kotlinx.serialization.Serializable

@Serializable
data class Dress(
    val name: String,
    val img: String,
    val categoryType: CategoryType,
    val price: Int,
    val isAr: Boolean,
    val lensId: String? = null,
    val isFitting: Boolean,
    val color: String,
    val sizes: List<Int>,
    val description: String = "Супер описание, большое, маленькое, разницы нет, его кто-то читает? Вообще-то есть примерка, теперь не нужно читать описание, просто добавь себя в приложение и собирай подходящие образы",
)