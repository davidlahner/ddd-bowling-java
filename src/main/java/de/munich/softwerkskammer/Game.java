package de.munich.softwerkskammer;

public class Game {
    private Integer rolls[] = new Integer[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[frameIndex] == null) break;

            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }


    public Integer score(int frameToCalculate) {
        int score = 0;
        int frameIndex = 0;
        Integer frameScores[] = new Integer[10];

        for (int frame = 0; frame < 10; frame++) {
            if (rolls[frameIndex] == null) break;

            if (isStrike(frameIndex)) {
                if (rolls[frameIndex+1] == null) break;

                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else {
                if (rolls[frameIndex+1] == null) break;

                if (isSpare(frameIndex)) {
                    if (rolls[frameIndex+2] == null) break;

                    score += 10 + spareBonus(frameIndex);
                    frameIndex += 2;
                } else {
                    score += sumOfBallsInFrame(frameIndex);
                    frameIndex += 2;
                }
            }

            frameScores[frame] = score;
        }

        return frameScores[frameToCalculate];
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
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

}