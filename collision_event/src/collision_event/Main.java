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
	public void CreateImage(JLabel player) throws IOException {
		BufferedImage playerImage = ImageIO.read(new File("images/ball.png"));
		Image image = playerImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		player.setIcon(new ImageIcon(image));
	}
	
	public Main() throws IOException {
		setTitle("충돌 체크");
		JPanel board = new JPanel(null);
		JLabel player = new JLabel();
		CreateImage(player);
		
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
	}
	
	public static void main(String[] args) throws IOException {
		new Main();
	}
}
