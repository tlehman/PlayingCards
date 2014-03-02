package com.definidev;

/**
 * Deck is a collection of Cards, it allows iteration by:
 *   - rank
 *   - suit
 *   - random (shuffle)
 *
 * @author tlehman
 *
 */
public class Deck {
	private Card[] cards;

	public Deck(Card cards[]) {
		this.cards = cards;
	}
	
	public int count() {
		return cards.length;
	}
	
	public String toString() {
		StringBuffer deckStrBuf = new StringBuffer();
		
		for(int i = 0; i < cards.length; i++) {
			deckStrBuf.append(cards[i].toString());
			if(i < cards.length-1) {
				deckStrBuf.append(" ");
			}
		}
		
		return deckStrBuf.toString();
	}
}
