package org.example.model

import kotlin.math.max
import kotlin.math.min

open class Vector2d(private val x: Int, private val y: Int) {
    fun getX(): Int = x

    fun getY(): Int = y

    override fun toString(): String = "(${x},${y})"

    fun procedes(other: Vector2d): Boolean = (x <= other.x && y <= other.y)

    fun follows(other: Vector2d): Boolean = (other.x <= x && other.y <= y)

    fun add(other: Vector2d): Vector2d = Vector2d(x + other.x, y + other.y)

    fun subtract(other: Vector2d): Vector2d = Vector2d(x - other.x, y - other.y)

    fun upperRight(other: Vector2d): Vector2d = Vector2d(max(x, other.x), max(y, other.y))

    fun lowerLeft(other: Vector2d): Vector2d = Vector2d(min(x, other.x), min(y, other.y))

    fun opposite(): Vector2d = Vector2d(-x, -y)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other === null || javaClass != other.javaClass) return false
        other as Vector2d
        return (x == other.x && y == other.y)
    }

    override fun hashCode(): Int = 31 * x + y

    operator fun plus(other: Vector2d): Vector2d = this.add(other)

    operator fun minus(other: Vector2d): Vector2d = this.subtract(other)

    operator fun compareTo(other: Vector2d): Int {
        return if (this.procedes(other)) -1
        else if (this.follows(other)) 1
        else 0
    }

    companion object { // extension functions weren't working without this
        fun MapDirection.toUnitVector(): Vector2d = when (this) {
            MapDirection.NORTH -> Vector2d(0, 1)
            MapDirection.SOUTH -> Vector2d(0, -1)
            MapDirection.EAST -> Vector2d(1, 0)
            MapDirection.WEST -> Vector2d(-1, 0)
        }
    }
}

