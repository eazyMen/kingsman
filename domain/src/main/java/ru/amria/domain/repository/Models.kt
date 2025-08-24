package ru.amria.domain.repository

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject


@Serializable data class RunRequest(val model_name: String, val inputs: JsonObject)
@Serializable data class RunResponse(val id: String? = null, val error: JsonElement? = null)
@Serializable data class StatusResponse(
    val id: String,
    val status: String,
    val output: List<String>? = null,
    val error: JsonElement? = null
)
