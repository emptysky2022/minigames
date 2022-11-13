package createBullet;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Random;

public class Bullet {
	private boolean BULLET_LEFT = false;
	private boolean BULLET_RIGHT = false;
	private boolean BULLET_UP = false;
	private boolean BULLET_DOWN = false;
	private int speed = 1;
	private Random random = new Random();
	private int boardX;
	private int boardY;
	
	
	public Bullet(Dimension size) {
		boardX = size.width;
		boardY = size.height;
		BULLET_LEFT = random.nextBoolean();
		BULLET_UP = random.nextBoolean();
		if(!BULLET_LEFT && !BULLET_UP) {
			BULLET_RIGHT = random.nextBoolean();
			if(!BULLET_RIGHT) BULLET_DOWN = true;
			else BULLET_DOWN = random.nextBoolean();
		}
		
	}
	
	public int[] bulletDirection() {
		int pos[] = new int[2];
		if(BULLET_LEFT)
			pos[0] = -speed;
		if(BULLET_RIGHT)
			pos[0] = speed;
		if(BULLET_UP)
			pos[1] = -speed;
		if(BULLET_DOWN)
			pos[1] = speed;
		return pos;
	}
	
	public Rectangle createPos() {
		int x, y;
		if(BULLET_RIGHT && (BULLET_DOWN || BULLET_UP)) {
			if(random.nextBoolean()) {
				x = -40;
				y = random.nextInt(boardY) -40;
			}
			else {
				x = random.nextInt(boardX) -40;
				y = -40;
			}
		}
		else if(BULLET_LEFT && (BULLET_DOWN || BULLET_UP)) {
			if(random.nextBoolean()) {
				x = boardX;
				y = random.nextInt(boardY);
			}
			else {
				x = random.nextInt(boardX);
				y = boardY;
			}
		}
		else {
			if(BULLET_LEFT) {
				x = boardX;
				y = random.nextInt(boardY);
			}else if(BULLET_RIGHT) {
				x = -40;
				y = random.nextInt(boardY) -40;
			}
			else if(BULLET_DOWN) {
				x = random.nextInt(boardX) -40;
				y = -40;
			}else {
				x = random.nextInt(boardX);
				y = boardY;
			}
		}
		
		return new Rectangle(x,y,40,40);
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
