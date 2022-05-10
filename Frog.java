import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Timer;

public class Frog {
	public int x,y;
	public File sprite;
	private int lives;
	private Timer DeathAnimation;
	private int Aframe = 0;
	
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
		Screen.godMode = true;
		Screen.TIME.stop();
		
		Aframe = 0;
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//...Perform a task...
				if(Aframe < 7)
				{
					sprite = new File("sprite\\Death." + Aframe + ".png");
					Aframe = Aframe+1;
				}
				else
				{
					Aframe = 0;
					sprite = new File("sprite\\Frog.up.0.png");
					DeathAnimation.stop();
					
					x = 448;
					y = 896;
					Screen.godMode = false;
					Screen.halfSeconds = 60;
					Screen.TIME.start();
				}
			}
		};
		DeathAnimation = new Timer(200, taskPerformer);
		DeathAnimation.start();
		
	}
	
	public void reset() {
		x = 448;
		y = 896;
		Screen.halfSeconds = 60;
	}
	
	public Boolean checkPos(int mX, int x, int y) {
		return (this.x >= mX && this.x <= x) && (this.y == y);
	}
}
