package com.uolimzhanov.kattabozortest.model.repository

import com.uolimzhanov.kattabozortest.model.entity.Attribute
import com.uolimzhanov.kattabozortest.model.entity.Image
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
        /*api.getOffers().source().use { source ->
            // Для избежания создания лишнего дата класса
            val response = Json.decodeFromBufferedSource(JsonElement.serializer(), source)
                .jsonObject["offers"]
            Timber.tag("response").d(response.toString())
            val offersArray = response!!.jsonArray
            return Json.decodeFromJsonElement(ListSerializer(Offer.serializer()), offersArray)
        }*/
        return listOf(
            Offer(
                id = 1,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 2,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 3,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 4,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 5,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 6,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 7,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 8,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),

            Offer(
                id = 9,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 10,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 11,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 12,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 13,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 14,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 15,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 16,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 17,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 18,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 19,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            ),
            Offer(
                id = 20,
                name = "Google pixel 5",
                brand = "Google",
                merchant = "Ali",
                attributes = listOf(
                    Attribute(
                        name = "ram",
                        value = "8gb"
                    )
                ),
                image = Image(
                    width = 154,
                    height = 124,
                    url = null
                )
            )
        )
    }

}