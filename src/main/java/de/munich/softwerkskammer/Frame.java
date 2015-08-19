package de.munich.softwerkskammer;

public class Frame {
	private final int[] rolls;
	private int firstRollOfFramePosition;

	public Frame(int[] rolls, int firstRollOfFramePosition) {
		this.rolls = rolls;
		this.firstRollOfFramePosition = firstRollOfFramePosition;
	}

	public boolean isSpare() {
		return rolls[firstRollOfFramePosition]
				+ rolls[firstRollOfFramePosition + 1] == 10;
	}
}
