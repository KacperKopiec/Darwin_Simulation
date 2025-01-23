package org.example.model

import org.example.model.Vector2d.Companion.toUnitVector

class Animal(private var position: Vector2d = Vector2d(2, 2)) {
    private var orientation: MapDirection = MapDirection.NORTH

    fun getPosition(): Vector2d = position

    fun getOrientation(): MapDirection = orientation

    fun setPosition(position: Vector2d) {
        this.position = position
    }

    override fun toString(): String = orientation.toString()

    fun isAt(position: Vector2d): Boolean = this.position.equals(position)

    fun move(direction: MoveDirection, map: WorldMap) {
        when (direction) {
            MoveDirection.RIGHT -> this.orientation.next()
            MoveDirection.LEFT -> this.orientation.previous()
            else -> {
                val nextPosition: Vector2d = if (direction == MoveDirection.FORWARD) {
                    this.position + this.orientation.toUnitVector()
                } else {
                    this.position - this.orientation.toUnitVector()
                }

                if (map.canMoveTo(nextPosition)) {
                    position = nextPosition
                }
            }
        }
    }
}