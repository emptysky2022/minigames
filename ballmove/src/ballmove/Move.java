package ballmove;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class Move extends KeyAdapter implements Runnable{
	private JLabel player;
	private Rectangle r;
	private boolean PLAYER_LEFT = false;
	private boolean PLAYER_RIGHT = false;
	private boolean PLAYER_UP = false;
	private boolean PLAYER_DOWN = false;
	
	
	public JLabel getBall() {
		return player;
	}
	public void setBall(JLabel player) {
		this.player = player;
	}
	public Rectangle getR() {
		return r;
	}
	public void setR(Rectangle r) {
		this.r = r;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			PLAYER_LEFT = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			PLAYER_RIGHT = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			PLAYER_UP = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			PLAYER_DOWN = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			PLAYER_LEFT = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			PLAYER_RIGHT = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			PLAYER_UP = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			PLAYER_DOWN = false;
		}
	}
	@Override
	public void run() {
		while(true) {
			if(PLAYER_LEFT) 
				r.x -= 1;
			else if(PLAYER_RIGHT)
				r.x += 1;
			else if(PLAYER_UP)
				r.y -= 1;
			else if (PLAYER_DOWN) 
				r.y += 1;
			player.setBounds(r);
			try {
				Thread.sleep(1);
			}catch (Exception e) {
			}
		}
	}
}
