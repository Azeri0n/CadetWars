package org.academiadecodigo.cadetwars;

import org.academiadecodigo.cadetwars.character.Player;
import org.academiadecodigo.cadetwars.character.enemy.Enemy;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerInput implements KeyboardHandler {
    private Keyboard keyboard;
    private Player player;
    private Enemy enemy;
    private boolean isTimeForInput;

    public PlayerInput(Player player, Enemy enemy) {
        keyboard = new Keyboard(this);
        this.player = player;
        this.enemy = enemy;
        isTimeForInput = false;
        createKeyboardEvents();
    }

    public void timeForInput() {
        isTimeForInput = true;
    }

    public void createKeyboardEvents() {
        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (isTimeForInput) {
                    player.doAction(Action.ATTACK, enemy);
                    isTimeForInput = false;
                }
            break;
            case KeyboardEvent.KEY_DOWN:
                if (isTimeForInput) {
                    player.doAction(Action.DEFEND, enemy);
                    isTimeForInput = false;
                }
            break;
            case KeyboardEvent.KEY_LEFT:
                if (isTimeForInput) {
                    player.doAction(Action.FOCUS, enemy);
                    isTimeForInput = false;
                }
            break;
            case KeyboardEvent.KEY_RIGHT:
                if (isTimeForInput) {
                    player.doAction(Action.SKILL, enemy);
                    isTimeForInput = false;
                }
            break;
            default:
                System.out.println("Something horrible has happened!");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
