import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Battle {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean hasStarted;
    private Sound battleMusic;
    private boolean hasMusic;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        if (Randomizer.getRandomNumber(0, 1) == 0) {
            currentPlayer = player1;
        } else
            currentPlayer = player2;
        hasStarted = false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean hasMusic() {
        return hasMusic;
    }

    public void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else
            currentPlayer = player1;
    }

    public void endBattle() {
        try {
            battleMusic.stop();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        hasMusic = false;
        try {
            battleMusic = new Sound("VictoryMeme.wav");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        battleMusic.play();
    }

    public void startBattle() {
        if (Randomizer.getRandomNumber(0, 1) == 0) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
        hasStarted = true;
        try {
            battleMusic = new Sound("battle.wav");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        battleMusic.play();
        hasMusic = true;
    }

    public Sound getSound() {
        return battleMusic;
    }

    public boolean hasStarted() {
        return hasStarted;
    }
}
