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
	
	public static Rank fromString(String rankStr) {
		Rank rank;
		if (rankStr.equalsIgnoreCase("A")) {
			rank = ACE;
		} else if (rankStr.equalsIgnoreCase("2")) {
			rank = TWO;
		} else if (rankStr.equalsIgnoreCase("3")) {
			rank = THREE;
		} else if (rankStr.equalsIgnoreCase("4")) {
			rank = FOUR;
		} else if (rankStr.equalsIgnoreCase("5")) {
			rank = FIVE;
		} else if (rankStr.equalsIgnoreCase("6")) {
			rank = SIX;
		} else if (rankStr.equalsIgnoreCase("7")) {
			rank = SEVEN;
		} else if (rankStr.equalsIgnoreCase("8")) {
			rank = EIGHT;
		} else if (rankStr.equalsIgnoreCase("9")) {
			rank = NINE;
		} else if (rankStr.equalsIgnoreCase("10")) {
			rank = TEN;
		} else if (rankStr.equalsIgnoreCase("J")) {
			rank = JACK;
		} else if (rankStr.equalsIgnoreCase("Q")) {
			rank = QUEEN;
		} else {
			rank = KING;
		}
		return rank;
	}
	
	public int rankIndex() {
		return rankIndex;
	}
}
