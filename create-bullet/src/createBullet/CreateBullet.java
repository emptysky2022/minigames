package createBullet;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CreateBullet implements Runnable{
	private Bullet bulletMove;
	private JLabel bullet;
	private Rectangle pos;
	Container parent;
	Dimension size;
	private int x;
	private int y;
	public CreateBullet(JLabel label) {
		bullet = label;
		parent = label.getParent();
		size = parent.getSize();
		bulletMove = new Bullet(size);
		pos = bulletMove.createPos();
		int[] movement = bulletMove.bulletDirection();
		x = movement[0]; y = movement[1];
		System.out.println(x + " " + y);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				pos.x += x;
				pos.y += y;
				bullet.setBounds(pos);
				destoryBullet();
				Thread.sleep(1);
			}
		}catch (Exception e) {
		}
	}
	public void destoryBullet() {
		if(pos.x < -60 || pos.y < -60 || pos.x > size.width || pos.y > size.height) {
			System.out.println(Thread.currentThread().getName() + "bullet deleted");
			Thread.currentThread().interrupt();
			parent.remove(bullet);
		}
	}
}
