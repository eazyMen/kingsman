package ru.amria.data.fashn

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.amria.domain.repository.RunResponse
import ru.amria.domain.repository.StatusResponse

interface FashnApi {
    @POST("/v1/run")
    suspend fun run(@Body body: RunRequestTryOn): RunResponse

    @GET("/v1/status/{id}")
    suspend fun status(@Path("id") id: String): StatusResponse
}