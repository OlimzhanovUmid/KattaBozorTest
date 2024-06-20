package com.uolimzhanov.kattabozortest.model.entity

/**
 * Created by uolimzhanov on 20.06.2024
 */
import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    val id: Int? = null,
    val name: String? = null,
    val brand: String? = null,
    val category: String? = null,
    val merchant: String? = null,
    val attributes: List<Attribute?>? = null,
    val image: Image? = null
)