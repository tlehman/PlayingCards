package com.definidev;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest extends Assert {

	@Test
	public void testInitCount() {
		Card cards[] = {
				new Card(Rank.ACE, Suit.CLUBS), 
				new Card(Rank.TWO, Suit.CLUBS), 
				new Card(Rank.THREE, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		assertEquals(3, deck.count());
	}
	
	@Test
	public void testInitAndAddCard() {
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.THREE, Suit.HEARTS));
		deck.addCard(new Card(Rank.SIX, Suit.HEARTS));
		deck.addCard(new Card(Rank.JACK, Suit.HEARTS));
		deck.addCard(new Card(Rank.EIGHT, Suit.SPADES));

		assertEquals(4, deck.count());
	}
	
	@Test
	public void testToString() {
		Card cards[] = {
				new Card(Rank.ACE, Suit.CLUBS), 
				new Card(Rank.TWO, Suit.CLUBS),
				new Card(Rank.THREE, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		assertEquals("AC 2C 3H", deck.toString());
	}
	
	/* ===== Test sorting methods (depends on tests above) ===== */

	@Test
	public void testSortByRank() {
		Card cards[] = {
				new Card(Rank.KING, Suit.CLUBS), 
				new Card(Rank.FOUR, Suit.CLUBS), 
				new Card(Rank.SIX, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		deck.sortByRank();
		
		assertEquals("4C 6H KC", deck.toString());
	}

	@Test
	public void testSortBySuit() {
		Card cards[] = {
				new Card(Rank.KING, Suit.DIAMONDS), 
				new Card(Rank.FOUR, Suit.SPADES), 
				new Card(Rank.SIX, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		deck.sortBySuit();
		
		assertEquals("KD 6H 4S", deck.toString());
	}
	
	/* ===== End sorting methods (depends on tests above) ===== */

	
	@Test
	public void testGetAtIndex() {
		Card cards[] = {
				new Card(Rank.KING, Suit.DIAMONDS), 
				new Card(Rank.FIVE, Suit.SPADES), 
				new Card(Rank.SIX, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		Card fourOfSpades = new Card(Rank.FIVE, Suit.SPADES);
		
		assertEquals(fourOfSpades, deck.getAtIndex(1));
	}
	
	@Test
	public void testDeckIterable() {
		HashMap<Rank, Deck> rankMap = new HashMap<Rank, Deck>();
		Card cards[] = {
				new Card(Rank.KING, Suit.SPADES), 
				new Card(Rank.SIX, Suit.SPADES), 
				new Card(Rank.SIX, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);

		for(Rank rank : Rank.values()) {
			rankMap.put(rank, new Deck());
		}
		for(Card card : deck) {
			rankMap.get(card.rank).addCard(card);
		}
		assertEquals(2, rankMap.get(Rank.SIX).count());
	}
	
	@Test
	public void testDeckCirclularIterator() {
		Card cards[] = {
				new Card(Rank.KING, Suit.SPADES), 
				new Card(Rank.SIX, Suit.SPADES), 
				new Card(Rank.SIX, Suit.HEARTS)
		};
		Deck deck = new Deck(cards);
		
		deck.nextCardCircular();
		deck.nextCardCircular();
		deck.nextCardCircular();
		deck.nextCardCircular();
		
		assertEquals(cards[1], deck.nextCardCircular());
	}
}
