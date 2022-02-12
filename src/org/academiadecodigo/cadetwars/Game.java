package org.academiadecodigo.cadetwars;

import org.academiadecodigo.cadetwars.character.enemy.Enemy;
import org.academiadecodigo.cadetwars.character.Player;

public class Game {

    private Player player;
    private Enemy[] enemies;
    private MainMenu menu;
    private final int NUMBER_OF_ENEMIES = 5;

    public void createEnemies() {
        enemies = new Enemy[NUMBER_OF_ENEMIES];

        for (int i = 0; i < enemies.length; i++) {
            //enemies[i] = new Enemy();
        }
    }

    public void start(String playerName) {
        player = new Player(playerName);
    }

    public void gameOver() {

    }
}
