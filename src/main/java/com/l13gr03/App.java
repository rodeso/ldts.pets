package com.l13gr03;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Menu menu= new Menu();
        try {
            menu.run();
        }catch (IOException e) {
            e.getStackTrace();
        }
    }
}
