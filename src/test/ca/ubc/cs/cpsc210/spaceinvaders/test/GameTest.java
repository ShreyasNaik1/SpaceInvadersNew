package ca.ubc.cs.cpsc210.spaceinvaders.test;


import ca.ubc.cs.cpsc210.spaceinvaders.model.Invader;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Missile;
import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Tank;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Game class.
 */
public class GameTest {

	@Test
	public void testConstructor() {
		Tank t = SIGame.getInstance().getTank();
		assertEquals(SIGame.WIDTH / 2, t.getX());
		List<Invader> invaders = SIGame.getInstance().getInvaders();
		assertEquals(0, invaders.size());
		List<Missile> missiles = SIGame.getInstance().getMissiles();
		assertEquals(0, missiles.size());
	}
	
	@Test
	public void testUpdate() {
		Tank t = SIGame.getInstance().getTank();
		assertEquals(SIGame.WIDTH / 2, t.getX());
		SIGame.getInstance().keyPressed(KeyEvent.VK_RIGHT);
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 + Tank.DX, t.getX());
        SIGame.getInstance().keyPressed(KeyEvent.VK_RIGHT);
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 + 2 * Tank.DX, t.getX());
		assertEquals(0, SIGame.getInstance().getMissiles().size());
	}
	
	@Test
	public void testNonKeyPadKeyEvent() {
		Tank t = SIGame.getInstance().getTank();
		SIGame.getInstance().keyPressed(KeyEvent.VK_LEFT);
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		SIGame.getInstance().keyPressed(KeyEvent.VK_RIGHT);
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2, t.getX());		
	}
	
	@Test
	public void testKeyPadKeyEvent() {
		Tank t = SIGame.getInstance().getTank();
		SIGame.getInstance().keyPressed(KeyEvent.VK_KP_LEFT);
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		SIGame.getInstance().keyPressed(KeyEvent.VK_KP_RIGHT);
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		SIGame.getInstance().update();
		assertEquals(SIGame.WIDTH / 2, t.getX());		
	}
	
	@Test
	public void testSpaceKeyEvent() {
		SIGame.getInstance().keyPressed(KeyEvent.VK_SPACE);
		assertEquals(1, SIGame.getInstance().getMissiles().size());
		SIGame.getInstance().keyPressed(KeyEvent.VK_SPACE);
		SIGame.getInstance().keyPressed(KeyEvent.VK_SPACE);
		assertEquals(3, SIGame.getInstance().getMissiles().size());
	}
}
