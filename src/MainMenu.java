import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MainMenu {

    private Sound menuMusic;

    public void startMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        menuMusic = new Sound("main-menu.wav");
        menuMusic.play();
    }

    public void stopMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        menuMusic.stop();
    }
}
