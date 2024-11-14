package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Simulation<T, P> {
    private final List<T> objects;
    private final List<MoveDirection> moves;
    private final WorldMap<T, P> map;

    public Simulation(List<P> objectPositions, List<MoveDirection> moves, WorldMap <T, P> map, Function<P, T> genericConstructor) {
        this.moves = moves;
        this.objects = new ArrayList<>();
        this.map = map;
        for (P objectPosition : objectPositions) {
            T object = genericConstructor.apply(objectPosition);
            if (this.map.place(object)) {
                this.objects.add(object);
            }
        }
    }

    public void run() {
        if (objects.isEmpty()) return;

        int currentObject = 0;
        for (MoveDirection move: moves) {
            this.map.move(this.objects.get(currentObject), move);
            System.out.println(this.map);
            currentObject = (currentObject + 1) % objects.size();
        }
    }

    public List<T> getObjects() {
        return new ArrayList<>(this.objects);
    }

    public List<MoveDirection> getMoves() {
        return new LinkedList<>(this.moves);
    }
}