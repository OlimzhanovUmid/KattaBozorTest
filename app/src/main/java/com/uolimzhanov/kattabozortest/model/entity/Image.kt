package com.uolimzhanov.kattabozortest.model.entity

/**
 * Created by uolimzhanov on 20.06.2024
 */
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val width: Int? = null,
    val height: Int? = null,
    val url: String? = null
)