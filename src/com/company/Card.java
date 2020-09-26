//Kevin Babou
//For: Steven Gold, CECS 277, Tuesday Section
//Program 1 - Solitaire Prime
//Card.java
package com.company;
public class Card {

    Ranks rank;
    Suits suit;

    public Card(Ranks r, Suits s) {
        this.rank = r;
        this.suit = s;
    }

    public void display() {
        System.out.print(rank);
        System.out.print(" of ");
        System.out.print(suit);
        System.out.print(",");
    }

    public int getValue(){
        switch(rank){
            case ACE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:case JACK:case QUEEN: case KING:
                return 10;
            default:
                return 0;
        }

    }

    @Override
    public String toString() {
        return rank + " of " + suit + ", ";
    }
}

