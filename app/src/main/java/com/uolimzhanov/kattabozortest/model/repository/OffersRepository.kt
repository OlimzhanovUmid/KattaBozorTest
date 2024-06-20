package com.uolimzhanov.kattabozortest.model.repository

import com.uolimzhanov.kattabozortest.model.entity.Offer

/**
 * Created by uolimzhanov on 20.06.2024
 */
interface OffersRepository {
    suspend fun getOffers(): List<Offer>
}