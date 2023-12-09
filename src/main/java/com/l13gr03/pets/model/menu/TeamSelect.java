package com.l13gr03.pets.model.menu;

import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.model.game.entities.species.AquaticAlly;
import com.l13gr03.pets.model.game.entities.species.LavaLurker;

import java.util.Arrays;
import java.util.List;

public class TeamSelect {
    private final List<String> entries;

    private  int[] stats;

    private List<String> team;
    private List<String> statType;
    private int currentEntry = 0;
    private int currentColumn=0;
    private int currentTeam=-1;
    private boolean backSelect=false;
    private String back="Go Back";

    public TeamSelect() {
        this.entries = Arrays.asList("Pikachu","Penis","Choura");
        Entity entity=new LavaLurker(entries.get(0));
        this.stats = entity.getStats();
        this.team= Arrays.asList("None","None","None");
        this.statType= Arrays.asList("HP: ","Attack: ","Defence:","Special Attack: ","Special Defence: ", "Speed: ");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
        stats= new AquaticAlly(entries.get(currentEntry)).getStats();
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
        stats= new AquaticAlly(entries.get(currentEntry)).getStats();
    }
    public void nextTeam() {
        currentTeam++;
        if (currentTeam > this.team.size() - 1)
            currentTeam = 0;
    }

    public void previousTeam() {
        currentTeam--;
        if (currentTeam < 0)
            currentTeam = this.team.size() - 1;
    }
    public void nextColumn(){
        if (currentEntry>-1){
            currentEntry=-1;
            currentTeam=0;
            currentColumn++;

        }
        else if (currentTeam>-1){
            currentTeam=-1;
            backSelect=true;
            currentColumn++;
        }
        else if (backSelect){
            backSelect=false;
            currentEntry=0;
            currentColumn=0;
        }
    }
    public void previousColumn(){
        if (backSelect){
            backSelect=false;
            currentTeam=0;
            currentColumn--;
        }
        else if (currentTeam>-1){
            currentTeam=-1;
            currentEntry=0;
            currentColumn--;
        }
        else if (currentEntry>-1){
            currentEntry=-1;
            backSelect=true;
            currentColumn=2;
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


    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isTeamSelected(int i) {
        return currentTeam == i;
    }
    public boolean isBackSelect(){return backSelect;}



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
}
