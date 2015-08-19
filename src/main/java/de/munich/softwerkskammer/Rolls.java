package de.munich.softwerkskammer;

public class Rolls {
	public final int[] rolls;
	public int currentRoll;

	public Rolls(int[] rolls, int currentRoll) {
		this.rolls = rolls;
		this.currentRoll = currentRoll;
	}

	public void addRoll(int pins) {
		rolls[currentRoll++] = pins;
	}
}
