import java.io.File;

public class Frog {
	public int x,y;
	public File sprite;
	private int Lives;
	
	public Frog(int xx, int yy, int l, File s) {
		x = xx;
		y = yy;
		Lives = l;
		sprite = s;
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
	
	public void move(int xx, int yy) {
		if(x + xx >= 0 && x + xx <= (Frogger.WIDTH - 64))
			x += xx;
		if(y + yy >= 0 && y + yy <= (Frogger.HEIGHT - 64))
			y += yy;
		
		System.out.println("(" + x + ", " + y + ")");
	}
	
	public void setSprite(File file) {
		sprite = file;
	}
}
