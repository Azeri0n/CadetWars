import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class UI {
    private Player player1;
    private Player player2;
    private Picture player1HealthBorder;
    private Picture player2HealthBorder;
    private Text player1Health;
    private Text player2Health;
    private Rectangle player1rec;
    private Rectangle player2rec;
    private Picture aButton;
    private Picture dButton;
    private Picture sButton;
    private Picture wButton;
    private Picture upButton;
    private Picture downButton;
    private Picture leftButton;
    private Picture rightButton;
    private Picture victoryPlayer1;
    private Picture victoryPlayer2;
    private Picture victoryKeys;
    private Picture pointTurnPlayer1;
    private Picture pointTurnPlayer2;
    private Battle battle;

    public UI(Player player1, Player player2, Battle battle) {
        this.player1 = player1;
        this.player2 = player2;
        this.battle = battle;
    }

    public void createHealthText() {
        player1Health = new Text(200, 278, player1.getHealthInString());
        player1Health.grow(6, 6);
        player1Health.setColor(Color.WHITE);
        player2Health = new Text(605, 278, player2.getHealthInString());
        player2Health.grow(6, 6);
        player2Health.setColor(Color.WHITE);
    }

    public void drawText() {
        player1Health.draw();
        player2Health.draw();
    }

    public void createCurrentPlayerArrow() {
        pointTurnPlayer1 = new Picture(50, 350, "PointTurn1.png");
        pointTurnPlayer2 = new Picture(700, 350, "PointTurn2.png");
    }

    public void deleteCurrentPlayerArrow() {
        pointTurnPlayer1.delete();
        pointTurnPlayer2.delete();
    }

    private void deleteText() {
        player1Health.delete();
        player2Health.delete();

    }

    public void createVictoryPlayer1() {
        victoryPlayer1 = new Picture(155, 50, "POneWins.png");
        victoryPlayer1.draw();
        victoryKeys = new Picture(270, 440, "PressForMenuQuitCentered2.png");
        victoryKeys.draw();
    }

    public void createVictoryPlayer2() {
        victoryPlayer2 = new Picture(155, 50, "PTwoWins.png");
        victoryPlayer2.draw();
        victoryKeys = new Picture(270, 440, "PressForMenuQuitCentered2.png");
        victoryKeys.draw();
    }


    public void createHealthBars() {
        player1rec = new Rectangle(100, 270, player1.getHealth(), 30);
        player1rec.setColor(Color.RED);
        player2rec = new Rectangle(710, 270, player2.getHealth(), 30);
        player2rec.setColor(Color.RED);
        player1HealthBorder = new Picture(100, 250, "hpBarUiPlayer.png");
        player2HealthBorder = new Picture(465, 250, "hpBarUiEnemy.png");
    }

    public void createIcons() {
        aButton = new Picture(30, 395, "AButton.png");
        aButton.grow(-100, -100);
        dButton = new Picture(120, 395, "DButton.png");
        dButton.grow(-100, -100);
        sButton = new Picture(75, 395, "SButton.png");
        sButton.grow(-100, -100);
        wButton = new Picture(75, 350, "WButton.png");
        wButton.grow(-100, -100);
        upButton = new Picture(487, 350, "UpButton.png");
        upButton.grow(-100, -100);
        downButton = new Picture(487, 395, "DownButton.png");
        downButton.grow(-100, -100);
        leftButton = new Picture(442, 395, "LeftButton.png");
        leftButton.grow(-100, -100);
        rightButton = new Picture(532, 395, "RightButton.png");
        rightButton.grow(-100, -100);
    }

    public void drawIcons() {
        aButton.draw();
        dButton.draw();
        sButton.draw();
        wButton.draw();
        upButton.draw();
        downButton.draw();
        leftButton.draw();
        rightButton.draw();
    }

    public void deleteIcons() {
        aButton.delete();
        dButton.delete();
        sButton.delete();
        wButton.delete();
        upButton.delete();
        downButton.delete();
        leftButton.delete();
        rightButton.delete();
    }

    public void startUI() {
        player1rec = new Rectangle(100, 270, player1.getHealth(), 30);
        player1rec.setColor(Color.RED);
        player2rec = new Rectangle(510, 270, player2.getHealth(), 30);
        player2rec.setColor(Color.RED);
        player1rec.fill();
        player2rec.fill();
        player1HealthBorder.draw();
        player2HealthBorder.draw();
        if (!player1.isDead() && !player2.isDead()) {
            drawIcons();
            if (battle.getCurrentPlayer() == player1) {
                pointTurnPlayer1.draw();
            } else {
                pointTurnPlayer2.draw();
            }
        }
        createHealthText();
        drawText();
    }

    public void deleteUI() {
        player1HealthBorder.delete();
        player2HealthBorder.delete();
        player1rec.delete();
        player2rec.delete();
        deleteCurrentPlayerArrow();
        deleteText();
        if (!player1.isDead() && !player2.isDead()) {
            deleteIcons();
            deleteCurrentPlayerArrow();
        }
    }
}
