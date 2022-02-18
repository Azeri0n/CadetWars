package org.academiadecodigo.cadetwars;

public class MainMenu {
    // imagem de fundo com música e "Press enter to start"
    private SoundPlayer music;

    public MainMenu() {
        music = new SoundPlayer("Resources/Music/cyberpunk-street.wav");
    }

    public void startMusic() {
        music.soundPlay();
    }

    public void stopMusic() {
        music.soundStop();
    }



}
