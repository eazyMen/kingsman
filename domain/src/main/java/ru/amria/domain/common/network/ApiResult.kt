package ru.amria.domain.common.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

sealed class ApiResult<out T>() {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error<V>(val throwable: String) : ApiResult<V>()
    object Loading : ApiResult<Nothing>()
    object Empty : ApiResult<Nothing>()
}

inline fun <T : Any> ApiResult<T>.onSuccess(block: (T) -> Unit): ApiResult<T> {
    if (this is ApiResult.Success) block(this.data)
    return this
}

inline fun <T : Any> ApiResult<T>.onError(block: (String) -> Unit): ApiResult<T> {
    if (this is ApiResult.Error) block(this.throwable)
    return this
}

suspend fun <T : Any> suspendCallForResult(
    coroutineScope: CoroutineContext = Dispatchers.IO,
    call: suspend () -> T?
): ApiResult<T> =
    try {
        withContext(coroutineScope) {
            call()?.let {
                ApiResult.Success(it)
            } ?: ApiResult.Empty
        }
    } catch (e: Exception) {
        ApiResult.Error(e.message.toString())
    }


//suspend fun ff(authApi: AuthApi) {
//    authApi.login("", "").resultRow { it ->
//        when (it) {
//            is ApiResult.Success<TokenDTO> -> {
//                it.data.refreshToken
//            }
//
//            is ApiResult.Error -> {
//
//            }
//
//            is ApiResult.Loading -> {
//            }
//        }
//    })

//}
//
//suspend inline fun <T> Result<T>.resultRow( processApiResult: (ApiResult) -> Unit) {
//    processApiResult(ApiResult.Loading)
//    try {
//        onSuccess {
//            processApiResult(ApiResult.Success(it))
//        }.onFailure {
//            processApiResult(ApiResult.Error(it))
//        }
//    } catch (e: Exception) {
//        processApiResult(ApiResult.Error(e))
//    }
//}
