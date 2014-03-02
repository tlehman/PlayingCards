package com.definidev;

import java.util.Comparator;


/**
 * Represents a Playing Card, stores a suit and a rank.
 * 
 * @author tlehman
 */
public class Card implements Comparable<Card> {
	public Suit suit;
	public Rank rank;

	/**
	 * Deterministic constructor takes a rank and a suit
	 * @param rank  a Rank such as ACE
	 * @param suit  a Suit such as CLUBS 
	 */
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		
	}
	/**
	 * Default constructor randomly generates a rank and a suit
	 */
	public Card() {
		rank = Rank.ACE;
		suit = Suit.CLUBS;
	}

	public String toString() {
		return String.format("%s%s", rank.toString(), suit.toString());
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof Card) {
			Card othercard = (Card)other;
			return this.rank == othercard.rank && this.suit == othercard.suit;
		}
		return false;
	}

	@Override
	/**
	 * By default, sort by rank
	 */
	public int compareTo(Card card2) {
 		Rank rank2 = card2.rank;
		
		return this.rank.compareTo(rank2);
	}

	public static Comparator<Card> CardRankComparator = new Comparator<Card>() {
		public int compare(Card card1, Card card2) {
			Rank rank1 = card1.rank;
			Rank rank2 = card2.rank;
			
			return rank1.compareTo(rank2);
		}
	};

	public static Comparator<Card> CardSuitComparator = new Comparator<Card>() {
		public int compare(Card card1, Card card2) {
			Suit suit1 = card1.suit;
			Suit suit2 = card2.suit;
			
			return suit1.compareTo(suit2);
		}
	};
	
}
