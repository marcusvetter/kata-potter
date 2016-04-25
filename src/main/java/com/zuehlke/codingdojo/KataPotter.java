package com.zuehlke.codingdojo;

import java.util.Arrays;

public class KataPotter  {

    public static double price(int[] books) {
        double[] discountArray = {1.0, 1.0, 0.95, 0.9, 0.8, 0.75};

        double price = price(books, discountArray, 2);

        for (int i = 5; i > 2; i--) {
            double newPrice = price(books, discountArray, i);
            if (newPrice < price) {
                price = newPrice;
            }
        }

        return price;
    }

    private static double price(int[] books, double[] discountArray, int distinctLimit) {
        double price = 0;

        int[] bookCounts = new int[5];
        Arrays.stream(books).forEach(book -> bookCounts[book]++);

        while (Arrays.stream(bookCounts).sum() > 0) {

            int amountOfDistinctBooks = 0;

            for (int i = 0; i < bookCounts.length; i++) {
                if (bookCounts[i] > 0) {
                    bookCounts[i]--;
                    amountOfDistinctBooks++;
                }
                if (amountOfDistinctBooks == distinctLimit) break;
            }

            double discount = discountArray[amountOfDistinctBooks];
            price += amountOfDistinctBooks * 8 * discount;

        }
        return price;
    }
}