package com.uolimzhanov.kattabozortest.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uolimzhanov.kattabozortest.model.repository.OffersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Created by uolimzhanov on 21.06.2024
 */
class OffersViewModel(
    private val offersRepo: OffersRepository
): ViewModel() {
    private val _state = MutableStateFlow(OffersScreenState())
    val state = _state.asStateFlow()

    init {
        onGetOffers()
    }

    fun onGetOffers() {
        _state.value = _state.value.copy(
            isLoading = true
        )
        viewModelScope.launch {
            _state.value = _state.value.copy(
                offers = offersRepo.getOffers(),
            )
        }
        _state.value = _state.value.copy(
            isLoading = false
        )
    }
}