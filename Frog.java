import java.io.File;

public class Frog {
	public int x,y;
	public File sprite;
	
	private int lives;
	
	public Frog(int xx, int yy, int l, File s) {
		x = xx;
		y = yy;
		sprite = s;
		lives = l;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void move(int xx, int yy) {
		if(x + xx >= 0 && x + xx <= (Frogger.WIDTH - 64))
			x += xx;
		if(y + yy >= 0 && y + yy <= (Frogger.HEIGHT - 64))
			y += yy;
	}
	
	public void setSprite(File file) {
		sprite = file;
	}
	
	public void die() {
		lives--;
		System.out.println(lives);
		x = 448;
		y = 896;
	}
}
