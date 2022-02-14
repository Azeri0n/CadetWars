package org.academiadecodigo.cadetwars;

import org.academiadecodigo.cadetwars.character.Player;
import org.academiadecodigo.cadetwars.character.enemy.Enemy1;

public class CadetWars {
    public static void main(String[] args) {
        Player joao = new Player("João");
        joao.defend();
        joao.defend();
        System.out.println(joao);

        Enemy1 enemy = new Enemy1();

        Battle battle = new Battle(joao, enemy);
        battle.startBattle();
    }
}
