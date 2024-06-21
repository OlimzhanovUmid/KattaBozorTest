package com.uolimzhanov.kattabozortest.model.repository

import com.uolimzhanov.kattabozortest.model.entity.Offer
import com.uolimzhanov.kattabozortest.model.network.OffersApiService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import timber.log.Timber

/**
 * Created by uolimzhanov on 20.06.2024
 */
@OptIn(ExperimentalSerializationApi::class)
class OffersRepositoryImpl(
    private val api: OffersApiService
) : OffersRepository {

    override suspend fun getOffers(): List<Offer> {
        api.getOffers().source().use { source ->
            // Для избежания создания лишнего дата класса
            val response = Json.decodeFromBufferedSource(JsonElement.serializer(), source)
                .jsonObject["offers"]
            Timber.tag("response").d(response.toString())
            val offersArray = response!!.jsonArray
            return Json.decodeFromJsonElement(ListSerializer(Offer.serializer()), offersArray)
        }
    }

}