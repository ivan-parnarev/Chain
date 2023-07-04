package org.project;

import org.project.model.Chain;
import org.project.model.Link;
import org.project.model.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * The Game class represents a game session where two players take turns selecting links from the ends of a chain.
 * The goal is to accumulate the highest score possible by adding up the values of the selected links.
 */
public class Game {
    /**
     * List of players participating in the game.
     */
    private final List<Player> players;
    /**
     * Scanner used to read user input.
     */
    private final Scanner scanner;
    /**
     * The chain of links used in the game.
     */
    private final Chain chain;
    /**
     * Index of the current player in the players list.
     */
    private int currentPlayerIndex = 0;

    /**
     * Constructs a new Game object with the specified chain and players.
     *
     * @param chain   the chain of links used in the game
     * @param players the list of players participating in the game
     * @param scanner the scanner used to read user input
     */
    public Game(Chain chain, List<Player> players, Scanner scanner) {
        this.chain = chain;
        this.players = players;
        this.scanner = scanner;
    }

    /**
     * Starts the game and runs until the chain is empty.
     * Displays the current state of the chain and the scores of each player at the start of each turn.
     * Prompts the current player to choose which end of the chain to take a link from.
     * Deletes the selected link from the chain and adds its value to the current player's score.
     * When the chain is empty, displays the winner of the game.
     */
    public void start() {
        Player currentPlayer;
        while (!chain.isEmpty()) {
            currentPlayer = players.get(currentPlayerIndex);

            displayCurrentPlayerTurn(currentPlayer);

            Link link = chooseLinkEnd();
            if (link == chain.getHead()) {
                chain.deleteFirstLink();
            } else {
                chain.deleteLastLink();
            }
            currentPlayer.setScore(currentPlayer.getScore() + link.getValue());
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        announceWinner();
    }

    /**
     * Displays the current score and the current chain, and notifies the current player that it's their turn.
     *
     * @param currentPlayer the current player
     */
    private void displayCurrentPlayerTurn(Player currentPlayer) {
        displayScore();

        System.out.println("--------------------------");
        System.out.println("Current chain:");
        System.out.println(chain.displayChain());
        System.out.println(currentPlayer.getName() + ", it's your turn.");
    }

    /**
     * Prompts the current player to choose which end of the chain to take a link from.
     *
     * @return the link selected by the current player
     */
    public Link chooseLinkEnd() {
        int choice;
        do {
            System.out.println("Choose which end of the chain to take a link from:");
            System.out.println("1. LEFT end");
            System.out.println("2. RIGHT end");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            return chain.getHead();
        } else {
            return chain.getTail();
        }
    }

    /**
     * Prints the final scores and announces the winner of the game.
     */
    private void announceWinner() {
        System.out.println("GAME OVER");
        displayScore();
        System.out.println("Winner is: " + getPlayerWithHighestScore());
    }

    /**
     * Displays the current scores of each player in the game.
     */
    private void displayScore() {
        System.out.println("Score:");
        System.out.println(players.get(0) + " - " + players.get(0).getScore());
        System.out.println(players.get(1) + " - " + players.get(1).getScore());
    }

    /**
     * Returns the name of the player with the highest score. If both players have the same score,
     * returns "DRAW".
     *
     * @return the name of the player with the highest score or "DRAW" if both players have the same score.
     */
    public String getPlayerWithHighestScore() {
        if (players.get(0).getScore() - players.get(1).getScore() == 0) {
            return "DRAW";
        }

        players.sort(Comparator.comparingLong(
                Player::getScore).reversed());

        return players.get(0).toString();
    }
}
