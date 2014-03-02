package com.definidev;

public class Deck {
	private Card[] cards;

	public Deck(Card cards[]) {
		this.cards = cards;
	}
	
	public int count() {
		return cards.length;
	}
}
