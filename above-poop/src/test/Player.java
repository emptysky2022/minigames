package test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable{
	private GameBoard mGame;

	private int x;
	private int y;

	private boolean left;
	private boolean right;
	
	
	private static final int SPEED = 3;
	
	private ImageIcon player;
	
	public Player(GameBoard mGame) {
		this.mGame = mGame;
		initObject();
		initSetting();
	}
	
	private void initObject() {
		player = new ImageIcon("./images/player.png");
	}
	
	private void initSetting() {
		x = 450;
		y = 750;
		
		left = false;
		right = false;
		
		setIcon(player);
		setLocation(x, y);
		setSize(50, 50);
	}

	@Override
	public void left() {
		left = true;
		new Thread(() -> {
			while(isLeft()) {
				x -= SPEED;
				setLocation(x,y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}).start();
	}

	@Override
	public void right() {
		right = true;
		new Thread(() -> {
			while(isRight()) {
				x += SPEED;
				setLocation(x,y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}).start();
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	
	
}
