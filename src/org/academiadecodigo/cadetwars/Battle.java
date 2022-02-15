package org.academiadecodigo.cadetwars;

import org.academiadecodigo.cadetwars.character.Character;
import org.academiadecodigo.cadetwars.character.enemy.Enemy;
import org.academiadecodigo.cadetwars.character.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Battle {
    private Player player;
    private Enemy enemy;
    private Character[] fighters;
    private Picture background;
    private PlayerInput playerInput;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        playerInput = new PlayerInput(player, enemy);
        fighters = new Character[]{player, enemy};
        background = new Picture(0, 0, "Backgrounds/Battleground1.png");
    }

    public void startBattle() {
        background.draw();
        while (!player.isDead() && !enemy.isDead()) {
            for (Character character : fighters) {
               takeTurn(character);
            }
        }
        endBattle();
    }

    public void takeTurn(Character character) {
        if (character instanceof Enemy) {
            Action randomAction = Action.values()[Randomizer.getRandomNumber(0, 3)];
            character.doAction(randomAction, player);
        } else {
            playerInput.timeForInput();
        }
    }

    public void endBattle() {

    }
}
