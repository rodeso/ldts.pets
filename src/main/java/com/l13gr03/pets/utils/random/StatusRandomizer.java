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
        if (n == -1) return true;
        else {
            return (random.nextInt(10) == 0);
        }
    }
    public boolean oneInFifty(int n) {
        if (n == -1) return true;
        else {
            return (random.nextInt(50) == 0);
        }
    }
}
