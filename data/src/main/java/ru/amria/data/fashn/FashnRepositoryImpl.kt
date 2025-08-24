package ru.amria.data.fashn

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import ru.amria.domain.common.network.suspendCallForResult
import ru.amria.domain.models.MyImage
import ru.amria.domain.repository.FashnRepository
import ru.amria.domain.repository.RunRequest
import ru.amria.domain.repository.RunResponse
import ru.amria.domain.repository.StatusResponse
import javax.inject.Inject

@Serializable
data class TryOnInputs(
    @SerializedName("model_image") val modelImage: String,
    @SerializedName("garment_image") val garmentImage: String,
    val mode: String = "performance",          // "performance" | "balanced" | "quality"
    @SerializedName("output_format") val outputFormat: String = "jpeg", // "png" | "jpeg"
    @SerializedName("return_base64") val returnBase64: Boolean = false
)

@Serializable
data class RunRequestTryOn(
    @SerializedName("model_name") val modelName: String = "tryon-v1.6",
    val inputs: TryOnInputs
)

class FashnRepositoryImpl @Inject constructor(private val api: FashnApi) : FashnRepository {
    override fun myImages(): List<MyImage> = listOf(
        MyImage(
            "Вечерний",
            "https://s3.regru.cloud/images-zapominashka/uploads/c63bd600-3ff7-4614-8843-d9c6f6555782_7071758302.png"
        ),
        MyImage(
            "Строгий",
            "https://s3.regru.cloud/images-zapominashka/uploads/5e17d5a9-8050-4f58-8f56-eafe867e8050_7358229015.png"
        ),
        MyImage(
            "Повседневный",
            "https://s3.regru.cloud/images-zapominashka/uploads/dd354dfa-0e8f-4d52-b739-985c93260e2a_7778253352.png"
        ),
    )

    override suspend fun run(modelUrl: String, garmentUrl: String) = suspendCallForResult {
        val body = RunRequestTryOn(inputs = TryOnInputs(modelUrl, garmentUrl))
        api.run(body)
    }

    override suspend fun status(id: String) = suspendCallForResult {
        api.status(id)
    }
}