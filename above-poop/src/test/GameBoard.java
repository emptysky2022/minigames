package test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JFrame{
	private GameBoard mGame = this;
	private JPanel mainPanel;
	private JLabel background;
	private Player player;
	private List<Poop> poops;
	
	public GameBoard() {
		initObject();
		initSetting();
		initListener();
	}
	
	private void initObject() {
		mainPanel = new JPanel();
		background = new JLabel();
		background.setIcon(new ImageIcon("./images/background.png"));
		background.setSize(1000, 820);
		mainPanel.setSize(1000, 840);
		player = new Player(mGame);
		poops = new ArrayList<>();
		poops.add(new Poop(mGame));
	}
	
	private void initSetting() {
		setTitle("�����ϱ� ����");
		setSize(1000, 840);
		setLayout(null);
		mainPanel.setLayout(null);
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		mainPanel.add(background);
		mainPanel.add(player);
		poops.forEach(e -> mainPanel.add(e));
	}
	
	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT :
					if(!player.isLeft()) {
						player.left();						
					} break;
				case KeyEvent.VK_RIGHT :
					if(!player.isRight()) {
						player.right();
					} break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT :
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT :
					player.setRight(false);
					break;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new GameBoard();
	}
}
