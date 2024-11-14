package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;

public class TextMap implements WorldNumberPositionMap<String> {
    private final List<String> words = new ArrayList<>();

    @Override
    public boolean canMoveTo(Number position) {
        return 0 <= position.intValue() && position.intValue() < this.words.size();
    }

    @Override
    public boolean place(String word) {
        this.words.add(word);
        return true;
    }

    @Override
    public void move(String word, MoveDirection direction) {
        Integer position = null;
        for (int i = 0; i < words.size(); i++) {
            if (this.words.get(i) == word) {
                position = i;
                break;
            }
        }

        if (position == null) return;

        switch (direction) {
            case FORWARD, RIGHT:
                if (canMoveTo(position + 1)) {
                    String tmp = this.words.get(position + 1);
                    this.words.set(position + 1, word);
                    this.words.set(position, tmp);
                }
                break;
            case BACKWARD, LEFT:
                if (canMoveTo(position - 1)) {
                    String tmp = this.words.get(position - 1);
                    this.words.set(position - 1, word);
                    this.words.set(position, tmp);
                }
        }
    }

    @Override
    public boolean isOccupied(Number position) {
        return 0 <= position.intValue() && position.intValue() < this.words.size();
    }

    @Override
    public String objectAt(Number position) {
        if (!isOccupied(position.intValue())) return null;
        return this.words.get(position.intValue());
    }

    @Override
    public String toString() {
        return String.join(" ", this.words);
    }
}
