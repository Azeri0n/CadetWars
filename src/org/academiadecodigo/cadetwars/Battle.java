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
    private boolean turnIsOver;
    private KnightAnimation knightAnimation;
    private KnightInput knightInput;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        playerInput = new PlayerInput(player, enemy);
        fighters = new Character[]{player, enemy};
        background = new Picture(Background.PADDING, Background.PADDING, "Resources/Backgrounds/background.jpeg");
        turnIsOver = false;
        knightAnimation = new KnightAnimation();
        knightInput = new KnightInput(knightAnimation);
    }

    public void startBattle() throws InterruptedException {
        background.draw();

        while (true) {
            knightAnimation.chooseAnimation("idle-2");
            if (knightInput.isAttacking() == true) {

                knightAnimation.chooseAnimation("attack2");

            }
        }
    }

    public void doBattle() {
        for (Character character : fighters) {
            if (!character.isDead()) {
                takeTurn(character);
            } else {
                endBattle();
            }
        }
    }

    public void takeTurn(Character character) {
        if (character instanceof Enemy) {
            Action randomAction = Action.values()[Randomizer.getRandomNumber(0, 3)];
            character.doAction(randomAction, player);
        } else {
            turnIsOver = false;
            while (!turnIsOver) {
                // wait for player input ???
                playerInput.timeForInput();
                // do action after pressing key
                // do animation
                turnIsOver = true;
            }
        }
    }

    public void endBattle() {
        background.delete();
    }
}
