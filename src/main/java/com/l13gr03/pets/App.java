package com.l13gr03.pets;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Game game= new Game();
        try {
            game.run();
        }catch (IOException e) {
            e.getStackTrace();
        }
    }
}
