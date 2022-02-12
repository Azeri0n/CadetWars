package org.academiadecodigo.cadetwars.character;

import org.academiadecodigo.cadetwars.character.enemy.Enemy;

public class Player extends Character {

    public Player(String name) {
       setName(name);
       setHealth(100);
       setDefense(0);
       setStrength(10);
    }

    public void attack(Enemy enemy) {

    }

    @Override
    public String toString() {
        return "Player " + getName() + " has " + getHealth() + " health and " + getDefense() + " defense";
    }
}
