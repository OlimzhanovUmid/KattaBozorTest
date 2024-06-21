package com.uolimzhanov.kattabozortest.ui.navgraphs

import kotlinx.serialization.Serializable

/**
 * Created by uolimzhanov on 21.06.2024
 */
sealed interface Screens {
    @Serializable
    data object Offers: Screens
}