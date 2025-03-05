package com.clp3z.luziatest.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.luziatest.domain.GetPlanetsUseCase
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPlanetsUseCase: GetPlanetsUseCase
) : ViewModel() {

    data class ViewState(
        val error: Error? = null,
        val isLoading: Boolean = true,
        val planets: List<Planet> = emptyList()
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    private var page = 2

    fun initialize() = viewModelScope.launch {
        getPlanetsUseCase(page = page).fold(
            ifLeft = { error ->
                _viewState.update {
                    it.copy(error = error, isLoading = false)
                }
            },
            ifRight = { planets ->
                _viewState.update {
                    it.copy(planets = planets, isLoading = false)
                }
            }
        )
    }
}
