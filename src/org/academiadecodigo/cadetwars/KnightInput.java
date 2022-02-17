package org.academiadecodigo.cadetwars;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KnightInput implements KeyboardHandler {

    private Keyboard keyboard;
    private KnightAnimation knightAnimation;
    private boolean Attacking;


    public KnightInput(KnightAnimation knightAnimation){
        this.knightAnimation = knightAnimation;
        knightAnimation.setKnightInput(this);
        keyboard = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_D);



        keyboard.addEventListener(event);
    }


    public boolean isAttacking() {
        return Attacking;
    }

    public void setAttacking(boolean is) {

        Attacking = is;

        //return is;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        System.out.println("Attacking");
        System.out.println(this.isAttacking());

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_D){

            setAttacking(true);
            System.out.println(this.isAttacking());


        }

    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
