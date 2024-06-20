package com.uolimzhanov.kattabozortest.model.network

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Created by uolimzhanov on 20.06.2024
 */
interface OffersApiService {
    @GET("offers")
    suspend fun getOffers(): ResponseBody
}