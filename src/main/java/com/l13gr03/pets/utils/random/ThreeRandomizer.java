package com.l13gr03.pets.utils.random;
import java.util.Random;

public class ThreeRandomizer implements Randomizer{
    private final Random r;

    public ThreeRandomizer() {
        this.r = new Random();
    }
    @Override
    public boolean decide() {
        return false;
    }

    public int[] generate3() {
        int i, j, k;
        i = r.nextInt(1,8);
        j = r.nextInt(1,8);
        while (i == j) {
            j = r.nextInt(1, 8);
        }

        k = r.nextInt(1, 8);
        while (i == k || j == k) {
            k = r.nextInt(1, 8);
        }
        int[] array = {i,j,k};
        return array;
    }

    @Override
    public boolean oneInTen(int n) {
        return false;
    }

    @Override
    public boolean oneInFifty(int n) {
        return false;
    }
}
