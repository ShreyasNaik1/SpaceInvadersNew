package ca.ubc.cs.cpsc210.spaceinvaders.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import ca.ubc.cs.cpsc210.spaceinvaders.model.SIGame;

import static java.awt.Event.PAUSE;

/*
 * Represents the main window in which the space invaders
 * game is played
 */
@SuppressWarnings("serial")
public class SpaceInvaders extends JFrame {

	private static final int INTERVAL = 20;
	private GamePanel gp;
	private ScorePanel sp;


	// EFFECTS: sets up window in which Space Invaders game will be played
	public SpaceInvaders() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		gp = new GamePanel(SIGame.getInstance());
		sp = new ScorePanel(SIGame.getInstance());
		add(gp);
		add(sp, BorderLayout.NORTH);
		addKeyListener(new KeyHandler());
		pack();
		centreOnScreen();
		setVisible(true);
		addTimer();
	}

	// MODIFIES: none
	// EFFECTS:  initializes a timer that updates game each
    //           INTERVAL milliseconds
    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!SIGame.getInstance().isOver()) {
                	SIGame.getInstance().update();
                	sp.update();
                }
                gp.repaint();
            }
        });

        t.start();
	}

	// MODIFIES: this
	// EFFECTS:  location of frame is set so frame is centred on desktop
	private void centreOnScreen() {
		Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
	}
	
	/*
	 * A key handler to respond to key events
	 */
	private class KeyHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			SIGame.getInstance().keyPressed(e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			SIGame.getInstance().keyReleased(e.getKeyCode());
		}
}

	// Play the game
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}
