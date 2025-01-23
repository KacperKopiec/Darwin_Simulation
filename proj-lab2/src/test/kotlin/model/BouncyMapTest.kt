package model

import io.github.classgraph.AnnotationInfo
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import org.example.model.Animal
import org.example.model.BouncyMap
import org.example.model.Vector2d

class BouncyMapTest : ShouldSpec({
    should("check if position is a valid position for a map") {
        val map: BouncyMap = BouncyMap(4, 5)
        map.canMoveTo(Vector2d(5, 5)) shouldBe false
        map.canMoveTo(Vector2d(2, 3)) shouldBe true
    }

    should("place animal on a map") {
        val map: BouncyMap = BouncyMap(4, 5)
        map.place(Animal(Vector2d(2, 2))) shouldBe true
        map.place(Animal(Vector2d(-1, 100))) shouldBe false
        map.isOccupied(Vector2d(2, 2)) shouldBe true
    }

    should("return animal that is on given position") {
        val map: BouncyMap = BouncyMap(4, 5)
        val animal: Animal = Animal(Vector2d(2, 2))
        map.place(animal)
        map.objectAt(animal.getPosition()) shouldBe animal
        map.objectAt(Vector2d(0, 0)) shouldBe null
    }

    should("find new position if given position is occupied") {
        val map: BouncyMap = BouncyMap(4, 5)
        val animal1: Animal = Animal(Vector2d(2, 2))
        val animal2: Animal = Animal(Vector2d(2, 2))
        map.place(animal1)
        map.isOccupied(Vector2d(2, 2)) shouldBe true
        map.objectAt(Vector2d(2, 2)) shouldBe animal1
        map.place(animal2)
        map.objectAt(Vector2d(2, 2)) shouldBe animal1
        map.objectAt(animal2.getPosition()) shouldBe animal2
    }
})
