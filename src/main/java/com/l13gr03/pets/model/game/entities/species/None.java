package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

public class None extends Entity {
    private static final int id = 0;
    private static final String ability = "";


    public None(String n) {
        super(n);
        super.setStats(new int[]{0, 0, 0, 0, 0, 0});
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public void useAbility(int n){
        turnAbilityOn();
    }
}
