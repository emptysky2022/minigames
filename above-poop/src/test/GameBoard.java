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
	
	private CreatePoop createPoops;
	
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
		createPoops = new CreatePoop(mGame, poops);
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
				case KeyEvent.VK_R : 
					if(player.isState()) {
						restart();
					}
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
	
	public Player getPlayer() {
		return player;
	}
	
	public void gameOver() {
		createPoops.setState(true);
		player.setState(true);
//		mainPanel.setVisible(false);
	}
	
	public void restart() {
		createPoops.setState(false);
		createPoops = new CreatePoop(mGame, poops);
		player.setState(false);
//		mainPanel.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameBoard();
	}
}
