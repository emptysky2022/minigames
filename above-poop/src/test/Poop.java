package test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Poop extends JLabel implements Moveable{
	private GameBoard mGame;
	
	private int x;
	private int y;
	
	private int state;
	
	private static final int SPEED = 5;
	private static final int FLOOR = 775;
	
	private ImageIcon poop;
	
	public Poop(GameBoard mGame) {
		this.mGame = mGame;
		initObject();
		initSetting();
		down();
	}

	private void initObject() {
		poop = new ImageIcon("./images/poop.png");
	}
	
	private void initSetting() {
		x = (int)(Math.random() * 950);
		y = -5;
		
		setIcon(poop);
		setLocation(x, y);
		setSize(30, 30);
	}

	@Override
	public void down() {
		new Thread(() -> {
			while(y < FLOOR) {
				y += SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			mGame.remove(this);
			mGame.repaint();
		}).start();
	}

}
