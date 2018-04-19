package ca.ubc.cs.cpsc210.spaceinvaders.test;


import ca.ubc.cs.cpsc210.spaceinvaders.model.Invader;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Missile;
import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cs.cpsc210.spaceinvaders.model.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Game class.
 */
public class GameTest {
	private SIGame game;
	
	@BeforeEach
	public void runBefore() {
		game = new SIGame();
	}
	
	@Test
	public void testConstructor() {
		Tank t = game.getTank();
		assertEquals(SIGame.WIDTH / 2, t.getX());
		List<Invader> invaders = game.getInvaders();
		assertEquals(0, invaders.size());
		List<Missile> missiles = game.getMissiles();
		assertEquals(0, missiles.size());
	}
	
	@Test
	public void testUpdate() {
		Tank t = game.getTank();
		assertEquals(SIGame.WIDTH / 2, t.getX());
        game.keyPressed(KeyEvent.VK_RIGHT);
		game.update();
		assertEquals(SIGame.WIDTH / 2 + Tank.DX, t.getX());
        game.keyPressed(KeyEvent.VK_RIGHT);
		game.update();
		assertEquals(SIGame.WIDTH / 2 + 2 * Tank.DX, t.getX());
		assertEquals(0, game.getMissiles().size());
	}
	
	@Test
	public void testNonKeyPadKeyEvent() {
		Tank t = game.getTank();
		game.keyPressed(KeyEvent.VK_LEFT);
		game.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		game.update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		game.keyPressed(KeyEvent.VK_RIGHT);
		game.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		game.update();
		assertEquals(SIGame.WIDTH / 2, t.getX());		
	}
	
	@Test
	public void testKeyPadKeyEvent() {
		Tank t = game.getTank();
		game.keyPressed(KeyEvent.VK_KP_LEFT);
		game.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		game.update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		game.keyPressed(KeyEvent.VK_KP_RIGHT);
		game.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		game.update();
		assertEquals(SIGame.WIDTH / 2, t.getX());		
	}
	
	@Test
	public void testSpaceKeyEvent() {
		game.keyPressed(KeyEvent.VK_SPACE);
		assertEquals(1, game.getMissiles().size());
		game.keyPressed(KeyEvent.VK_SPACE);
		game.keyPressed(KeyEvent.VK_SPACE);
		assertEquals(3, game.getMissiles().size());
	}
}
