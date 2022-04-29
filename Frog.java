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
		if(x + xx >= 0 && x + xx <= (Frogger.WIDTH - 64))
			x += xx;
		if(y + yy >= 0 && y + yy <= (Frogger.HEIGHT - 64) && !checkPos(0, 24, 192) && !checkPos(50, 216, 192) && !checkPos(484, 600, 192) && !checkPos(74*4, 101*4, 192) && !checkPos(169*4, 197*4, 192) && !checkPos(217*4, 223*4, 196))
			y += yy;
		
		System.out.println(x + ", " + y);
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
	
	public Boolean checkPos(int mX, int x, int y) {
		return (this.x >= mX && this.x <= x) && (this.y == y);
	}
}
