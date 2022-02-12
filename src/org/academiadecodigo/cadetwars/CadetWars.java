package org.academiadecodigo.cadetwars;

import org.academiadecodigo.cadetwars.character.Player;

public class CadetWars {
    public static void main(String[] args) {
        Player joao = new Player("João");
        joao.defend();
        joao.defend();
        System.out.println(joao);
    }
}
