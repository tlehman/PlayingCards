package com.definidev;


/**
 * Represents a Playing Card, stores a suit and a rank.
 * @author tlehman
 */
public class Card {
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
}
