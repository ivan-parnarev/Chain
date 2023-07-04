package org.project;

import org.project.model.Chain;
import org.project.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Application class serves as the entry point for the Chain game and is
 * responsible for setting up the game environment.
 * It contains the main method that starts the game by creating a new instance
 * of the Game class and calling its start method.
 */
public class Application {

    /**
     * The main method that starts the Chain game.
     *
     * @param args The command line arguments passed to the program (unused).
     */
    public static void main(String[] args) {
        Chain chain = Chain.createRandomChain();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));

        Game game = new Game(chain, players, new Scanner(System.in));
        game.start();
    }
}