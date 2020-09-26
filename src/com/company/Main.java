package com.company;
import java.util.Scanner;


public class Main {
    static gameBrain game;

    public static void main(String[] args) {

        game = new gameBrain();
        battle();
    }

    public static void battle() {
        int battleNumber;
        Scanner in = new Scanner(System.in);

        int userChoice = 0;




        while (userChoice != 5) {
            System.out.println("\nWelcome to WAR!");
            System.out.println("1) New Deck");
            System.out.println("2) Shuffle Deck");
            System.out.println("3) Display Deck");
            System.out.println("4) Play WAR!");
            System.out.println("5) Exit");
            userChoice = in.nextInt();
            if (userChoice == 1) {
                System.out.println("You have selected New Deck.\n");
                game.gameDeck = new Deck();

            } else if (userChoice == 2) {
                System.out.println("You have selected Shuffle Deck.");
                game.gameDeck.shuffle();
            } else if (userChoice == 3) {
                System.out.println("You have selected Display Deck.");
                game.gameDeck.display();
            } else if (userChoice == 4) {
                System.out.println("You have selected to play WAR!");
                {
                    int count=0;
                    System.out.println("What is the maximum battle number?\n");
                    battleNumber = in.nextInt();
                    game.Deal();
                    System.out.println("Player 1's cards:");
                    for (Card c : game.player1.playerHand){
                        count+=1;
                        System.out.print(c.toString());
                        if (count==13){System.out.println();}
                    }
                    System.out.print("\n\n");
                    count=0;
                    System.out.println("Player 2's cards:");
                    for (Card c: game.player2.playerHand){
                        count +=1;
                        System.out.print(c.toString());
                        if (count==13){System.out.println();}
                    }
                    System.out.println(game.player1.playerHand.get(0).toString());
                    System.out.println("Press any key to continue.\n");
                    in.next();
                    game.Play(battleNumber);

                }
                System.out.println("Press any key to continue.");
                in.next();}

            else if (userChoice == 5) {
                System.out.print("You've decided to quit!\nThanks for playing!");
            }

        }
    }

}