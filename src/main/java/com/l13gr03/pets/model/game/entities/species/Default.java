package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

public class Default extends Entity {
    public Default(String n) {
        super(n);
        super.setStats(new int[]{0, 0, 0, 0, 0, 0});
    }
}
