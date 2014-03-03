package com.definidev;

import java.util.ArrayList;
import java.util.Collections;

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
	private ArrayList<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public Deck(Card cards[]) {
		this.cards = new ArrayList<Card>();

		for(Card c : cards) {
			this.cards.add(c);
		}
	}
	
	public int count() {
		return cards.size();
	}
	
	public String toString() {
		StringBuffer deckStrBuf = new StringBuffer();
		
		for(int i = 0; i < cards.size(); i++) {
			deckStrBuf.append(cards.get(i).toString());
			if(i < cards.size()-1) {
				deckStrBuf.append(" ");
			}
		}
		
		return deckStrBuf.toString();
	}
	
	public void sortByRank() {
		Collections.sort(cards, Card.CardRankComparator);
	}
	
	public void sortBySuit() {
		Collections.sort(cards, Card.CardSuitComparator);
	}
	
	public Card getAtIndex(int index) {
		return cards.get(index);
	}

	public void addCard(Card card) {
		cards.add(card);
	}
}
