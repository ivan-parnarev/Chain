package org.project.model;

/**
 * The Link class represents a node in a linked list.
 * It stores an integer value and maintains pointers to the next and previous nodes in the list.
 */
public class Link {
    /**
     * The integer value stored in this link.
     */
    private final int value;
    /**
     * A reference to the next link in the list.
     */

    private Link next;
    /**
     * A reference to the previous link in the list.
     */
    private Link prev;

    /**
     * Constructs a new link with the specified value.
     *
     * @param value the integer value to be stored in this link
     */
    public Link(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value stored in this link.
     *
     * @return the integer value stored in this link
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns a reference to the next link in the list.
     *
     * @return a reference to the next link in the list
     */
    public Link getNext() {
        return this.next;
    }

    /**
     * Sets the next link in the list to the specified link.
     *
     * @param next the link to be set as the next link in the list
     */
    public void setNext(Link next) {
        this.next = next;
    }

    /**
     * Returns a reference to the previous link in the list.
     *
     * @return a reference to the previous link in the list
     */
    public Link getPrev() {
        return prev;
    }

    /**
     * Sets the previous link in the list to the specified link.
     *
     * @param prev the link to be set as the previous link in the list
     */
    public void setPrev(Link prev) {
        this.prev = prev;
    }
}
