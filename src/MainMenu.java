public class MainMenu {

    private SoundPlayer soundPlayer;

    public MainMenu() {
        soundPlayer = new SoundPlayer("resources/Music/main-menu.wav");
    }

    public void startMenu() {
        soundPlayer = new SoundPlayer("resources/Music/main-menu.wav");
        soundPlayer.soundPlay();
    }

    public void stopMenu() {
        soundPlayer.soundStop();
    }
}
