package ru.resodostudios.movies.feature.movies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Network(
    val country: Country? = null,
    val id: Int? = null,
    val name: String? = null,
    val officialSite: String? = null
)