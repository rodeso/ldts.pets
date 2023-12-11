package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

public class CelestialGuardian extends Entity {
    private static final int id = 3;
    private static final String ability = "Cosmic Mind"; //Boosts all special attacks


    public CelestialGuardian(String n) {
        super(n);
        super.setStats(new int[]{50, 150, 50, 150, 50, 150}); //Deoxys
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public void useAbility(int n){
        double res = getSAtk() * (1.1+ n*0.1);
        int r = (int) res;
        setSAtk(r);

    }
}
