package de.munich.softwerkskammer;

public class Frame {
	private final Rolls theRolls;
	private final int[] rolls;
	private int firstRollOfFramePosition;

	public Frame(Rolls theRolls, int[] rolls, int firstRollOfFramePosition) {
		this.theRolls = theRolls;
		this.rolls = rolls;
		this.firstRollOfFramePosition = firstRollOfFramePosition;
	}

	public boolean isSpare() {
		return rolls[firstRollOfFramePosition]
				+ rolls[firstRollOfFramePosition + 1] == 10;
	}

	public boolean isStrike() {
		return rolls[firstRollOfFramePosition] == 10;
	}
}
