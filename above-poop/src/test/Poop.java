package test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Poop extends JLabel implements Moveable{
	private GameBoard mGame;
	private Player player;
	
	private int x;
	private int y;
	private int speed;
	
	private int state;
	
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
		player = mGame.getPlayer();
	}
	
	private void initSetting() {
		x = (int)(Math.random() * 950);
		y = -5;
		speed = (int)(Math.random() * 2 + 1);
		
		setIcon(poop);
		setLocation(x, y);
		setSize(30, 30);
		mGame.add(this);
	}

	@Override
	public void down() {
		new Thread(() -> {
			while(y < FLOOR) {
				if(Math.abs(player.getX() - x) < 10 && player.getY() - y < 30) {
					mGame.gameOver();
					break;
				}
				y += speed;
				setLocation(x, y);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			mGame.remove(this);
			mGame.repaint();
		}).start();
	}

}
