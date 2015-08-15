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

	@Test
	public void roll1GetFrame1() {
		game.roll(1);
		assertEquals("1", game.score(1));
	}

	@Test
	public void roll1_4_getFrame1() {
		game.roll(1);
		game.roll(4);
		assertEquals("5", game.score(1));
	}

	@Test
	public void roll_spare_getFrame1_empty() {
		game.roll(7);
		game.roll(3);
		assertEquals("", game.score(1));
	}

	@Test
	public void roll_spareAndBonus_getFrame1_result() {
		game.roll(7);
		game.roll(3);
		game.roll(2);
		assertEquals("12", game.score(1));
	}

	@Test
	public void roll_spareAndNextFrame_getFrame1_getFrame2_result() {
		game.roll(7);
		game.roll(3);
		game.roll(2);
		game.roll(6);
		assertEquals("12", game.score(1));
		assertEquals("20", game.score(2));
	}

	@Test
	public void roll_strike_getFrame1_empty() {
		game.roll(10);
		assertEquals("", game.score(1));
	}
	

	@Test
	public void roll_strike_firstRollInFrame2_getFrame1_empty() {
		game.roll(10);
		game.roll(2);
		assertEquals("", game.score(1));
		assertEquals("", game.score(2));
	}
}
