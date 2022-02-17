package org.academiadecodigo.cadetwars;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class KnightAnimation {

    private Picture pictures;
    private int totalFrames;
    private int currentFrame;
    private int delay = 150;
    private KnightAnimation[] knightAnimation = new KnightAnimation[totalFrames];
    Picture currentPicture = new Picture();
    KnightInput knightInput;



    public void setKnightInput(KnightInput knightInput) {
        this.knightInput = knightInput;
    }

    public void chooseAnimation(String animation) throws InterruptedException {
        switch (animation) {
            case "attack2":
                testAction(animation, 6, "attack");
                break;
            case "idle-2" :
                testAction(animation, 4, "idle");
                break;
            default:
                System.out.println("Something terrible has happened!");

        }
    }

    public void testAction2(String animation) throws InterruptedException {
        totalFrames = 6;
        currentFrame = 1;


    }


    public void testAction(String animation, int frames, String action) throws InterruptedException {

        totalFrames = frames;
        currentFrame = 1;

       // if (knightInput.isAttacking() == true) {

            while (this.currentFrame <= this.totalFrames) {


                Thread.sleep(delay);
                Picture knightAttack = new Picture(400, 420, "Resources/Animations/adventurer-" + animation + "-frame" + currentFrame + ".png");
                knightAttack.grow(50 * 2, 37 * 2); // image size
                currentPicture.delete(); // deletes current frame
                currentPicture = knightAttack; // reassign value to the next current frame
                currentPicture.draw(); // draws current frame
                currentFrame++;

                if (this.currentFrame == this.totalFrames && action.equals("attack")  ) { // End of attacking animation
                    knightInput.setAttacking(false);

                }
            }


        }
   // }


    public void testIdle(String animation) throws InterruptedException {
        totalFrames = 4;
        currentFrame = 1;


        if (knightInput.isAttacking() == false) {
            while (this.currentFrame <= this.totalFrames) {

                Thread.sleep(delay);
                Picture knightAttack = new Picture(400, 420, "adventurer-"+ animation + "-frame" + currentFrame + ".png");
                knightAttack.grow(50 * 2, 37 * 2); // image size
                currentPicture.delete(); // deletes current frame
                currentPicture = knightAttack; // reassign value to the next current frame
                currentPicture.draw(); // draws current frame
                currentFrame++;

                if (this.currentFrame >= this.totalFrames) {
                    this.currentFrame = 1; // looping
                }
            }
        }
    }
}








