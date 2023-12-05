package com.l13gr03.pets.model.game.battle.bots;

import com.l13gr03.pets.model.game.battle.Party;
import com.l13gr03.pets.model.game.entities.*;

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
        Entity p1,p2,p3;
        int i = random.nextInt(1,8);
        if (i == 1) {
             p1 = new AquaticAlly("");
        }
        else if (n1 == 2) {
             p1 = new BiomorphicBeast("");
        }
        else if (n1 == 3) {
             p1 = new CelestialGuardian("");
        }
        else if (n1 == 4) {
             p1 = new CyberneticCompanion("");
        }
        else if (n1 == 5) {
             p1 = new LavaLurker("");
        }
        else if (n1 == 6) {
             p1 = new ShadowSpecter("");
        }
        else {
             p1 = new StoneGolem("");
        }

        int j = random.nextInt(1,8);
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
        int d = random.nextInt(1,8);
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







