package createBullet;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CreateBullet extends Bullet implements Runnable{
	private Bullet bullet;
	private JLabel label;
	private Rectangle pos;
	private int x;
	private int y;
	public CreateBullet(JLabel label) {
		this.label = label;
		pos = this.label.getBounds();
		bullet = new Bullet();
		int[] movement = bullet.bulletDirection();
		x = movement[0]; y = movement[1];
		System.out.println(x + " " + y);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				pos.x += x;
				pos.y += y;
				label.setBounds(pos);
				Thread.sleep(1);
			}
		}catch (Exception e) {
		}
	}
}
