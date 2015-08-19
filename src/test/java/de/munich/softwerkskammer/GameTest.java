package de.munich.softwerkskammer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void beforeTest() {
        game = new Game();
    }

    @Test
    public void calcFrameScoreAfterFirstRoll() {
        game.roll(1);
        assertEquals(new Integer(1), game.score(0));
    }

    @Test
    public void calcFrameScoreInSecondFrameAfterFirstRoll() {
        game.roll(1);
        game.roll(1);
        game.roll(1);
        assertEquals(new Integer(2), game.score(0));
        assertEquals(new Integer(3), game.score(1));
    }

    @Test
    public void calcFrameScoreAfterCompletedFrame() {
        game.roll(1);
        game.roll(4);
        assertEquals(new Integer(5), game.score(0));
        assertEquals(null, game.score(1));
    }

    @Test
    public void calcFrameScoreAfterSpareNotPossible() {
        game.roll(7);
        game.roll(3);

        assertEquals(null, game.score(0));
    }

    @Test
    public void calcFrameScoreAfterSpareAndStrike() {
        game.roll(1);
        game.roll(9);
        game.roll(10);

        assertEquals(new Integer(20), game.score(0));
        assertEquals(null, game.score(1));
    }

    @Test
    public void calcFrameScoreAfterSpare() {
        game.roll(7);
        game.roll(3);
        game.roll(2);
        game.roll(6);

        assertEquals(new Integer(12), game.score(0));
        assertEquals(new Integer(20), game.score(1));
        assertEquals(null, game.score(2));
    }

    @Test
    public void calcFrameScoreAfterStrike() {
        game.roll(10);

        assertEquals(null, game.score(0));
    }

    @Test
    public void calcFrameScoreAfterStrikeAndNotSpecialFrame() {
        game.roll(10);
        game.roll(2);
        game.roll(6);

        assertEquals(new Integer(18), game.score(0));
        assertEquals(new Integer(26), game.score(1));
        assertEquals(null, game.score(2));
    }

    @Test
    public void calcFrameScoreAfterStrikeAndStrike() {
        game.roll(10);
        game.roll(10);

        assertEquals(null, game.score(0));
    }

    @Test
    public void calcFrameScoreAfterStrikeAndStrikeAndStrike() {
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertEquals(new Integer(30), game.score(0));
        assertEquals(null, game.score(1));
    }

    @Test
    public void calcFrameScoreAfterStrikeAndStrikeAndNormalFrameNotCompleted() {
        game.roll(10);
        game.roll(10);
        game.roll(2);

        assertEquals(new Integer(22), game.score(0));
        assertEquals(null, game.score(1));
    }

    @Test
    public void calcFrameScoreAfterStrikeAndStrikeAndNormalFrame() {
        game.roll(10);
        game.roll(10);
        game.roll(2);
        game.roll(7);

        assertEquals(new Integer(22), game.score(0));
        assertEquals(new Integer(41), game.score(1));
        assertEquals(new Integer(50), game.score(2));
    }

    @Test
    public void calcFrameScoreAfterStrikeAndSpare() {
        game.roll(10);
        game.roll(1);
        game.roll(9);

        assertEquals(new Integer(20), game.score(0));
        assertEquals(null, game.score(1));
    }

    @Test
    public void calcFrameScoreAfterStrikeAndNotCompletedFrame() {
        game.roll(10);
        game.roll(2);

        assertEquals(null, game.score(0));
    }


    @Test
    public void initialScoreShouldBeZero() {
        assertEquals(0, game.score());
    }

    @Test
    public void strikesOnlyShouldReturn300() {
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        assertEquals(300, game.score());
    }

    @Test
    public void pairsOfNineAndMissShouldReturn90() {
        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);

        game.roll(9);
        game.roll(0);
        assertEquals(90, game.score());
    }

    @Test
    public void fivesOnlyShouldReturn150() {
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        assertEquals(150, game.score());
    }

    @Test(expected = RuntimeException.class)
    public void rollingMoreThen21TimesShouldThrowException() {
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
    }

}
