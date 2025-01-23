package org.example

import org.example.model.Animal
import org.example.model.BouncyMap
import org.example.model.Vector2d

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val map: BouncyMap = BouncyMap(5, 5)
    println(map.canMoveTo(Vector2d(4, 4)))

    val animal: Animal = Animal()
    println(Vector2d(0, 3) <= animal.getPosition())
    println(Vector2d(0, 3).procedes(animal.getPosition()))
    println(Vector2d(0, 3).follows(animal.getPosition()))
}