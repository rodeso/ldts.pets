package com.l13gr03.pets.model.game.entities;

import com.l13gr03.pets.model.Position;

public class Entity {
    Position position;

    public Entity(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
