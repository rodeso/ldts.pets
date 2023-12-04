package com.l13gr03.pets.model.game.battle;

import com.l13gr03.pets.model.game.entities.Entity;

import javax.xml.stream.events.EndElement;

public class Party {
    private final Entity p1, p2, p3;
    public Party(Entity a, Entity b, Entity c) {
        p1 = a;
        p2 = b;
        p3 = c;
    }
    public Entity getP1() {
        return p1;
    }
    public Entity getP2() {
        return p2;
    }
    public Entity getP3() {
        return p3;
    }
}
