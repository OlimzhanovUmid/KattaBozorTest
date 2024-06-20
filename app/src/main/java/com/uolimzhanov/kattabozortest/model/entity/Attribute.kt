package com.uolimzhanov.kattabozortest.model.entity

/**
 * Created by uolimzhanov on 20.06.2024
 */
import kotlinx.serialization.Serializable

@Serializable
data class Attribute(
    val name: String? = null,
    val value: String? = null
)