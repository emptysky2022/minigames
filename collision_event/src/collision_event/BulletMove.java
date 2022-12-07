package collision_event;

import java.awt.Container;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BulletMove extends Thread{
	private JLabel bullet;
	private Rectangle pos;
	private Container parent;
	public BulletMove(JLabel bullet) {
		this.bullet = bullet;
		pos = bullet.getBounds();
		parent = bullet.getParent();
	}
	@Override
	public void run() {
		try {
			while(true) {			
				if(fieldOut())
					destoryBullet();
				pos.y += 1;
				bullet.setBounds(pos);
				Thread.sleep(3);
			}
		}catch (InterruptedException e) {
		}
	}
	private void destoryBullet() {
		Thread.currentThread().interrupt();
		parent.remove(bullet);
		parent.repaint();
	}
	private boolean fieldOut() {
		if(pos.y > 600)
			return true;
		return false;
	}
}
