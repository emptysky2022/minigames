package ballmove;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Print extends JFrame {
	JLabel player = new JLabel();
	Print() throws IOException {
		Move playerMove = new Move();
		BufferedImage resizeImage = ImageIO.read(new File("images/ball.png"));
		Image ballImage = resizeImage.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon ball = new ImageIcon(ballImage);
		setTitle("공 움직이기");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		player.setIcon(ball);
		player.setBounds(500,500,80,80);
		playerMove.setBall(player);
		playerMove.setR(player.getBounds());
		
		panel.add(player);
		add(panel);
		
		addKeyListener(playerMove);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,1000);
		setVisible(true);
		Thread play = new Thread(playerMove);
		play.start();
	}
	
	public static void main(String[] args) throws IOException {
		new Print();
		
	}
}