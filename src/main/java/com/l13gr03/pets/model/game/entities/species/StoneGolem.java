package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

public class StoneGolem extends Entity {
    private static final int id = 7;
    private static final String ability = "Rough Skin"; //Every time it receives a physical attack deals physical damage to the enemy
    private static final String name = "";


    public StoneGolem(String n) {
        super(n);
        super.setStats(new int[]{100, 100, 200, 50, 100, 50}); //Regirock +20

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
