package org.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link Link} class.
 */
public class LinkTest {
    private Link link;
    private final int TEST_VALUE = 3;

    /**
     * Sets up a new Link instance before each test method is executed.
     */
    @BeforeEach
    void setUp() {
        link = new Link(TEST_VALUE);
    }

    /**
     * Tests the {@link Link#getValue()} method.
     */
    @Test
    public void testNewLinkCreation() {
        assertEquals(TEST_VALUE, link.getValue());
        assertNull(link.getNext());
        assertNull(link.getPrev());
    }

    /**
     * Tests the {@link Link#setPrev(Link)} method.
     */
    @Test
    public void testPreviousReference() {
        link.setPrev(new Link(5));
        assertEquals(5, link.getPrev().getValue());
    }

    /**
     * Tests the {@link Link#setNext(Link)} method.
     */
    @Test
    public void testNextReference() {
        link.setNext(new Link(7));
        assertEquals(7, link.getNext().getValue());
    }
}
