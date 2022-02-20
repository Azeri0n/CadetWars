import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Animator {

    private int totalFrames;
    private int currentFrame;
    private int delay = 120;
    private Picture currentPicture = new Picture();
    private Picture currentPicture2 = new Picture();
    private Picture currentPicture3 = new Picture();
    private Picture currentPicture4 = new Picture();
    private boolean attacking;
    private boolean attacking2;
    private boolean defending;
    private boolean defending2;
    private boolean focusing;
    private boolean focusing2;
    private boolean lastResorting;
    private boolean lastResorting2;
    private boolean started;
    private UI ui;

    public Animator(UI ui) {
        this.ui = ui;
    }


    public void setStarted(boolean started) {
        this.started = started;
    }

    public void chooseAnimation(String animation1, String animation2, String action) throws InterruptedException {
        testAction(animation1, animation2, 5, action);
    }

    public boolean isDefending() {
        return defending;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }

    public boolean isDefending2() {
        return defending2;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public void setDefending2(boolean defending2) {
        this.defending2 = defending2;
    }

    public boolean isFocusing() {
        return focusing;
    }

    public void setFocusing(boolean focusing) {
        this.focusing = focusing;
    }

    public boolean isFocusing2() {
        return focusing2;
    }

    public void setFocusing2(boolean focusing2) {
        this.focusing2 = focusing2;
    }

    public boolean isLastResorting() {
        return lastResorting;
    }

    public void setLastResorting(boolean lastResorting) {
        this.lastResorting = lastResorting;
    }

    public boolean isLastResorting2() {
        return lastResorting2;
    }

    public void setLastResorting2(boolean lastResorting2) {
        this.lastResorting2 = lastResorting2;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public boolean isAttacking2() {
        return attacking2;
    }

    public void setAttacking2(boolean attacking2) {
        this.attacking2 = attacking2;
    }

    public void testAction(String animation1, String animation2, int frames, String action) throws InterruptedException {

        totalFrames = frames;
        currentFrame = 1;

        if (!started) {
            while (this.currentFrame <= this.totalFrames) {
                Thread.sleep(delay);
                Picture background1 = new Picture(10, 0, "BackgroundFrame" + currentFrame + ".png");
                Picture backgroundText = new Picture(195, 280, "BackgroundTextFrame" + currentFrame + ".png");

                currentPicture4.delete();
                currentPicture2.delete();
                currentPicture2 = background1;
                currentPicture4 = backgroundText;
                currentPicture2.draw();
                currentPicture4.draw();
                if (currentFrame == totalFrames) {
                    currentFrame = 1;
                }
                currentFrame++;
            }
        } else {
            while (this.currentFrame <= this.totalFrames) {
                Thread.sleep(delay);
                Picture player1 = new Picture(115, 275, "Warrior" + animation1 + "Frame" + currentFrame + ".png");
                Picture player2 = new Picture(565, 330, "Monk" + animation2 + "Frame" + currentFrame + ".png");
                Picture background = new Picture(10, 0, "BackgroundFrame" + currentFrame + ".png");
                player1.grow(104, 53); // image size
                player2.grow(82, 53); // image size

                ui.deleteUI();
                currentPicture3.delete();
                currentPicture2.delete();
                currentPicture.delete();
                currentPicture3 = background;
                currentPicture3.draw();
                currentPicture = player1;
                currentPicture.draw();
                currentPicture2 = player2;
                currentPicture2.draw();
                ui.startUI();

                if (this.currentFrame == this.totalFrames && action.equals("attack")) {
                    attacking = false;
                }

                if (this.currentFrame == this.totalFrames && action.equals("idle")) {
                    attacking = false;
                    currentFrame = 1;
                }
                currentFrame++;
            }
        }
    }
}









