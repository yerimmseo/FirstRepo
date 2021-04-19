package myobj.tong;

public class Barrel {

	private boolean[] forked;
	private int size;
	private int fireBtn;
	
	private boolean game_over;
	
	public Barrel(int size) {
		this.size = size;
		this.forked = new boolean[size];
		this.fireBtn = (int)(Math.random() * size);
		this.game_over = false;
	}
	
	public boolean checkGameOver() {
		return game_over;
	}
	
	public boolean fork(int slot) {
		if (forked[slot]) {
			System.out.println("이미 찔럿던 곳입니다. 다른 곳을 골라주세요.");
			return false;
		}
		
		if (slot == fireBtn) {
			game_over = true;
		}
		
		forked[slot] = true;
		return true;
		
	}
	
}
