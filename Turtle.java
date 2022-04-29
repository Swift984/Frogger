import java.awt.*;
import javax.sound.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Turtle {
	
	private int TurtX;
	private int TurtY;
	private int height;
	private int speed;
	
	Turtle(int x, int y, int h, int s)
	{
		TurtX = x;
		TurtY = y;
		height = h;
		speed = s;
	}
	
	public int getX()
	{
		return TurtX;
	}
	
	public void changeX(int x)
	{
		TurtX = x;
	}
	
	public int getY()
	{
		return TurtY;
	}
	
	public void changeY(int y)
	{
		TurtY = y;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void Returntoright()
	{
		TurtX = 896;
	}
	
	public void slide()
	{	
		
			if(TurtX <= -192)
				Returntoright();
			
			if(height == 1)
				TurtX = TurtX - speed;
			if(height == 2)
				TurtX = TurtX - speed;
			
	}
	
	
	
}
