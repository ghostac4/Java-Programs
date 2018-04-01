package com.bridgelab.ooprograms;

public class Card implements Comparable<Card>{

	private String suit;
	private String rank;
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Override
	public int compareTo(Card card) {
		if(this.rank.equals(card.getRank()))
			return 0;
		else if(this.rank.compareTo(card.getRank()) > 0)
			return 1;
		else
			return -1;
	}
	
	
}
