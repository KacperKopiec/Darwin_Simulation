package org.example.model

import org.example.model.RandomExtensions.Companion.randomPosition
import org.example.model.RandomExtensions.Companion.randomFreePosition

class BouncyMap(private val width: Int, private val height: Int): WorldMap {
    private var animals: HashMap<Vector2d, Animal> = HashMap()
    private val lowerLeftCorner = Vector2d(0, 0)
    private val upperRightCorner = Vector2d(width - 1, height - 1)
    private val mapSize = Vector2d(width, height)

    override fun canMoveTo(position: Vector2d): Boolean = (lowerLeftCorner < position && position < upperRightCorner)

    override fun place(animal: Animal): Boolean {
        if (animals.containsValue(animal)) {
            for (pos in animals.keys) {
                if (animals[pos] == animal) {
                    animals.remove(pos)
                    break
                }
            }
        }

        if (!canMoveTo(animal.getPosition())) {
            return false
        }

        if (!isOccupied(animal.getPosition())) {
            animals[animal.getPosition()] = animal
        } else {
            val randomPosition: Vector2d = randomPosition(mapSize) ?: return false
            if (!isOccupied(randomPosition)) {
                animal.setPosition(randomPosition)
                animals[randomPosition] = animal
            } else {
                val randomFreePosition: Vector2d? = randomFreePosition(mapSize)
                if (randomFreePosition == null) {
                    animals.remove(randomPosition)
                    animal.setPosition(randomPosition)
                    animals[randomPosition] = animal
                } else {
                    animal.setPosition((randomFreePosition));
                    animals[randomFreePosition] = animal
                }
            }
        }
        return true
    }

    override fun isOccupied(position: Vector2d): Boolean = animals.containsKey(position)

    override fun objectAt(position: Vector2d): Any? = animals[position]
}