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
		if(x + xx >= 0 && x + xx <= (224*4 - 64))
			x += xx;
		if(y + yy >= 0 && y + yy <= (256*4 - 128))
		{
			if(yy < 0  && !checkPos(0, 0, 192) && !checkPos(64, 192, 192) && !checkPos(256, 384, 192) && !checkPos(448, 576, 192) && !checkPos(640, 768, 192) && !checkPos(832, 896, 196))
				y += yy;
			else if(yy > 0)
				y += yy;
		}
		
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
