package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;

public class CyberneticCompanion extends Entity {
    private static final int id = 4;
    private static final String ability = "Metal Power"; //Boosts the physical attacks


    public CyberneticCompanion(String n) {
        super(n);
        super.setStats(new int[]{/*79*/4, 83, 100, 85, 105, 78});
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
}
