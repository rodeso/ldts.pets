package com.l13gr03.pets.model.game.entities.moves;

import com.l13gr03.pets.model.game.entities.Entity;

public class AttackFactory {
    public Entity.Attack[] createAttack(Entity n) {
        int e = n.getId();
        Entity.Attack[] attack = new Entity.Attack[4];
        switch (e) {
            case 1:
            attack[0] = new Entity.Attack("Physical", "Aqua Jet", "Aquatic", 8, 1);
            attack[1] = new Entity.Attack("Special", "Hydro Pump", "Aquatic", 18, 1);
            attack[2] = new Entity.Attack("Status", "Turtle Shell", "Aquatic", n.getDef(), 3);
            attack[3] = new Entity.Attack("Physical", "Tackle", "Null", 8, 0);
            break;
            
            case 2:
            attack[0] = new Entity.Attack("Special", "Bullet Seed","Bio",6,2);
            attack[1] = new Entity.Attack("Physical", "Vine Whip","Bio", 18,2);
            attack[2] = new Entity.Attack("Status", "Poison","Bio", 5,7);
            attack[3] = new Entity.Attack("Special", "Magical Shot", "Celestial",16,3);
            break;

            case 3:
            attack[0] = new Entity.Attack("Status", "Calm Mind","Celestial", n.getSAtk(),4);
            attack[1] = new Entity.Attack("Special", "Psychic Shock","Celestial", 18,3);
            attack[2] = new Entity.Attack("Special", "Shadow Ball","Shadow", 16,6);
            attack[3] = new Entity.Attack("Physical", "Extreme Speed","Null", 8,0);
            break;

            case 4:
            attack[0] = new Entity.Attack("Physical", "Iron Head", "Cybernetic", 14,4);
            attack[1] = new Entity.Attack("Status", "Thunder Wave", "Cybernetic",0,11);
            attack[2] = new Entity.Attack("Special", "Flash Canon", "Cybernetic", 16,4);
            attack[3] = new Entity.Attack("Special", "Rock Throw", "Stone",12,7);
            break;

            case 5:
            attack[0] = new Entity.Attack("Special", "Flamethrower", "Lava", 13,5);
            attack[1] = new Entity.Attack("Physical", "Flame Fist", "Lava", 15,5);
            attack[2] = new Entity.Attack("Status", "Swords Dance", "Null", n.getAtk(),1);
            attack[3] = new Entity.Attack("Special", "Solar Ray", "Bio",16,4);
            break;

            case 6:
            attack[0] = new Entity.Attack("Physical", "Shadow Claw", "Shadow",15,6);
            attack[1] = new Entity.Attack("Special", "Shadow Ball","Shadow", 16,6);
            attack[2] = new Entity.Attack("Physical", "Slash","Null",20,0);
            attack[3] = new Entity.Attack("Status","Intimidate", "Shadow",0,8);
            break;

            case 7:
            attack[0] = new Entity.Attack("Special", "Rock Throw", "Stone",12,7);
            attack[1] = new Entity.Attack("Status","Break Mold","Stone",0,9);
            attack[2] = new Entity.Attack("Special", "Eruption","Lava", 18,5);
            attack[3] = new Entity.Attack("Physical", "Brick Break","Stone",14,7);
        }
        return attack;
    }
}
