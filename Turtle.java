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
	
	Turtle(int x, int y, int h)
	{
		TurtX = x;
		TurtY = y;
		height = h;
		
	}
	
	public int getX()
	{
		return TurtX;
	}
	
	public int getHeight()
	{
		return height;
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
	
	public void Returntoright()
	{
		TurtX = 1000;
	}
	
	public void slide()
	{	
		
			if(TurtX <= 0)
				Returntoright();
			
			if(height == 1)
				TurtX = TurtX - 3;
			if(height == 2)
				TurtX = TurtX - 6;
			
	}
	
	
	
}
