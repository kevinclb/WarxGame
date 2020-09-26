package com.company;
import java.util.ArrayList;

public class gameBrain {
    Player player1;
    Player player2;
    public Deck gameDeck;


    public gameBrain() {
        //Creating a dealer, 2 players, hand setting their hands.
        gameDeck = new Deck();
        gameDeck.shuffle();
        player1 = new Player();
        player2 = new Player();
    }

    public void Deal() {
        for (int i = 0; i < 26; i++) {
            player1.playerHand.add(gameDeck.deal());
        }
        for (int i = 0; i < 26; i++){
            player2.playerHand.add(gameDeck.deal());
        }
    }


    public void Play(int rounds){
        boolean tiedResult;

        ArrayList<Card> tablePile1 = new ArrayList<>();
        ArrayList<Card> tablePile2 = new ArrayList<>();
        ArrayList<Card> tempPile1 = new ArrayList<>();
        ArrayList<Card> tempPile2 = new ArrayList<>();
        Card playedCard1;
        Card playedCard2;

        for (int i = 0; i < rounds; i++){
            boolean gameOver = false;
            boolean warOver = false;


            tiedResult = false;

            if(player1.playerHand.size()==0){
                System.out.println("Player 1 ran out of cards. Player 2 wins!");
                break;
            }
            else{
                playedCard1 = player1.playerHand.get(0);
            }
            if(player2.playerHand.size()==0){
                System.out.println("Player 2 ran out of cards. Player 1 wins!");
                break;
            }
            else{
                playedCard2 = player2.playerHand.get(0);
            }





            System.out.println("Player 1 plays : " + playedCard1.rank.name() + " of " + playedCard1.suit.name());
            System.out.println("Player 2 plays : " + playedCard2.rank.name() + " of " + playedCard2.suit.name());


            if (playedCard1.getValue() > playedCard2.getValue()){

                player1.playerHand.add(player1.playerHand.remove(0));
                player1.playerHand.add(player2.playerHand.remove(0));
                System.out.println("Player 1 wins the round");
            }
            else if (playedCard1.getValue() < playedCard2.getValue()){

                player2.playerHand.add(player1.playerHand.remove(0));
                player2.playerHand.add(player2.playerHand.remove(0));
                System.out.println("Player 2 wins the round");
            }
            else {
                do {
                    if ((player1.playerHand.size() >= 3) && (player2.playerHand.size() >= 3)) {
                        System.out.println("WAR TIME!");

                        for (int j = 0; j < 4; j++) {

                            if(j>(player1.playerHand.size()-1)){
                                System.out.println("Player 1 ran out of cards. Player 2 wins!");
                                gameOver = true;
                                break;
                            }
                            if(j>(player2.playerHand.size()-1)){
                                System.out.println("Player 2 ran out of cards. Player 1 wins!");
                                gameOver = true;
                                break;
                            }
                            playedCard1 = player1.playerHand.remove(j);
                            playedCard2 = player2.playerHand.remove(j);
                            tablePile1.add(playedCard1);
                            tablePile2.add(playedCard2);
                            tempPile1.add(playedCard1);
                            tempPile2.add(playedCard2);


                            if (j == 3) {
                                System.out.println("War card for player 1 is " + tempPile1.get(j).rank.name() + " of " + tempPile1.get(j).suit.name());
                                System.out.println("War card for player 2 is " + tempPile2.get(j).rank.name() + " of " + tempPile2.get(j).suit.name());

                                if (tempPile1.get(j).getValue() == tempPile2.get(j).getValue()){
                                    System.out.println("The round was a draw! Ranks are the same. War again!");
                                    tiedResult = true;
                                    tempPile1.clear();
                                    warOver = false;
                                }
                                else if (tempPile1.get(j).getValue()>tempPile2.get(j).getValue()){
                                    System.out.println("Player 1 wins the war!");
                                    for (int c = 0; c < tablePile1.size(); c++){
                                        player1.playerHand.add(tablePile1.remove(c));

                                    }warOver = true;

                                } else {
                                    System.out.println("Player 2 wins the war!");
                                    for (int c = 0; c < tablePile2.size(); c++) {
                                        player2.playerHand.add(tablePile2.remove(c));

                                    }warOver = true;
                                }

                            } else{
                                System.out.println("War card for player 1 is xx");
                                System.out.println("War card for player 2 is xx");
                            }
                        }if(warOver){System.out.println("War is over");break;}
                    } else if ((player1.playerHand.size() == 0)){
                        System.out.println("Player 1 loses the game!");
                        gameOver = true;
                        break;
                    } else if ((player2.playerHand.size() == 0)){
                        System.out.println("Player 2 loses the game!");
                    }

                } while (tiedResult);

            } if(gameOver){break;}
        }
    }
}