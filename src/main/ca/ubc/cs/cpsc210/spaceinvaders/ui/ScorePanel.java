package ca.ubc.cs.cpsc210.spaceinvaders.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;

/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class ScorePanel extends JPanel {
	private static final String INVADERS_TXT = "Invaders shot down: ";
	private static final String MISSILES_TXT = "Missiles remaining: ";
	private static final String HIGHSCORE_TXT = "High Score: ";
	private static final String LIVES_TXT = "Number of lives remaining: ";
	private static final int LBL_WIDTH = 200;
	private static final int LBL_HEIGHT = 30;
	private JLabel invadersLbl;
	private JLabel missilesLbl;
	private JLabel highScoreLbl;
	private JLabel livesLbl;
	public static int currentHighScore;

	// EFFECTS: sets the background colour and draws the initial labels;
	//          updates this with the game whose score is to be displayed
	public ScorePanel(SIGame g) {
		setBackground(new Color(180, 180, 180));
		invadersLbl = new JLabel(INVADERS_TXT + SIGame.getInstance().getNumInvadersDestroyed());
		invadersLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
		missilesLbl = new JLabel(MISSILES_TXT + SIGame.MAX_MISSILES);
		missilesLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
		highScoreLbl = new JLabel(MISSILES_TXT + SIGame.MAX_MISSILES);
		highScoreLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
		livesLbl = new JLabel(LIVES_TXT + SIGame.getInstance().getLives());
		add(Box.createHorizontalStrut(50));
		add(invadersLbl);
		add(missilesLbl);
		add(highScoreLbl);
		add(livesLbl);
		add(Box.createHorizontalStrut(50));
	}

	// MODIFIES: this
	// EFFECTS:  updates number of invaders shot and number of missiles
	//           remaining to reflect current state of game
	public void update() {
		invadersLbl.setText(INVADERS_TXT + SIGame.getInstance().getNumInvadersDestroyed());
		missilesLbl.setText(MISSILES_TXT + (SIGame.MAX_MISSILES - SIGame.getInstance().getNumMissiles()));
		if (SIGame.getInstance().getNumInvadersDestroyed() > currentHighScore) {
			currentHighScore = SIGame.getInstance().getNumInvadersDestroyed();
			highScoreLbl.setText(HIGHSCORE_TXT + SIGame.getInstance().getNumInvadersDestroyed());
		}
		else {
			highScoreLbl.setText(HIGHSCORE_TXT + currentHighScore);
		}
		livesLbl.setText(LIVES_TXT + SIGame.getInstance().getLives());
		repaint();

	}
}
