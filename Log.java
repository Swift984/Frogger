import java.awt.*;
import javax.sound.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Log {
	
	private int logX;
	private int logY;
	private int height;
	private int speed;
	
	Log(int x, int y, int h, int s)
	{
		logX = x;
		logY = y;
		height = h;
		speed = s;
	}
	
	public int getX()
	{
		return logX;
	}
	
	public void changeX(int x)
	{
		logX = x;
	}

	public int getY()
	{
		return logY;
	}
	
	public void changeY(int y)
	{
		logY = y;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void Returntoleft()
	{
		if(height == 1)
			logX = -192;
		if(height == 2)
			logX = -448;
		if(height == 3)
			logX = -256;
	}
	
	public void slide()
	{	
		
			if(logX >= 896)
				Returntoleft();
			
			if(height == 1)
				logX = logX + speed;
			if(height == 2)
				logX = logX + speed;
			if(height == 3)
				logX = logX + speed;
		
	}
	
	public Boolean isColliding(int fX, int fY, int size) {
		
		int xPadding = 32;
		
		if((fX - logX + xPadding) > 0 && (fX - logX + xPadding) <= size && logY == fY)
			return true;
		
		return false;
	}
	
}
