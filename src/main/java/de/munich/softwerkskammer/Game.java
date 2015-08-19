package de.munich.softwerkskammer;

public class Game {
	private static final int NUMBER_OF_FRAMES = 10;
	private int rolls[] = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score(int frame) {
		return runningScore(frame);
	}

	public int score() {
		return runningScore(NUMBER_OF_FRAMES);
	}

	private int runningScore(int untilFrame) {
		int score = 0;
		int frameIndex = 0;
		for (int frame = 0; frame < untilFrame; frame++) {
			Frame currentFrame = new Frame(rolls, frameIndex);
			if (isStrike(frameIndex)) {
				score += 10 + strikeBonus(frameIndex);
				frameIndex++;
			} else if (isSpare(frameIndex, currentFrame)) {
				score += 10 + spareBonus(frameIndex);
				frameIndex += 2;
			} else {
				score += sumOfBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

	private boolean isSpare(int frameIndex, Frame currentFrame) {
		return currentFrame.rolls[currentFrame.firstRollOfFramePosition]
				+ currentFrame.rolls[currentFrame.firstRollOfFramePosition + 1] == 10;
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex + 1] + rolls[frameIndex + 2];
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex + 2];
	}

	private int sumOfBallsInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}
}