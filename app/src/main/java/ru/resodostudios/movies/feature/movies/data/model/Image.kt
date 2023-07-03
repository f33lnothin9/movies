package ru.resodostudios.movies.feature.movies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val medium: String? = null,
    val original: String? = null
)