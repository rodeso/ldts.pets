package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

import java.util.Arrays;
import java.util.List;

public class AquaticAlly extends Entity {
    private static final int id = 1;
    private static final String ability = "Bubble Shield"; //It defends the first attack
    private List<String> arte= Arrays.asList("  __"," (..)","_(><)" );
    private String color="#87CEFA";
    private String shcolor="#783105";

    public AquaticAlly(String n) {
        super(n);
        super.setStats(new int[]{130, 93, 120, 90, 110, 88}); //Mega Blastoise -30
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public String getShcolor(){return shcolor;}

    public void useAbility(int n){
        if (n == 0) {
            turnAbilityOn();
        }
        else turnAbilityOff();
    }
    @Override
    public List<String> getArte(){return arte;}
    public String getColor(){return color;}
}
