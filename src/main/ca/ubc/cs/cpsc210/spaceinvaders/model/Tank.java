package ca.ubc.cs.cpsc210.spaceinvaders.model;

import java.awt.Color;

/**
 * Represents a tank
 */
public class Tank {

	public static final int SIZE_X = 15;
	public static final int SIZE_Y = 8;
	public static final int DX = 2;
	private int x;
	public static final int Y_POS = SIGame.HEIGHT - 40;
	public static final Color COLOR = new Color(250, 128, 20);
	public int direction;
	public boolean rightOrLeft;


	// EFFECTS: places tank at position (x, Y_POS) moving right.
	public Tank(int x) {
		this.x = x;
	}

	public int getX() {
		return x;  // stub
	}

	// EFFECTS: returns true if tank is facing right, false otherwise
	public boolean isFacingRight() {
		return rightOrLeft;
	}

	// MODIFIES: this
	// EFFECTS: tank is facing right
	public void faceRight() {
		direction  = 1;
		rightOrLeft = true;
	}

	// MODIFIES: this
	// EFFECTS: tank is facing left
	public void faceLeft() {
		direction = -1;
		rightOrLeft = false;
	}

	// MODIFIES: this
	// EFFECTS:  tank is moved DX units in whatever direction it is facing and is
	//           constrained to remain within horizontal bounds of game
	public void move() {
		x += DX * direction;
		handleBoundary();
	}

	// MODIFIES: this
	// EFFECTS: tank is constrained to remain within horizontal bounds of game
	private void handleBoundary() {
		if (x < 0) {
			x = 0;
		}
		if (x > SIGame.WIDTH) {
			x = SIGame.WIDTH;
		}
	}
}
