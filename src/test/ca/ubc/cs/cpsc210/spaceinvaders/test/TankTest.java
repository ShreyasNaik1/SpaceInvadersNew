package ca.ubc.cs.cpsc210.spaceinvaders.test;

import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Unit tests for the Tank class.
 */
public class TankTest {
	private static final int XLOC = SIGame.WIDTH / 2;
	private Tank tank;
	
	@BeforeEach
	public void runBefore() {
		tank = new Tank(XLOC);
	}
	
	@Test
	public void testXXX() {
		// template for tests
	}
}
