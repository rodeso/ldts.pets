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
    public Entity getP(int n) {
        Entity selected = switch (n) {
            case 1 -> p1;
            case 2 -> p2;
            case 3 -> p3;
            default -> null;
        };
        return selected;
    }
    public int getp1(){
        return p1.getHP();
    }
}
