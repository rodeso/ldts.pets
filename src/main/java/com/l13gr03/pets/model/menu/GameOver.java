package com.l13gr03.pets.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private List<String> text;
    public GameOver(int i){
        String sex= "Player " + Integer.toString(i)+ " won the game";
        text= Arrays.asList("GAME OVER", sex,"<Press ENTER to go back to the menu>");
    }
    public List<String> getText(){return text;}

}
