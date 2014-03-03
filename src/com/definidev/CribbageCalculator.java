package com.definidev;

import java.util.ArrayList;
import java.util.HashMap;

public class CribbageCalculator {
	private Deck deck;
	private int score;
	private ArrayList<String> scores;

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
	    //
	    //    To find runs, we keep track of these data:
	    //      run_length    int
	    //      multiplicity  int
	    //      index         int
	    //      rank_map      HashMap<Rank, Deck>
	    //
	    //    Before we introduce the algorithm, it is helpful to see an 
	    //    example, suppose our hand is:
	    //        9H  8H  6C  7S  8D  8C
	    //    we start by computing rank_map: 
	    //        A 2 3 4 5 6 7 8 9 10 J K Q
	    //        0 0 0 0 0 1 1 3 1  0 0 0 0
	    //                  ^ scan until the first nonzero value is found, 
	    //                    then scan until you hit the next zero value:
	    //        A 2 3 4 5 6 7 8 9 10 J K Q
	    //        0 0 0 0 0 1 1 3 1  0 0 0 0
	    //                           ^ at this point you should have run_length = 4
	    //                             and 4 >= 3, so it counts as a run.
	    //                             Notice that you have three runs:
	    //                                  6C  7  8D  9H  
	    //                                   "  "  8H   "
	    //                                   "  "  8C   "
	    //                             This is why multiplicity is multiplied 
	    //                             with run_length to compute the score.
	    //
	    //    The algorithm goes like this:
	    //      Initialize index        = 0
	    //                 multiplicity = 1
	    //                 run_length   = 0
	    //      Scan from left to right (increasing index)
	    //
	    //      Loop index 0 to 13
	    //          if rank_map[index] > 0
	    //              run_length += 1
	    //              multiplicity *= rank_map[index]
	    //          else
	    //              if run_length >= 3
	    //                  display (run_length, multiplicity * run_length)
	    //              endif
	    //              run_length = 0
	    //              multiplicity = 1
	    //          endif
	    //      End Loop
	    //
		// Count Maximal Runs
		HashMap <Rank, Deck> rankMap = new HashMap<Rank, Deck>();
		for(Rank rank : Rank.values()) {
			rankMap.put(rank, new Deck());
		}
		// Collect all cards with same rank into Decks
		for(Card card : deck) {
			rankMap.get(card.rank).addCard(card);
		}

		for(Rank rank : Rank.values()) {
			
		}

		// Count Maximal Flushes
		deck.sortBySuit();
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
