package org.academiadecodigo.cadetwars;

//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class SoundPlayer {

    private AudioStream audioStream;

    public SoundPlayer(String filePath) {
        try {
            InputStream in = new FileInputStream(filePath);
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.getCause();
        }
    }

    public void soundPlay() {
        AudioPlayer.player.start(audioStream);
    }

    public void soundStop() {
        AudioPlayer.player.stop(audioStream);
        try {
            audioStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
