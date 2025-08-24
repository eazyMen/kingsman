package ru.amria.domain.repository

import ru.amria.domain.models.MyImage

interface FashnRepository {
    fun myImages(): List<MyImage>
    suspend fun run(modelUrl: String, garmentUrl: String): RunResponse
    suspend fun status(id: String): StatusResponse
}