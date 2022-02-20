import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Game {

    private Battle battle;
    private MainMenu mainMenu;
    private Animator animator;
    private UI ui;

    public Game (String player1Name, String player2Name) {
        Player player1 = new FireGuy(200, player1Name);
        Player player2 = new Monk(200, player2Name);
        mainMenu = new MainMenu();
        battle = new Battle(player1, player2);
        ui = new UI(player1, player2, battle);
        animator = new Animator(ui);
        ui.createHealthBars();
        ui.createIcons();
        ui.createCurrentPlayerArrow();
        ui.createHealthText();

        new PlayerInput(player1, player2, battle, mainMenu, animator, ui);
    }
    
    public void startGame() {
        try {
            mainMenu.startMenu();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
