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
	
	public int getX()
	{
		return x;
	}
	
	public void changeX(int a)
	{
		x = a;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void changeY(int b)
	{
		y = b;
	}
	
	public void slide(int s)
	{
		x = x + s;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void move(int xx, int yy) {
		System.out.println(x + ", " + y );
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
	
	public void reset() {
		x = 448;
		y = 896;
	}
}
