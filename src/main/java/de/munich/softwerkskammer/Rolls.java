package de.munich.softwerkskammer;

public class Rolls {
	public final int[] rolls = new int[21];
	private int currentRoll = 0;

	public void addRoll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int strikeBonus(int firstRollOfFramePosition) {
		return rolls[firstRollOfFramePosition + 1]
				+ rolls[firstRollOfFramePosition + 2];
	}

	public int spareBonus(int firstRollOfFramePosition) {
		return rolls[firstRollOfFramePosition + 2];
	}

	public int sumOfBallsInFrame(int firstRollOfFramePosition) {
		return rolls[firstRollOfFramePosition]
				+ rolls[firstRollOfFramePosition + 1];
	}
}
