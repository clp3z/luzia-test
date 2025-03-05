package com.clp3z.luziatest.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.luziatest.domain.GetPlanetUseCase
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPlanetUseCase: GetPlanetUseCase
): ViewModel() {

    data class ViewState(
        val error: Error? = null,
        val isLoading: Boolean = true,
        val planet: Planet? = null
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    fun initialize(url: String) = viewModelScope.launch {
        getPlanetUseCase(url = url).fold(
            ifLeft = { error ->
                _viewState.update {
                    it.copy(error = error, isLoading = false)
                }
            },
            ifRight = { planet ->
                _viewState.update {
                    it.copy(planet = planet, isLoading = false)
                }
            }
        )
    }
}
