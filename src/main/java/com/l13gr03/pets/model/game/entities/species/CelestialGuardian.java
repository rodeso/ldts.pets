package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

import java.util.Arrays;
import java.util.List;

public class CelestialGuardian extends Entity {
    private static final int id = 3;
    private static final String ability = "Cosmic Mind"; //Boosts all special attacks
    private List<String> arte= Arrays.asList(" \\_/","(^w^)" );
    private String color= "#00FF00";
    private String shcolor="#ff00ff";

    public CelestialGuardian(String n) {
        super(n);
        super.setStats(new int[]{50, 80, 50, 150, 50, 100}); //Deoxys
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
    @Override
    public List<String> getArte(){return arte;}
    @Override
    public String getColor(){return color;}
}
