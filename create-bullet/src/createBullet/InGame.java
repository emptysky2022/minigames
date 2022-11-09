package createBullet;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InGame extends JFrame{
	public InGame() throws IOException {
		setTitle("create random bullet");
		BufferedImage resizeImage = ImageIO.read(new File("images/ball.png"));
		Image ballImage = resizeImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon ball = new ImageIcon(ballImage);
		//°ø È®·ü
		float frequency = 0.1f;
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);
		while(true) {
			if (Math.random() < frequency) {
				JLabel label = new JLabel();
				label.setIcon(ball);
				label.setBounds(250,200,40,40);
				panel.add(label);
				CreateBullet create = new CreateBullet(label);
				Thread thread = new Thread(create);
				System.out.println(thread.getName());
				thread.start();				
			}
			try {
				Thread.sleep(50);
			}catch (Exception e) {
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new InGame();
	}
}
