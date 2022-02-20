import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerInput implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player1;
    private Player player2;
    private Battle battle;
    private MainMenu menu;
    private Animator animator;
    private GameAnimation gameAnimation;
    private UI ui;
    private boolean started;
    private boolean deadState1;
    private boolean deadState2;
    private Player.LastResort usedSkillPlayer1;
    private Player.LastResort usedSkillPlayer2;
    private SoundPlayer player1hit;
    private SoundPlayer player2hit;
    private SoundPlayer meteorSound;

    public PlayerInput(Player player1, Player player2, Battle battle, MainMenu menu, Animator animator, UI ui) {
        keyboard = new Keyboard(this);
        this.player1 = player1;
        this.player2 = player2;
        this.battle = battle;
        this.menu = menu;
        this.animator = animator;
        gameAnimation = new GameAnimation();
        this.ui = ui;
        gameAnimation.start();
        //animator.getTextAnimation().start();
        createKeyboardEvents();
    }


/*    public boolean hasStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }*/

    public void endBattleAfterDeath() {
        if (player1.isDead() || player2.isDead()) {
            battle.endBattle();
            started = false;
        }
        gameAnimation.interrupt();
    }

    public boolean isStarted() {
        return started;
    }

    public void createKeyboardEvents() {
        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventA = new KeyboardEvent();
        keyboardEventA.setKey(KeyboardEvent.KEY_A);
        keyboardEventA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventA);

        KeyboardEvent keyboardEventS = new KeyboardEvent();
        keyboardEventS.setKey(KeyboardEvent.KEY_S);
        keyboardEventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventS);

        KeyboardEvent keyboardEventD = new KeyboardEvent();
        keyboardEventD.setKey(KeyboardEvent.KEY_D);
        keyboardEventD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventD);

        KeyboardEvent keyboardEventW = new KeyboardEvent();
        keyboardEventW.setKey(KeyboardEvent.KEY_W);
        keyboardEventW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventW);

        KeyboardEvent keyboardEventQ = new KeyboardEvent();
        keyboardEventQ.setKey(KeyboardEvent.KEY_Q);
        keyboardEventQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventQ);

        KeyboardEvent keyboardEventR = new KeyboardEvent();
        keyboardEventR.setKey(KeyboardEvent.KEY_R);
        keyboardEventR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventR);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player2) {
                        player2.focus();
                        endBattleAfterDeath();
                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player2) {
                        usedSkillPlayer2 = player2.useSkill(player1);
                        if (usedSkillPlayer2 == Player.LastResort.METEOR) {
                            meteorSound = new SoundPlayer("resources/Music/WOW.wav");
                            meteorSound.soundPlay();
                        }
                        endBattleAfterDeath();
                        animator.setLastResorting2(true);
                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player2) {
                        player2.defend();
                        endBattleAfterDeath();
                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player2) {
                        player2.attack(player1);
                        animator.setAttacking2(true);
                        player2hit = new SoundPlayer("resources/Music/Punch.wav");
                        player2hit.soundPlay();
                        endBattleAfterDeath();
                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_W:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player1) {
                        player1.focus();
                        endBattleAfterDeath();
                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_S:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player1) {
                        usedSkillPlayer1 = player1.useSkill(player2);
                        if (usedSkillPlayer1 == Player.LastResort.METEOR) {
                            meteorSound = new SoundPlayer("resources/Music/WOW.wav");
                            meteorSound.soundPlay();
                        }
                        endBattleAfterDeath();
                        animator.setLastResorting(true);
                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_A:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player1) {
                        player1.defend();
                        //animator.setDefending(true);
                        endBattleAfterDeath();
                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_D:
                if (battle.hasStarted() && !player1.isDead() && !player2.isDead()) {
                    if (battle.getCurrentPlayer() == player1) {
                        player1.attack(player2);
                        animator.setAttacking(true);
                        player1hit = new SoundPlayer("resources/Music/swordslash.wav");
                        player1hit.soundPlay();
                        endBattleAfterDeath();

                        battle.changePlayer();
                    }
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                if (!started && !battle.hasMusic()) {
                    menu.stopMenu();
                    battle.startBattle();
                    gameAnimation.interrupt();
                    animator.setStarted(true);
                    try {
                        gameAnimation.start();
                    } catch (Exception e) {
                        e.getSuppressed();
                    }

                    break;
                }
            case KeyboardEvent.KEY_R:
                battle.endBattle();
                menu.startMenu();
                player1.revive();
                player2.revive();
                animator.setStarted(false);
                battle.getSoundPlayer().soundStop();
                gameAnimation.interrupt();
                break;

            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public class GameAnimation extends Thread {

        @Override
        public void run() {
            while (true) { // gameLoop
                if (player1.isDead()) {
                    try {
                        animator.chooseAnimation("Dead1", "Victory2", "dead");
                        gameAnimation.interrupt();
                        ui.createVictoryPlayer2();
                    } catch (InterruptedException e) {
                        e.getSuppressed();
                    }
                } else if (player2.isDead()) {
                    try {
                        animator.chooseAnimation("Victory1", "Dead2", "dead");
                        gameAnimation.interrupt();
                        ui.createVictoryPlayer1();
                    } catch (InterruptedException e) {
                        e.getSuppressed();
                    }
                } else {
                    try {
                        animator.chooseAnimation("Idle", "Idle", "idle"); // start animations
                    } catch (InterruptedException e) {
                        e.getSuppressed();
                    }
                }
                if (animator.isAttacking()) {
                    try {
                        animator.chooseAnimation("Action1", "TakeHit2", "attack"); // end animations
                    } catch (InterruptedException e) {
                        e.getSuppressed();
                    }
                    animator.setAttacking(false);

                } else if (animator.isAttacking2()) {
                    try {
                        animator.chooseAnimation("TakeHit1", "Action2", "attack"); // end animations
                    } catch (InterruptedException e) {
                        e.getSuppressed();
                    }
                    animator.setAttacking2(false);

                }
                if (animator.isLastResorting()) {
                    if (usedSkillPlayer1 == Player.LastResort.METEOR) {
                        try {
                            animator.chooseAnimation("LastResort1", "TakeHit2", "attack"); // end animations
                        } catch (InterruptedException e) {
                            e.getSuppressed();
                        }
                    }
                    animator.setLastResorting(false);
                }
                 if (animator.isLastResorting2()) {
                    if (usedSkillPlayer2 == Player.LastResort.METEOR) {
                        try {
                            animator.chooseAnimation("TakeHit1", "LastResort2", "attack"); // end animations
                        } catch (InterruptedException e) {
                            e.getSuppressed();
                        }
                    }
                    animator.setLastResorting2(false);
                }

                if (player1.isDead() && !deadState1) {
                    try {
                        deadState1 = true;
                        animator.chooseAnimation("Death1", "Idle", "death"); // end animations
                    } catch (InterruptedException e) {
                        e.getSuppressed();
                    }
                }
                if (player2.isDead() && !deadState2) {
                    deadState2 = true;
                    try {
                        animator.chooseAnimation("Idle", "Death2", "death2");
                    } catch (InterruptedException e) {
                        e.getSuppressed();
                    }
                }
            }
        }
    }
}
