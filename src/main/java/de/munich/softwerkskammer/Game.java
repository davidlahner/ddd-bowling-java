package de.munich.softwerkskammer;

public class Game {
	private static int NOT_ENOUGH_INFORMATION = -9999;
	
	private int rolls[] = new int[21];
    private int currentRoll = 0;
    
    public Game() {
		super();
		for(int i=0; i<21;i++) {
			rolls[i]=NOT_ENOUGH_INFORMATION;
		}
	}

	public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        return score(1, 10);
    }

	private int score(int beginFrame, int endFrame) {
		int score = 0;
        int frameIndex = 0;
		for (int frame = beginFrame; frame <= endFrame; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
            	if(frameIndex+1 == endFrame && frameIndex != 9 && rolls[frameIndex+2]== NOT_ENOUGH_INFORMATION) {
            		return NOT_ENOUGH_INFORMATION;
            	}
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

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int sumOfBallsInFrame(int frameIndex) {
        int firstRoll = rolls[frameIndex] == NOT_ENOUGH_INFORMATION ? 0 : rolls[frameIndex];
		int secondRoll = rolls[frameIndex + 1] == NOT_ENOUGH_INFORMATION ? 0 : rolls[frameIndex+1];
		return firstRoll + secondRoll;
    }

	public String score(int frame) {
		int score = score(frame, frame);
		return score == NOT_ENOUGH_INFORMATION ? "" : score+"";
	}

}