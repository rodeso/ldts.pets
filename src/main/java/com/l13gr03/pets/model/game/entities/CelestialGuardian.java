package com.l13gr03.pets.model.game.entities;

public class CelestialGuardian extends Entity{
    private static final String ability = "Cosmic Mind"; //+S.Atk


    public CelestialGuardian(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }

    public String getAbility() {
        return ability;
    }
}
