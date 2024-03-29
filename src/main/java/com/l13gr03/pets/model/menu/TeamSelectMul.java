package com.l13gr03.pets.model.menu;

import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.model.game.entities.species.*;

import java.util.Arrays;
import java.util.List;

public class TeamSelectMul {
    private int player=1;

    private List<String> entries;
    private Entity[] entities=new Entity[]{new AquaticAlly("Blastem"),new BiomorphicBeast("Angree"),new CelestialGuardian("Doxxis"),new CyberneticCompanion("Metagrosso"),new LavaLurker("Nekizal"),new ShadowSpecter("Nocturnyx"), new StoneGolem("Big7"), new None("None")};
    private  int[] stats;

    private List<String> team;
    private List<String> statType;
    private int currentEntry = 0;
    private int currentColumn=0;
    private int currentTeam=-1;
    private boolean backSelect=false;
    private boolean nextSelect=false;
    private String back="Go Back";
    private String next="Next";

    public TeamSelectMul() {

        this.entries= Arrays.asList(entities[0].getName(),entities[1].getName(),entities[2].getName(),entities[3].getName(),entities[4].getName(),entities[5].getName(),entities[6].getName());

        this.stats = entities[0].getStats();
        this.team= Arrays.asList("None","None","None");
        this.statType= Arrays.asList("HP: ","Attack: ","Defence:","Special Attack: ","Special Defence: ", "Speed: ");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
        stats= entities[currentEntry].getStats();
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
        stats= entities[currentEntry].getStats();
    }
    public void nextTeam() {
        currentTeam++;
        if (currentTeam > this.team.size() - 1)
            currentTeam = 0;
        stats= getParty(currentTeam).getStats();
    }

    public void previousTeam() {
        currentTeam--;
        if (currentTeam < 0)
            currentTeam = this.team.size() - 1;
        stats= getParty(currentTeam).getStats();
    }
    public void nextColumn(){
        if (TeamFull()) {
            if (currentEntry > -1) {
                currentEntry = -1;
                currentTeam = 0;
                stats= getParty(currentTeam).getStats();
                currentColumn++;

            } else if (currentTeam > -1) {
                currentTeam = -1;
                backSelect = true;
                currentColumn++;
            } else if (backSelect) {
                backSelect = false;
                nextSelect=true;
                currentColumn++;
            } else if (nextSelect) {
                nextSelect=false;
                currentEntry=0;
                stats= entities[currentEntry].getStats();
                currentColumn= 0;
            }
        }else {
            if (currentEntry > -1) {
                currentEntry = -1;
                currentTeam = 0;
                stats= getParty(currentTeam).getStats();
                currentColumn++;

            } else if (currentTeam > -1) {
                currentTeam = -1;
                backSelect = true;
                currentColumn++;
            } else if (backSelect) {
                backSelect = false;
                currentEntry = 0;
                stats= entities[currentEntry].getStats();
                currentColumn = 0;
            }
        }
    }
    public void previousColumn(){
        if (TeamFull()){
            if (backSelect){
                backSelect=false;
                currentTeam=0;
                stats= getParty(currentTeam).getStats();
                currentColumn--;
            }
            else if (currentTeam>-1){
                currentTeam=-1;
                currentEntry=0;
                stats= entities[currentEntry].getStats();
                currentColumn--;
            }
            else if (currentEntry>-1){
                currentEntry=-1;
                nextSelect=true;
                currentColumn=3;
            } else if (nextSelect) {
                nextSelect=false;
                backSelect=true;
                currentColumn--;
            }
        }
        else {
            if (backSelect){
                backSelect=false;
                currentTeam=0;
                stats= getParty(currentTeam).getStats();
                currentColumn--;
            }
            else if (currentTeam>-1){
                currentTeam=-1;
                currentEntry=0;
                stats= entities[currentEntry].getStats();
                currentColumn--;
            }
            else if (currentEntry>-1){
                currentEntry=-1;
                backSelect=true;
                currentColumn=2;
            }
        }
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public int getStat(int i) {
        return stats[i];
    }
    public String getTeam(int i) {
        return team.get(i);
    }
    public String getStatType(int i) {
        return statType.get(i);
    }
    public String getBack(){return back;}
    public String getNext(){return next;}


    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isTeamSelected(int i) {
        return currentTeam == i;
    }
    public boolean isBackSelect(){return backSelect;}
    public boolean isNextSelect(){return nextSelect;}



    public int getNumberEntries() {
        return this.entries.size();
    }
    public int getNumberStats() {
        return this.stats.length;
    }
    public int getNumberTeam() {
        return this.team.size();
    }
    public int getNumberStatType() {
        return this.statType.size();
    }
    public int getCurrentColumn(){
        return currentColumn;
    }
    public boolean TeamFull(){
        if (team.get(0)=="None"){
            return false;
        }
        else if (team.get(1)=="None"){
            return false;
        }
        else if (team.get(2)=="None"){
            return false;
        }
        return true;
    }
    public void teamADD(){
        if (team.get(0)=="None"){
            team.set(0,entities[currentEntry].getName());
        }
        else if (team.get(1)=="None"){
            team.set(1,entities[currentEntry].getName());
        }
        else if (team.get(2)=="None"){
            team.set(2,entities[currentEntry].getName());
        }
    }
    public boolean TeamEmpty(){
        if (team.get(0)!="None"){
            return false;
        }
        else if (team.get(1)!="None"){
            return false;
        }
        else if (team.get(2)!="None"){
            return false;
        }
        return true;
    }
    public void teamRM(){
        if (team.get(0)!="None"&& currentTeam==0){
            team.set(0,"None");
        }
        else if (team.get(1)!="None"&& currentTeam==1){
            team.set(1,"None");
        }
        else if (team.get(2)!="None"&& currentTeam==2){
            team.set(2,"None");
        }
    }
    public void nextPlayer(){player=2;}
    public int getPlayer(){return player;}


    public Entity getParty(int n){
        int i = 0;
        String a = "";
        for (Entity entity:entities){
            if (team.get(n)==entity.getName()){
                i = entity.getId();
                a = entity.getName();
            }
        }
        return switch (i) {
            case 1 -> new AquaticAlly(a);
            case 2 -> new BiomorphicBeast(a);
            case 3 -> new CelestialGuardian(a);
            case 4 -> new CyberneticCompanion(a);
            case 5 -> new LavaLurker(a);
            case 6 -> new ShadowSpecter(a);
            case 7 -> new StoneGolem(a);
            default -> new None(a);
        };
    }
    public void reset(){
        currentEntry = 0;
        currentColumn=0;
        currentTeam=-1;
        nextSelect=false;
        this.stats = entities[0].getStats();
        this.team= Arrays.asList("None","None","None");
    }
}

