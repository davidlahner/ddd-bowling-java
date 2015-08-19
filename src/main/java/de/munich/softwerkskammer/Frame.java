package de.munich.softwerkskammer;

public class Frame {
	private final Rolls theRolls;
	private final int firstRollOfFramePosition;

	public Frame(Rolls theRolls, int firstRollOfFramePosition) {
		this.theRolls = theRolls;
		this.firstRollOfFramePosition = firstRollOfFramePosition;
	}

	public boolean isSpare() {
		return theRolls.rollAtPosition(firstRollOfFramePosition)
				+ theRolls.rollAtPosition(firstRollOfFramePosition + 1) == 10;
	}

	public boolean isStrike() {
		return theRolls.rollAtPosition(firstRollOfFramePosition) == 10;
	}
}
