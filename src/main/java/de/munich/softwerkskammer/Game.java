package de.munich.softwerkskammer;

public class Game {
	private static final int NUMBER_OF_FRAMES = 10;
	private final Rolls rolls = new Rolls();

	public void roll(int pins) {
		rolls.addRoll(pins);
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
			Frame currentFrame = new Frame(rolls.rolls, frameIndex);
			if (currentFrame.isStrike()) {
				score += 10 + rolls.strikeBonus(frameIndex);
				frameIndex++;
			} else if (currentFrame.isSpare()) {
				score += 10 + rolls.spareBonus(frameIndex);
				frameIndex += 2;
			} else {
				score += rolls.sumOfBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}
}