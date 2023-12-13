package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

public class ShadowSpecter extends Entity {
    private static final int id = 6;
    private static final String ability = "Shadow Sneak"; //Always attacks first
    private List<String> arte= Arrays.asList(" ,_,","(º-º)");
    private String color="#800080";


    public ShadowSpecter(String n) {
        super(n);
        super.setStats(new int[]{69, 150, 70, 121, 70, 120}); //Mega Absol +35
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public void useAbility(int n){
        setSpd(MAX_VALUE);
    }
    @Override
    public List<String> getArte(){return arte;}
    @Override
    public String getColor(){return color;}
}
