package test;

import java.util.List;

public class CreatePoop {
	private GameBoard mGame;
	private List<Poop> poops;
	
	private boolean state;
	
	public CreatePoop(GameBoard mGame, List<Poop> poops) {
		this.mGame = mGame;
		this.poops = poops;
		state = false;
		createPoop();
	}
	
	private void createPoop() {
		new Thread(() -> {
			while(!isState()) {
				if(Math.random() < 0.2) continue;
				poops.add(new Poop(mGame));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
}
