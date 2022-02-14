package org.academiadecodigo.cadetwars;

import org.academiadecodigo.cadetwars.character.enemy.Enemy;
import org.academiadecodigo.cadetwars.character.Player;
import org.academiadecodigo.cadetwars.character.enemy.Enemy1;

public class Game {

    private Player player;
    private Enemy[] enemies;
    private Battle[] battles;
    private MainMenu menu;
    private final int NUMBER_OF_ENEMIES = 5;

    public void createEnemies() {
        enemies = new Enemy[]{new Enemy1()};
    }

    public void start(String playerName) {
        player = new Player(playerName);
        createEnemies();
        // start itterating through every battle
    }

    public void gameOver() {
        // return to main menu
    }
}
