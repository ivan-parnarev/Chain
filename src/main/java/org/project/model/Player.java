package org.project.model;

/**
 * The Player class represents a player in a game.
 * It stores the player's name and score, and provides methods for accessing and modifying these attributes.
 * It also implements the Comparable interface, allowing instances of Player to be compared based on their scores.
 */
public class Player {
    /**
     * The name of the player.
     */
    private final String name;
    /**
     * The score of the player.
     */
    private long score;

    /**
     * Constructs a new player with the given name and a default score of zero.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the score of the player.
     *
     * @return the score of the player
     */
    public long getScore() {
        return score;
    }

    /**
     * Sets the score of the player.
     *
     * @param score the new score of the player
     */
    public void setScore(long score) {
        this.score = score;
    }

    /**
     * Returns a string representation of the player, which is their name.
     *
     * @return the name of the player
     */
    @Override
    public String toString() {
        return getName();
    }
}
