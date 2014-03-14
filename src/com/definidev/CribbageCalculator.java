package com.definidev;

import java.util.ArrayList;
import java.util.HashMap;

public class CribbageCalculator {
	private Deck deck;
	private int score;
	private ArrayList<String> scores;
	public final int FLUSH_MIN = 4;
	public final int RUN_MIN = 3;

	public CribbageCalculator(Deck deck) {
		this.deck = deck;
		this.score = 0;
		this.scores = new ArrayList<String>();
		calculate();
	}

	public int score() {
		return score;
	}
	
	public String[] scores() {
		return scores.toArray(new String [scores.size()]);
	}

	/**
	 * calculate() applies the rules of Cribbage to determine the score,
	 * store that integer value, and keep descriptions of each hand in 
	 * scores
	 * 
	 * Some usage examples can be found in CribbageCalculatorTest
	 */
	private void calculate() {
		// Count Pairs
		//    A Pair is any two distinct cards that have the same rank
		Card left, right;
		for(int i = 0; i < deck.count(); i++) {
			for(int j = 0; j < i; j++) {
				left = deck.getAtIndex(i);
				right = deck.getAtIndex(j);
				
				if(left.rank == right.rank) {
					score += 2;
					scores.add(String.format("Pair for 2 : %s %s", left.toString(), right.toString()));
				}
			}
		}

		// Count Fifteens
		//    Loop over all subsets of cards, summing the ranks of each
		for(int subsetNum = 1; subsetNum < (int)Math.pow(2, deck.count()); subsetNum++) {
			int ones = countOnes(subsetNum);
			Card subset[] = new Card[ones];
			int subsetIndex = 0;
	
			// Populate subset with cards
			for(int i = 0; i < 32; i++) {
	            if(ithBitIsOne(subsetNum, i) && subsetIndex < ones) {
	                subset[subsetIndex] = deck.getAtIndex(i);
	                subsetIndex += 1;
	            }
			}
			
			// Check if subset ranks sum to Fifteen
			int sum = 0;
			for(Card c : subset) {
				if(c != null) sum += rankValue(c.rank);
			}
			if(sum == 15) {
				Deck subdeck = new Deck(subset);
	
				score += 2;
				scores.add(String.format("Fifteen for 2 : %s", subdeck.toString()));
			}
		}

		// A Run is a sequence of 3 or more cards with contiguous ranks.
		//   Count Maximal Runs
		//
		//   This algorithm gathers all cards of the same rank into 
		//   a deck like so:
		//
		//      A 2 3 4 5 6 7 8 9 10 J Q K
		//        = = = = 
		//          =   =
		//              =
		// 
		//   The above map would have multiplicity=6, runLength=4
		//
		deck.sortByRank();
		HashMap<Rank, Deck> rankMap = new HashMap<Rank, Deck>();
		for(Rank rank : Rank.values()) {
			rankMap.put(rank, new Deck());
		}
		for(Card card : deck) {
			rankMap.get(card.rank).addCard(card);
		}
		Rank ranks[] = Rank.values();
		int runLength = 0;
		int multiplicity = 1;
		Card currentCard = null;
		Deck rankDeck = null;
		Deck runDeck = null;

		// determine multiplicity for final enumeration loop
		for(int i = 0; i <= ranks.length; i++) {
			if(ranks.length == i) {
				rankDeck = null;
			} else {
				rankDeck = rankMap.get(ranks[i]);
			}

			if(rankDeck == null || rankDeck.count() == 0) {
				if(runLength >= RUN_MIN) {
					for(int j = 0; j < multiplicity; j++) {
						runDeck = new Deck();

						for(int k = i-runLength; k < i; k++) {
							currentCard = rankMap.get(ranks[k]).nextCardCircular();
							runDeck.addCard(currentCard);
							System.out.printf("%s ", currentCard);
						}

						score += runLength;
						//scores.add(String.format("Run of %d for %d : %s", runLength, runLength, runDeck.toString()));
						System.out.printf("\n");
					}
				}
				runLength = 0;
				multiplicity = 1;
			} else {
				runLength += 1;
				multiplicity *= rankDeck.count();
			}
		}

		// A Flush is a sequence of 4 or more cards of the same suit.  
		//   Count Maximal Flushes
		deck.sortBySuit();
		Deck clubDeck = new Deck();
		Deck diamondDeck = new Deck();
		Deck heartDeck = new Deck();
		Deck spadeDeck = new Deck();
		Deck currentDeck = null;
		ArrayList<Deck> flushDecks = new ArrayList<Deck>();

		for(Card card : deck) {
			switch(card.suit) {
			case CLUBS:
				clubDeck.addCard(card);
				currentDeck = clubDeck;
				break;
			case DIAMONDS:
				diamondDeck.addCard(card);
				currentDeck = diamondDeck;
				break;
			case HEARTS:
				heartDeck.addCard(card);
				currentDeck = heartDeck;
				break;
			case SPADES:
				spadeDeck.addCard(card);
				currentDeck = spadeDeck;
				break;
			default:
				break;
			}
			if(currentDeck != null && currentDeck.count() >= FLUSH_MIN) {
				flushDecks.add(currentDeck);
			}
		}
		for(Deck deck : flushDecks) {
			scores.add(String.format("Flush for %d : %s", deck.count(), deck.toString()));
			score += deck.count();
		}
	}
	
	/**
	 * Count number of bits in integer that are set to 1
	 * 
	 * Note: This technique is described here: http://tobilehman.com/blog/2014/02/08/counting-bits-in-integers/
	 * 
	 * @param bits
	 * @return
	 */
	private int countOnes(int bits) {
	    int v = bits;
	    int c = 0;
	    for(c = 0; v != 0; ++c) {
	        v &= v-1;
	    }
	    return c;
	}
	
	/**
	 * Check if the i-th bit of N is set to 1
	 */
	private boolean ithBitIsOne(int n, int i) {
		int two_to_i = (int)Math.pow(2, i);
		return (two_to_i & n) != 0;
	}
	
	/**
	 * Check the value of the rank (for Cribbage)
	 * TODO: Make Scoreable interface that different objects can implement
	 */
	private int rankValue(Rank rank) {
		if(rank.rankIndex() > 10) return 10;
		return rank.rankIndex();
	}
}
