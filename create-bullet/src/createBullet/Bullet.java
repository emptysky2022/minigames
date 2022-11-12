package createBullet;

import java.util.Random;

public class Bullet {
	private boolean BULLET_LEFT = false;
	private boolean BULLET_RIGHT = false;
	private boolean BULLET_UP = false;
	private boolean BULLET_DOWN = false;
	private int speed = 1;
	private Random direction = new Random();
	
	
	public Bullet() {
		BULLET_LEFT = direction.nextBoolean();
		BULLET_UP = direction.nextBoolean();
		if(!BULLET_LEFT && !BULLET_UP) {
			BULLET_RIGHT = direction.nextBoolean();
			if(!BULLET_RIGHT) BULLET_DOWN = true;
			else BULLET_DOWN = direction.nextBoolean();
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
	
	public void createPos() {
			
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
