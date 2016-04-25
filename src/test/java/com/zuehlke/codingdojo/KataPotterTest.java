package com.zuehlke.codingdojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataPotterTest {

    @Test
    public void buyZeroBooks() {
        int[] books = {};
        double price = KataPotter.price(books);
        assertEquals(0, price, 0);
    }

    @Test
    public void buyOneBooks() {
        int[] books = {0};
        double price = KataPotter.price(books);
        assertEquals(8, price, 0);
    }

    @Test
    public void buyTwoIdenticalBooks() {
        int[] books = {0, 0};
        double price = KataPotter.price(books);
        assertEquals(8 + 8, price, 0);
    }

    @Test
    public void buyTwoDifferentBooks() {
        int[] books = {0, 1};
        double price = KataPotter.price(books);
        assertEquals(0.95 * (8 + 8), price, 0);
    }

    @Test
    public void buyThreeDifferentBooks() {
        int[] books = {0, 1, 2};
        double price = KataPotter.price(books);
        assertEquals(0.90 * (8 + 8 + 8), price, 0);
    }

    @Test
    public void buyFourDifferentBooks() {
        int[] books = {0, 1, 2, 3};
        double price = KataPotter.price(books);
        assertEquals(0.80 * (8 + 8 + 8 + 8), price, 0);
    }

    @Test
    public void buyFiveDifferentBooks() {
        int[] books = {0, 1, 2, 3, 4};
        double price = KataPotter.price(books);
        assertEquals(0.75 * (8 + 8 + 8 + 8 + 8), price, 0);
    }

    @Test
    public void buyTwoIdenticalOneDifferentBook() {
        int[] books = {0, 0, 1};
        double price = KataPotter.price(books);
        assertEquals(8 + (8 * 2 * 0.95), price, 0);
    }

    @Test
    public void buyTwoIdenticalTwoDifferentBook() {
        int[] books = {0, 0, 1, 1};
        double price = KataPotter.price(books);
        assertEquals(2 * (8 * 2 * 0.95), price, 0);
    }

    @Test
    public void pairOfTwoIdenticalBooksAndTwoAdditionalDifferentBooks() {
        int[] books = {0, 0, 1, 2, 2, 3};
        double price = KataPotter.price(books);
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), price, 0);
    }

    @Test
    public void onePairAndFourDifferentBooks() {
        int[] books = {0, 1, 1, 2, 3, 4};
        double price = KataPotter.price(books);
        assertEquals((8 + (8 * 5 * 0.75)), price, 0);
    }

    @Test
    public void twoFourth() {
        int[] books = {0, 1, 2, 3, 0, 1, 2, 4};
        double price = KataPotter.price(books);
        assertEquals(2 * (8 * 4 * 0.8), price, 0);
    }

    @Test
    public void lolFooBarTestUltimate() {
        int[] books = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
        double price = KataPotter.price(books);
        assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), price, 0);
    }
}