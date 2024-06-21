package com.uolimzhanov.kattabozortest.ui.screens

import com.uolimzhanov.kattabozortest.model.entity.Offer

/**
 * Created by uolimzhanov on 21.06.2024
 */
data class OffersScreenState(
    val offers: List<Offer> = emptyList(),
    val isLoading: Boolean = false
)
