package org.example.model

interface WorldMap {
    fun place(animal: Animal): Boolean

    fun isOccupied(position: Vector2d): Boolean

    fun objectAt(position: Vector2d): Any?

    fun canMoveTo(position: Vector2d): Boolean
}