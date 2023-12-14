package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

import java.util.Arrays;
import java.util.List;

public class CyberneticCompanion extends Entity {
    private static final int id = 4;
    private static final String ability = "Metal Power"; //Boosts the physical attacks
    private List<String> arte= Arrays.asList("","M(>->)M");
    private String color="#FFFF00";

    public CyberneticCompanion(String n) {
        super(n);
        super.setStats(new int[]{130, 110, 130, 70, 90, 70}); //Metagross
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public void useAbility(int n){
        double res = getAtk() * (1.1+ n*0.1);
        int r = (int) res;
        setAtk(r);

    }
    @Override
    public List<String> getArte(){return arte;}
    @Override
    public String getColor(){return color;}
}
