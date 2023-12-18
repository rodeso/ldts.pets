package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.utils.random.Randomizer;
import com.l13gr03.pets.utils.random.StatusRandomizer;

import java.util.Arrays;
import java.util.List;

public class LavaLurker extends Entity {
    private static final int id = 5;
    private static final String ability = "Flame Fists"; // Every time it lands a attack 10% chance it burns
    private List<String> arte= Arrays.asList(" _","(º)>");
    private String color="#D0312D";
    private String shcolor="#2fced2";


    public LavaLurker(String n) {
        super(n);
        super.setStats(new int[]{70, 145, 80, 100, 70, 100}); //Mega Blaziken -30
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public void useAbility(int n){
        Randomizer r = new StatusRandomizer();
        boolean res = r.oneInTen();
        if(res){
            turnAbilityOn();
        }


    }
    @Override
    public List<String> getArte(){return arte;}
    @Override
    public String getColor(){return color;}
}
