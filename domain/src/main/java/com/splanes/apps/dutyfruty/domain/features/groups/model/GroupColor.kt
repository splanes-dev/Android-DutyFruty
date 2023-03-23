package com.splanes.apps.dutyfruty.domain.features.groups.model

enum class GroupColor(val id: Int) {
    Blue(id = 0),
    Yellow(id = 1),
    Orange(id = 2),
    Green(id = 3),
    Red(id = 4),
    Fuchsia(id = 5),
    Cyan(id = 6),
    ;

    companion object {
        fun of(id: Int?) = values().run {
            find { c -> c.id == id } ?: random()
        }
    }
}