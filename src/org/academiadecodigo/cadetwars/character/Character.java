package org.academiadecodigo.cadetwars.character;

import org.academiadecodigo.cadetwars.Action;
import org.academiadecodigo.cadetwars.Randomizer;
import org.academiadecodigo.cadetwars.Skill;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character {
    private int health;
    private int defense;
    private double defenseMultiplier;
    private int strength;
    private String name;
    private boolean isDead;
    private double hitChance;
    private Picture sprite;

    public Character() {
        defenseMultiplier = 0.1;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attack(Character character) {
        if (Math.random() <= hitChance) {
            character.takeDamage(strength);
        }
    }

    public void defend() {
        defense += Randomizer.getRandomNumber(5, 10);
    }

    public void focus() {
        strength += Randomizer.getRandomNumber(5, 10);
        hitChance += 0.05;
        defenseMultiplier += 0.05;
    }

    public void die() {
        isDead = true;
    }

    public void takeDamage(int damage) {
        int damageToTake = (int) (damage - Math.ceil(defense * defenseMultiplier));

        if (health - damageToTake <= 0) {
            health = 0;
            die();
        } else {
            health -= damageToTake;
        }
    }

    public void useSkill() {

    }

    public void doAction(Action action, Character character) {
        switch (action) {
            case ATTACK -> attack(character);
            case DEFEND -> defend();
            case FOCUS -> focus();
            case SKILL -> useSkill();
            default -> System.out.println("Something horrible has happened.");
        }
    }

    public void speak() {

    }


}
