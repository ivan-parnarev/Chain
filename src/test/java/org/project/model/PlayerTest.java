package org.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link Player} class.
 */
public class PlayerTest {
    private Player player1;
    private Player player2;

    /**
     * Sets up the test fixtures before each test.
     */
    @BeforeEach
    void setUp() {
        player1 = new Player("PLAYER_1");
        player2 = new Player("PLAYER_2");
    }

    /**
     * Tests the {@link Player#getName()} method.
     */
    @Test
    public void testGetName() {
        assertEquals("PLAYER_1", player1.getName());
    }

    /**
     * Tests the {@link Player#getScore()} method.
     */
    @Test
    public void testGetScore() {
        assertEquals(0, player1.getScore());
    }

    /**
     * Tests the {@link Player#setScore(long)} method.
     */
    @Test
    public void testSetScore() {
        player1.setScore(10);
        assertEquals(10, player1.getScore());
    }

    /**
     * Tests the {@link Player#toString()} method.
     */
    @Test
    public void testToString() {
        assertEquals("PLAYER_1", player1.toString());
    }
}
