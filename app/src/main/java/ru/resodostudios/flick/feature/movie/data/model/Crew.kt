package ru.resodostudios.flick.feature.movie.data.model

import kotlinx.serialization.Serializable
import ru.resodostudios.flick.feature.people.domain.model.Person

@Serializable
data class Crew(
    val person: Person? = Person(),
    val type: String? = null
)