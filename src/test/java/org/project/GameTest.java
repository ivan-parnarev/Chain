package org.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.model.Chain;

import org.project.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests for the {@link Game} class.
 */
public class GameTest {
    private Game game;
    private Chain chain;
    private Scanner mockedScanner;

    @BeforeEach
    void setUp() {
        chain = new Chain();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        mockedScanner = mock();
        game = new Game(chain, players, mockedScanner);
    }

    @Test
    void testGameOnlyOnes() {
        chain.addLink(25);
        chain.addLink(-60);
        chain.addLink(25);
        chain.addLink(-78);
        chain.addLink(47);

        when(mockedScanner.nextInt()).thenReturn(1, 1, 1, 1, 1);

        game.start();

        assertEquals("Player 1", game.getPlayerWithHighestScore());
    }

    @Test
    void testGameOnlyTwos() {
        chain.addLink(25);
        chain.addLink(-60);
        chain.addLink(25);
        chain.addLink(-78);
        chain.addLink(47);

        when(mockedScanner.nextInt()).thenReturn(2, 2, 2, 2, 2);

        game.start();

        assertEquals("Player 1", game.getPlayerWithHighestScore());
    }

    @Test
    void testGameOnlyTwosPlayer2Wins() {
        chain.addLink(47);
        chain.addLink(-78);
        chain.addLink(25);
        chain.addLink(-60);
        chain.addLink(25);

        when(mockedScanner.nextInt()).thenReturn(2, 1, 1, 2, 2);

        game.start();

        assertEquals("Player 2", game.getPlayerWithHighestScore());
    }

    @Test
    void testGameEqualScores() {
        chain.addLink(1);
        chain.addLink(1);
        chain.addLink(1);
        chain.addLink(1);
        chain.addLink(1);
        chain.addLink(1);

        when(mockedScanner.nextInt()).thenReturn(1, 1, 1, 1, 1); // both players should end up with a score of 3

        game.start();

        assertEquals("DRAW", game.getPlayerWithHighestScore());
    }

    @Test
    void testExampleGame() {
        chain.addLink(0);
        chain.addLink(4);
        chain.addLink(-8);
        chain.addLink(5);
        chain.addLink(100);
        chain.addLink(-9);

        when(mockedScanner.nextInt()).thenReturn(2, 2, 1, 1, 1,2);

        game.start();

        assertEquals("Player 2", game.getPlayerWithHighestScore());
    }
}