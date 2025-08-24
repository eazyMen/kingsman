package ru.amria.kingman.ui.fashn

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.amria.domain.common.network.onSuccess
import ru.amria.domain.repository.FashnRepository
import javax.inject.Inject

@HiltViewModel
class FashnViewModel @Inject constructor(
    val repository: FashnRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        FashnUiState(
            myImages = repository.myImages()
        )
    )
    val uiState: StateFlow<FashnUiState> = _uiState

    fun changeImage(modelUrl: String, clothUrl: String) = viewModelScope.launch(Dispatchers.IO) {
        _uiState.update { it.copy(isLoading = true) }
        val response = repository.run(modelUrl, clothUrl)
        response.onSuccess {
            it.id?.let {
                while (true) {
                    repository.status(it).onSuccess { imageData ->
                        when (imageData.status) {
                            "completed" -> {
                                _uiState.update {
                                    it.copy(
                                        resultImage = imageData.output?.firstOrNull().orEmpty(),
                                        isLoading = false
                                    )
                                }
                                return@launch
                            }
                            "failed" -> println(imageData.error)
                        }
                        delay(700)
                    }
                }
            }
        }
    }

}