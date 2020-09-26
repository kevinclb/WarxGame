package com.company;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    public ArrayList<Card> storage;


    public Deck()
    {

        //this Deck constructor creates
        //a default arraylist of Card objects
        //based on the suits and ranks

        Suits[] suits = Suits.values();
        Ranks[] ranks = Ranks.values();
        storage = new ArrayList<>();

        Card C1;
        for (Suits suit : suits)
            for (Ranks rank : ranks) {
                C1 = new Card(rank, suit);
                storage.add(C1);
            }
    }

    public void display()
    {
        //this code displays the deck as is
        for (int i = 0; i < storage.size(); i++){
            storage.get(i).display();
            System.out.print(" ");
            if (i == 12 || i == 25 || i == 38){
                System.out.println();
            }
        }

        System.out.println("\n");
    }

    public void shuffle()
    {

        //this function shuffle() uses Collections.swap along with the min and max
        //to take two random cards and swap them 51 times, aka shuffling
        int min = 0;
        int max = 51;

        for (int i = 0; i < 52; i++){
            int random_ind = (int)(Math.random() * (max - min + 1) + min);
            int random_ind2 = (int)(Math.random() * (max - min + 1) + min);
            Collections.swap(storage,random_ind,random_ind2);
        }

    }

    public Card deal()
    {
        //this simple set of code is responsible for
        // retrieving a card from a deck using .get(0), then removing it

        Card dealtCard = storage.get(0);
        storage.remove(0);
        return dealtCard;
    }

//    public int cardsLeft() // how many cards are left in the deck
//    {
//        return storage.size();
//    }


}
