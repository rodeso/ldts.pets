package com.l13gr03.pets.model.game.battle.bots;

import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.*;
import com.l13gr03.pets.utils.random.Randomizer;
import com.l13gr03.pets.utils.random.ThreeRandomizer;

import java.util.Random;


public abstract class CPU  {

    private String name;
    private int n1;
    private Party party;
    Random random = new Random();
    public String getName(){return name;}
    public CPU(String n) {name = n;}
    public abstract Entity.Attack choseAttack(Entity.Attack[] attacks,Entity e);

    public Party createParty(){
        Randomizer r = new ThreeRandomizer();
        int[] a = r.generate3();
        Entity p1,p2,p3;
        if (a[0] == 1) {
             p1 = new AquaticAlly("");
        }
        else if (a[0] == 2) {
             p1 = new BiomorphicBeast("");
        }
        else if (a[0] == 3) {
             p1 = new CelestialGuardian("");
        }
        else if (a[0] == 4) {
             p1 = new CyberneticCompanion("");
        }
        else if (a[0] == 5) {
             p1 = new LavaLurker("");
        }
        else if (a[0] == 6) {
             p1 = new ShadowSpecter("");
        }
        else {
             p1 = new StoneGolem("");
        }

        int j = a[1];
        if (j == 1) {
            p2 = new AquaticAlly("");
        }
        else if (j == 2) {
             p2 = new BiomorphicBeast("");
        }
        else if (j == 3) {
             p2 = new CelestialGuardian("");
        }
        else if (j == 4) {
             p2 = new CyberneticCompanion("");
        }
        else if (j == 5) {
             p2 = new LavaLurker("");
        }
        else if (j == 6) {
             p2 = new ShadowSpecter("");
        }
        else {
             p2 = new StoneGolem("");
        }
        int d = a[2];
        if (d == 1) {
             p3 = new AquaticAlly("");
        }
        else if (d == 2) {
             p3 = new BiomorphicBeast("");
        }
        else if (d == 3) {
             p3 = new CelestialGuardian("");
        }
        else if (d == 4) {
             p3 = new CyberneticCompanion("");
        }
        else if (d == 5) {
             p3 = new LavaLurker("");
        }
        else if (d == 6) {
             p3 = new ShadowSpecter("");
        }
        else {
             p3 = new StoneGolem("");
        }
        Party party = new Party(p1,p2,p3);
        return party;
    }
}







