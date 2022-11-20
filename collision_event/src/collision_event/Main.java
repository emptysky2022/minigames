package collision_event;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame{
	public void CreatePlayerImage(JLabel player) throws IOException {
		BufferedImage playerImage = ImageIO.read(new File("images/ball.png"));
		Image image = playerImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		player.setIcon(new ImageIcon(image));
	}
	
	public void CreateBulletImage(JLabel bullet) throws IOException {
		BufferedImage bulletImage = ImageIO.read(new File("images/bullet.png"));
		Image image = bulletImage.getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bullet.setIcon(new ImageIcon(image));
	}
	
	public Main() throws IOException {
		setTitle("충돌 체크");
		JPanel board = new JPanel(null);
		JLabel player = new JLabel();
		CreatePlayerImage(player);
		
		player.setBounds(250, 500, 40, 40);
		PlayerMove playerMove = new PlayerMove(player);
		board.add(player);
		
		addKeyListener(playerMove);
		add(board);
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Thread play = new Thread(playerMove);
		play.start();
		
		while(true) {
			JLabel bullet = new JLabel();
			CreateBulletImage(bullet);
			board.add(bullet);
			
			bullet.setBounds(250, 0, 10, 10);
			BulletMove bulletMove = new BulletMove(bullet);
			Thread bulletThread = new Thread(bulletMove);
			bulletThread.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main();
	}
}
