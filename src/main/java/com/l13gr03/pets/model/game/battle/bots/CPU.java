package com.l13gr03.pets.model.game.battle.bots;

import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.*;
import com.l13gr03.pets.model.game.entities.species.*;
import com.l13gr03.pets.utils.random.Randomizer;
import com.l13gr03.pets.utils.random.ThreeRandomizer;
import com.l13gr03.pets.utils.calculator.Calculator;

import java.util.Random;


public abstract class CPU  {

    private final String name;
    private Party party;
    Random random = new Random();
    Calculator dmg = new Calculator() {
        @Override
        public double execute(Entity.Attack attackerAttack, Entity attacker, Entity defender) {
            return 0;
        }
    };
    public String getName(){return name;}
    public CPU(String n) {name = n;}
    public abstract int chooseAttack(Entity.Attack[] attacks,Entity e1, Entity e2);

    public Party createParty(){
        Randomizer r = new ThreeRandomizer();
        int[] a = r.generate3();
        Entity p1,p2,p3;
        if (a[0] == 1) {
             p1 = new AquaticAlly("Blastem");
        }
        else if (a[0] == 2) {
             p1 = new BiomorphicBeast("Angree");
        }
        else if (a[0] == 3) {
             p1 = new CelestialGuardian("Doxxis");
        }
        else if (a[0] == 4) {
             p1 = new CyberneticCompanion("Metagrosso");
        }
        else if (a[0] == 5) {
             p1 = new LavaLurker("Nekizal");
        }
        else if (a[0] == 6) {
             p1 = new ShadowSpecter("Nocturnyx");
        }
        else {
             p1 = new StoneGolem("Big7");
        }

        int j = a[1];
        if (j == 1) {
            p2 = new AquaticAlly("Blastem");
        }
        else if (j == 2) {
             p2 = new BiomorphicBeast("Angree");
        }
        else if (j == 3) {
             p2 = new CelestialGuardian("Doxxis");
        }
        else if (j == 4) {
             p2 = new CyberneticCompanion("Metagrosso");
        }
        else if (j == 5) {
             p2 = new LavaLurker("Nezikal");
        }
        else if (j == 6) {
             p2 = new ShadowSpecter("Nocturnyx");
        }
        else {
             p2 = new StoneGolem("Big7");
        }
        int d = a[2];
        if (d == 1) {
             p3 = new AquaticAlly("Blastem");
        }
        else if (d == 2) {
             p3 = new BiomorphicBeast("Angree");
        }
        else if (d == 3) {
             p3 = new CelestialGuardian("Doxxis");
        }
        else if (d == 4) {
             p3 = new CyberneticCompanion("Metagrosso");
        }
        else if (d == 5) {
             p3 = new LavaLurker("Nezikal");
        }
        else if (d == 6) {
             p3 = new ShadowSpecter("Nocturnyx");
        }
        else {
             p3 = new StoneGolem("Big7");
        }
        Party party = new Party(p1,p2,p3);
        return party;
    }

    public boolean isDisadvantaged(Entity e1, Entity e2) {
        return false;
    }
    public int change(Party party, Entity current, Entity e) {
        return 0;
    }
}







