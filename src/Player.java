public class Player {
    private int health;
    private int attack;
    private int defense;
    private boolean isDead;
    private double hitChance;
    private double criticalChance;
    private String name;

    public Player(int health, String name) {
        this.health = health;
        this.name = name;
        attack = 10;
        defense = 0;
        isDead = false;
        hitChance = Randomizer.getRandomDouble(0.7, 0.9);
        criticalChance = Randomizer.getRandomDouble(0.1, 0.3);
    }

    public String getHealthInString() {
        return Integer.toString(health);
    }

    public void revive() {
        health = 200;
        isDead = false;
    }

    public void hit (int damage) {
        int damageToTake = damage - defense;

        if (damageToTake <= 0) {
            damageToTake = 0;
        }

        if (health - damageToTake <= 0) {
            health = 0;
            die();
        } else {
            health -= damageToTake;
        }
        System.out.println("Player " + name + " has " + health + " health.");
    }

    public void attack(Player player) {
        if (Math.random() <= hitChance) {
            if (Math.random() <= criticalChance) {
                player.hit((int) (attack * 1.5));
            } else {
                player.hit(attack);
            }
        }
    }

    public void meteor(Player player) {
        player.hit(Randomizer.getRandomNumber(50, 100));
    }

    public void defend() {
        defense += Randomizer.getRandomNumber(0, 2);
        System.out.println("Player " + name + " has " + defense + " defense.");
    }

    public void focus() {
        attack += Randomizer.getRandomNumber(0, 3);
        criticalChance += 0.05;
        hitChance += 0.05;
        System.out.println("Player " + name + " has " + attack + " attack.");
    }

    public boolean isDead() {
        return isDead;
    }

    public void die() {
        isDead = true;
    }

    public LastResort useSkill(Player player) {
        LastResort randomSkill = LastResort.values()[Randomizer.getRandomNumber(0, 2)];

        switch (randomSkill) {
            case HEAL:
                health += Randomizer.getRandomNumber(50, 100);
                if (health >= 200) {
                    health = 200;
                }
                return randomSkill;
            case METEOR:
                meteor(player);
                return randomSkill;
            case SUICIDE:
                health = 0;
                die();
                return randomSkill;
        }
        return null;
    }

    public int getHealth() {
        return health;
    }

    public enum LastResort {
        HEAL,
        METEOR,
        SUICIDE
    }

}
