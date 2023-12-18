package com.l13gr03.pets.utils.random;

import java.util.Random;

public class StatusRandomizer implements Randomizer{
    private final Random random;
    public StatusRandomizer() {
        this.random = new Random();
    }
    @Override
    public int[] generate3() {
        return null;
    }
    @Override
    public boolean decide() {
        return false;
    }

    public boolean oneInTen(int n) {
        return n == 0;
    }
    public boolean oneInFifty(int n) {
        return n == 0;
    }
}
