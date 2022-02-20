import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

public class Sound {

    AudioInputStream audioInputStream;

    Clip clip;
    Long currentFrame;
    String status;
    String song ;

    public Sound(String musicPath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        song=musicPath;
        audioInputStream= AudioSystem.getAudioInputStream(new BufferedInputStream(this.getClass().getResourceAsStream(musicPath)));
        clip= AudioSystem.getClip();
        clip.open(audioInputStream);
        // lip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void play(){
        clip.start();
        status="play";
    }
    public void pause(){
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        if (status.equals("play"))
        {
            System.out.println("Audio is already "+
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream(song);
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    // Method to restart the audio
    public void restart() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException
    {
        clip.stop();
        clip.close();
        resetAudioStream(song);
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
        audioInputStream.close();
    }

    public void resetAudioStream(String string) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        song = string;
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(string).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void resetAudioStreamNoLoop(String string) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        stop();
        song = string;
        audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(this.getClass().getResourceAsStream(song)));
        clip.open(audioInputStream);
        clip.loop(0);
    }
}