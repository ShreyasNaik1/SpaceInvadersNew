package ca.ubc.cs.cpsc210.spaceinvaders.test;

import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.ubc.cs.cpsc210.spaceinvaders.model.Tank.DX;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public void testGetX() {
		tank.getX();
		assertTrue(tank.getX() == XLOC);
	}

	@Test
    public void testIsFacingRight() {
	    tank.faceRight();
	    assertTrue(tank.direction == 1);
    }

    @Test
    public void testIsNotFacingRight() {
        tank.faceLeft();
        assertFalse(tank.direction == 1);
        assertTrue(tank.direction == -1);
    }

    @Test
    public void testMoveNotAtBoundary() {
        tank.faceRight();
        tank.move();
        assertEquals(XLOC + DX, tank.getX());

    }

    @Test
    public void testMoveAtBoundary0() {
        tank = new Tank(0);
        tank.faceLeft();
        tank.move();
        assertTrue(tank.getX() == 0);
        assertFalse(tank.getX() == -DX);
        tank.faceRight();
        tank.move();
        assertTrue(tank.getX() == DX);
    }

    @Test
    public void testMoveAtBoundaryWidth() {
        tank = new Tank(SIGame.WIDTH);
        tank.faceRight();
        tank.move();
        assertTrue(tank.getX() == SIGame.WIDTH);
        assertFalse(tank.getX() == SIGame.WIDTH + DX);
        tank.faceLeft();
        tank.move();
        assertTrue(tank.getX() == SIGame.WIDTH - DX);
    }
}
