package com.definidev;

public enum Rank {
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
			EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
	
	private final int rankIndex;

	Rank(int rank) {
		rankIndex = rank;
	}
	
	public String toString() {
		String rankStr;

		switch(this) {
		case ACE:
			rankStr = "A";
			break;
		case JACK:
			rankStr = "J";
			break;
		case QUEEN:
			rankStr = "Q";
			break;
		case KING:
			rankStr = "K";
			break;
		default:
			rankStr = String.format("%d", rankIndex);
		}
		return rankStr;
	}
	
	public int rankIndex() {
		return rankIndex;
	}
}
