package com.l13gr03.pets.model.game.entities.moves;

import com.l13gr03.pets.model.game.entities.Entity;

public class AttackFactory {
    public Entity.Attack[] createAttack(Entity n) {
        int e = n.getId();
        Entity.Attack[] attack = new Entity.Attack[4];
        switch (e) {
            case 1:
            attack[0] = new Entity.Attack("Physical", "Aqua Jet", "Aquatic", 40, 1);
            attack[1] = new Entity.Attack("Special", "Hydro Pump", "Aquatic", 90, 1);
            attack[2] = new Entity.Attack("Status", "Turtle Shell", "Aquatic", n.getDef(), 3);
            attack[3] = new Entity.Attack("Physical", "Tackle", "Null", 40, 0);
            break;
            
            case 2:
            attack[0] = new Entity.Attack("Special", "Bullet Seed","Bio", 30,2);
            attack[1] = new Entity.Attack("Physical", "Vine Whip","Bio", 90,2);
            attack[2] = new Entity.Attack("Status", "Poison","Bio", 5,7);
            attack[3] = new Entity.Attack("Special", "Magical Shot", "Celestial",80,3);
            break;

            case 3:
            attack[0] = new Entity.Attack("Status", "Calm Mind","Celestial", n.getSAtk(),4);
            attack[1] = new Entity.Attack("Special", "Psychic Shock","Celestial", 90,3);
            attack[2] = new Entity.Attack("Special", "Shadow Ball","Shadow", 80,6);
            attack[3] = new Entity.Attack("Physical", "Extreme Speed","Null", 41,0);
            break;

            case 4:
            attack[0] = new Entity.Attack("Physical", "Iron Head", "Cybernetic", 70,4);
            attack[1] = new Entity.Attack("Status", "Thunder Wave", "Cybernetic",0,11);
            attack[2] = new Entity.Attack("Special", "Flash Canon", "Cybernetic", 80,4);
            attack[3] = new Entity.Attack("Special", "Rock Throw", "Stone",60,7);
            break;

            case 5:
            attack[0] = new Entity.Attack("Special", "Flamethrower", "Lava", 65,5);
            attack[1] = new Entity.Attack("Physical", "Flame Fist", "Lava", 75,5);
            attack[2] = new Entity.Attack("Status", "Swords Dance", "Null", n.getAtk(),1);
            attack[3] = new Entity.Attack("Special", "Solar Ray", "Bio",80,2);
            break;

            case 6:
            attack[0] = new Entity.Attack("Physical", "Shadow Claw", "Shadow",75,6);
            attack[1] = new Entity.Attack("Special", "Shadow Ball","Shadow", 80,6);
            attack[2] = new Entity.Attack("Physical", "Slash","Null",100,0);
            attack[3] = new Entity.Attack("Status","Intimidate", "Shadow",0,8);
            break;

            case 7:
            attack[0] = new Entity.Attack("Special", "Rock Throw", "Stone",60,7);
            attack[1] = new Entity.Attack("Status","Break Mold","Stone",0,9);
            attack[2] = new Entity.Attack("Special", "Eruption","Lava", 90,5);
            attack[3] = new Entity.Attack("Physical", "Brick Break","Stone",70,7);
        }
        return attack;
    }
}
