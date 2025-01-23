package org.example.model

enum class MapDirection(private val stringRepresentation: String) {
    NORTH("^"),
    SOUTH("v"),
    WEST("<"),
    EAST(">");

    override fun toString(): String = stringRepresentation

    fun next(): MapDirection {
        return when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }

    fun previous(): MapDirection {
        return when (this) {
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            EAST -> NORTH
        }
    }
}