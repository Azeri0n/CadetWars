package org.academiadecodigo.cadetwars;

public class Randomizer {

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
