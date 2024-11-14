package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.util.function.Function;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions1 = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap<Animal, Vector2d> map1 = new RectangularMap(5, 5);

        Simulation<Animal, Vector2d> simulation1 = new Simulation<>(positions1, directions, map1, Animal::new);
        simulation1.run();

        // ---------------------------------------------------------------------

        List<Number> positions2 = List.of(0, 1, 2);
        WorldNumberPositionMap<String> map2 = new TextMap();
        List<String> Words = List.of("Ala", "ma", "sowoniedźwiedzia");

        // positions needs to be in in range [0, Words.size() - 1] else Exception will occur
        Function<Number, String> positionToWord = position -> {
            return Words.get(position.intValue());
        };

        Simulation<String, Number> simulation2 = new Simulation<>(positions2, directions, map2, positionToWord);
        simulation2.run();
    }

    private static void run(List<MoveDirection> directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case MoveDirection.FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case MoveDirection.BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case MoveDirection.RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case MoveDirection.LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }
}