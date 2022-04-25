import java.io.File;

public class Frog {
	public int x,y,w,h;
	public File sprite;
	
	public Frog(int xx, int yy, int ww, int hh, File s) {
		x = xx;
		y = yy;
		w = ww;
		h = hh;
		sprite = s;
	}
	
	public void move(int xx, int yy) {
		if(x + xx >= 0 && x + xx <= (Frogger.WIDTH - w))
			x += xx;
		if(y + yy >= 0 && y + yy <= (Frogger.HEIGHT - h))
			y += yy;
		
		System.out.println("(" + x + ", " + y + ")");
	}
	
	public void setSprite(File file) {
		sprite = file;
	}
}