package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

import static java.lang.Integer.MAX_VALUE;

public class ShadowSpecter extends Entity {
    private static final int id = 6;
    private static final String ability = "Shadow Sneak"; //Always attacks first


    public ShadowSpecter(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public void useAbility(){
        setSpd(MAX_VALUE);
    }
}
