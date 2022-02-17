package org.academiadecodigo.cadetwars;

import org.academiadecodigo.cadetwars.character.enemy.Enemy;
import org.academiadecodigo.cadetwars.character.Player;
import org.academiadecodigo.cadetwars.character.enemy.Enemy1;

public class Game {

    private Player player;
    private Enemy[] enemies;
    private Battle[] battles;
    private MainMenu menu;
    private final int NUMBER_OF_ENEMIES = 1;

    public void createEnemies() {
        enemies = new Enemy[NUMBER_OF_ENEMIES];
        enemies[0] = new Enemy1();
    }

    public void createBattles() {
        Battle battle = new Battle(player, enemies[0]);
        battles = new Battle[1];
        battles[0] = battle;
    }

    public void start(String playerName) throws InterruptedException {
        player = new Player(playerName);
        createEnemies();
        for (Battle battle : battles) {
            battle.startBattle();
            while (!player.isDead() && !enemies[0].isDead()) {
                battle.doBattle();
            }
            battle.endBattle();
        }
        // start itterating through every battle
    }

    public void gameOver() {
        // return to main menu
    }
}
