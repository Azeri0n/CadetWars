public class Battle {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean hasStarted;
    private SoundPlayer soundPlayer;
    private boolean hasMusic;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        if (Randomizer.getRandomNumber(0, 1) == 0) {
            currentPlayer = player1;
        } else
            currentPlayer = player2;
        hasStarted = false;
        soundPlayer = new SoundPlayer("resources/Music/battle.wav");
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
        soundPlayer.soundStop();
        hasMusic = false;
        soundPlayer = new SoundPlayer("resources/Music/VictoryMeme.wav");
        soundPlayer.soundPlay();
    }

    public void startBattle() {
        if (Randomizer.getRandomNumber(0, 1) == 0) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
        hasStarted = true;
        soundPlayer = new SoundPlayer("resources/Music/battle.wav");
        soundPlayer.soundPlay();
        hasMusic = true;
    }

    public SoundPlayer getSoundPlayer() {
        return soundPlayer;
    }

    public boolean hasStarted() {
        return hasStarted;
    }
}
