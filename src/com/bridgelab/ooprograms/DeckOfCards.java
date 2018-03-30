/**
 * Purpose : program to initialize, shuffle and distribute the deck of card
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelab.ooprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bridgelab.utility.OrderedList;
import com.bridgelab.utility.Queue;

public class DeckOfCards {

	public static void main(String[] args) {
		String[] suits = { "Club", "Diamond", "Heart", "Spade" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		List<Card> cardsList = new ArrayList<>();
		String suit = "", rank = "";
		for (int i = 0; i < 4; i++) {
			suit = suits[i];

			for (int j = 0; j < 13; j++) {
				rank = ranks[j];
				Card card = new Card();
				card.setRank(rank);
				card.setSuit(suit);
				cardsList.add(card);
			}
		}

		List<Card> suffuledCards = new ArrayList<>();
		while (cardsList.size() != 0) {
			int i = new Random().nextInt(cardsList.size());
			suffuledCards.add(cardsList.get(i));
			cardsList.remove(i);
		}

		Card[][] cards = new Card[4][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 4; j++) {
				cards[j][i] = suffuledCards.get(0);
				suffuledCards.remove(0);
			}
		}

		for (int i = 0; i < 4; i++) {
			System.out.print("\nPlayer " + (i + 1) + " : ");
			for (int j = 0; j < 9; j++) {
				System.out.print("{" + cards[i][j].getSuit() + "->" + cards[i][j].getRank() + "} ");
			}
			System.out.print("\n");
		}

		System.out.print("\n********************************************************************");

		Queue<Queue<Card>> playersCards = new Queue<>();
		for (int i = 0; i < 4; i++) {
			OrderedList<Card> player = new OrderedList<>();
			for (int j = 0; j < 9; j++) {
				player.add(cards[i][j]);
			}
			Queue<Card> cards2 = new Queue<>();
			for (int j = 0; j < 9; j++) {
				cards2.enqueue(player.pop());
			}
			playersCards.enqueue(cards2);
		}

		for (int i = 0; i < 4; i++) {
			Queue<Card> cards2 = playersCards.dequeue();
			System.out.print("\nPlayer " + (i + 1) + " : ");
			for (int j = 0; j < 9; j++) {
				Card cards3 = cards2.dequeue();
				System.out.print("[" + cards3.getSuit() + "->" + cards3.getRank() + "] ");
			}
			System.out.print("\n");
		}
	}

}
