package org.project.model;

import java.util.Random;

/**
 * The Chain class represents a doubly linked list of Link objects.
 * It provides methods for adding, deleting, and displaying links, as well as generating a random chain of links.
 */
public class Chain {
    /**
     * The first link in the chain.
     */
    private Link head;
    /**
     * The last link in the chain.
     */
    private Link tail;

    /**
     * Constructs an empty chain.
     */
    public Chain() {
    }

    /**
     * Creates a new chain with links.
     * Links are a random number between 5 and 100.
     *
     * @return a new random chain
     */
    public static Chain createRandomChain() {
        Chain chain = new Chain();

        Random rand = new Random();
        int length = rand.nextInt(96) + 5;
        for (int i = 0; i < length; i++) {
            int value = rand.nextInt(); // random value between -2,147,483,648 and 2,147,483,647
            chain.addLink(value);
        }

        return chain;
    }

    /**
     * Adds a new link with the specified value to the end of the chain.
     *
     * @param value the integer value to be stored in the new link
     */
    public void addLink(int value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            this.head = newLink;
        } else {
            newLink.setPrev(this.tail);
            this.tail.setNext(newLink);
        }
        this.tail = newLink;
    }

    /**
     * Deletes the first link in the chain and returns it.
     *
     * @return the first link in the chain
     */
    public Link deleteFirstLink() {
        Link temp = this.head;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        temp.setNext(null);
        return temp;
    }

    /**
     * Deletes the last link in the chain and returns it.
     *
     * @return the last link in the chain
     */
    public Link deleteLastLink() {
        Link temp = this.tail;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        temp.setPrev(null);
        return temp;
    }

    /**
     * Displays the values of all links in the chain.
     *
     * @return a string containing the values of all links in the chain, in order, separated by a space
     */
    public String displayChain() {
        StringBuilder result = new StringBuilder();
        Link current = this.head;
        while (current != null) {
            result.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return result.toString().trim();
    }

    /**
     * Returns true if the chain is empty, false otherwise.
     *
     * @return true if the chain is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Returns the first link in the chain.
     *
     * @return the first link in the chain
     */
    public Link getHead() {
        return head;
    }

    /**
     * Returns the last link in the chain.
     *
     * @return the last link in the chain
     */
    public Link getTail() {
        return tail;
    }
}