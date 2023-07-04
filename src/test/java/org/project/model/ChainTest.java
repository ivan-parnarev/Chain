package org.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link Chain} class.
 */
public class ChainTest {
    private Chain chain;

    /**
     * Initializes the chain object before each test.
     */
    @BeforeEach
    void setUp() {
        chain = new Chain();
    }

    /**
     * Tests the {@link Chain#createRandomChain()} method.
     */
    @Test
    public void testCreateRandomChain() {
        chain = Chain.createRandomChain();
        assertNotNull(chain);
        assertFalse(chain.isEmpty());
    }

    /**
     * Tests the {@link Chain#addLink(int)} method.
     */
    @Test
    public void testAddLink() {
        assertTrue(chain.isEmpty());

        chain.addLink(42);
        assertFalse(chain.isEmpty());
        assertEquals(chain.getHead().getValue(), 42);
        assertEquals(chain.getTail().getValue(), 42);

        chain.addLink(13);
        assertFalse(chain.isEmpty());
        assertEquals(chain.getHead().getValue(), 42);
        assertEquals(chain.getTail().getValue(), 13);
    }

    /**
     * Tests the {@link Chain#deleteFirstLink()} method.
     */
    @Test
    public void testDeleteFirstLink() {
        chain.addLink(42);
        chain.addLink(13);

        assertEquals(chain.getHead().getValue(), 42);
        assertEquals(chain.getTail().getValue(), 13);

        chain.deleteFirstLink();
        assertNotNull(chain);
        assertEquals(chain.getHead().getValue(), 13);
        assertEquals(chain.getTail().getValue(), 13);

        chain.deleteFirstLink();
        assertTrue(chain.isEmpty());
    }

    /**
     * Tests the {@link Chain#deleteLastLink()} method.
     */
    @Test
    public void testDeleteLastLink() {
        chain.addLink(42);
        chain.addLink(13);

        assertEquals(chain.getHead().getValue(), 42);
        assertEquals(chain.getTail().getValue(), 13);

        chain.deleteLastLink();
        assertNotNull(chain);
        assertEquals(chain.getHead().getValue(), 42);
        assertEquals(chain.getTail().getValue(), 42);

        chain.deleteLastLink();
        assertTrue(chain.isEmpty());
    }

    /**
     * Tests the {@link Chain#displayChain()} method.
     */
    @Test
    public void testDisplayChain() {
        chain.addLink(0);
        chain.addLink(4);
        chain.addLink(-8);
        chain.addLink(5);
        chain.addLink(100);
        chain.addLink(-9);

        String testChain = "0 4 -8 5 100 -9";

        assertEquals(chain.displayChain(), testChain);
    }
}
