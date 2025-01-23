package org.example.model

class RandomExtensions {
    companion object {// extension functions weren't working without this
        fun WorldMap.randomPosition(mapSize: Vector2d): Vector2d? {
            val emptyPos: ArrayList<Vector2d> = ArrayList()
            for (i in 0 until (mapSize.getX())) {
                for (j in 0 until (mapSize.getY())) {
                    emptyPos.add(Vector2d(i,j))
                }
            }
            return emptyPos.randomOrNull()
        }

        fun WorldMap.randomFreePosition(mapSize: Vector2d): Vector2d? {
            val emptyPos: ArrayList<Vector2d> = ArrayList()
            for (i in 0 until mapSize.getX()) {
                for (j in 0 until mapSize.getY()) {
                    val position: Vector2d = Vector2d(i, j)
                    if (!this.isOccupied(position)) {
                        emptyPos.add(position)
                    }
                }
            }
            return emptyPos.randomOrNull()
        }
    }
}