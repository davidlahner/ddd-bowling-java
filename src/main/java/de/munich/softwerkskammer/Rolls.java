package de.munich.softwerkskammer;

public class Rolls {
	public final int[] rolls = new int[21];
	private int currentRoll = 0;

	public void addRoll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int strikeBonus(int firstRollOfFramePosition) {
		if (!strikeBonusRollsExist(firstRollOfFramePosition)) {
			throw new UnknownBonusException();
		}
		return rolls[firstRollOfFramePosition + 1]
				+ rolls[firstRollOfFramePosition + 2];
	}

	private boolean strikeBonusRollsExist(int firstRollOfFramePosition) {
		return rollAtPositionExists(firstRollOfFramePosition + 1)
				&& rollAtPositionExists(firstRollOfFramePosition + 2);
	}

	public int spareBonus(int firstRollOfFramePosition) {
		if (!spareBonusRollExists(firstRollOfFramePosition)) {
			throw new UnknownBonusException();
		}
		return rolls[firstRollOfFramePosition + 2];
	}

	private boolean spareBonusRollExists(int firstRollOfFramePosition) {
		return rollAtPositionExists(firstRollOfFramePosition + 2);
	}

	public int rollAtPosition(int position) {
		return rolls[position];
	}

	private boolean rollAtPositionExists(int rollPosition) {
		return currentRoll - 1 >= rollPosition;
	}

	public int sumOfBallsInFrame(int firstRollOfFramePosition) {
		return rolls[firstRollOfFramePosition]
				+ rolls[firstRollOfFramePosition + 1];
	}
}
