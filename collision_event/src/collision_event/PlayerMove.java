package collision_event;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlayerMove extends KeyAdapter implements Runnable{
	private JLabel player;
	private Rectangle pos;
	private boolean PLAYER_LEFT = false;
	private boolean PLAYER_RIGHT = false;
	
	public PlayerMove(JLabel player) {
		this.player = player;
		pos = player.getBounds();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			PLAYER_LEFT = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			PLAYER_RIGHT = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			PLAYER_LEFT = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			PLAYER_RIGHT = false;
	}

	@Override
	public void run() {
		while(true) {
			if(fieldOut())
				continue;
			if(PLAYER_LEFT) 
				pos.x -= 1;
			if(PLAYER_RIGHT)
				pos.x += 1;
			player.setBounds(pos);
			try {
				Thread.sleep(1);
			}catch (Exception e) {
			}
		}
		
	}

	private boolean fieldOut() {
		if(pos.x < 0) {
			pos.x += 1;
			return true;
		}
		else if(pos.x > 550) {
			pos.x -= 1;
			return true;
		}
		return false;
	}
}
