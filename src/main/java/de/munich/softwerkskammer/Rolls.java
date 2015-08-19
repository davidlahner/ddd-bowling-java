package de.munich.softwerkskammer;

public class Rolls {
	public final int[] rolls = new int[21];
	public int currentRoll = 0;

	public void addRoll(int pins) {
		rolls[currentRoll++] = pins;
	}
}
