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
	
	Log(int x, int y, int h)
	{
		logX = x;
		logY = y;
		height = h;
		
	}
	
	public int getX()
	{
		return logX;
	}
	
	public int getHeight()
	{
		return height;
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
				logX = logX + 2;
			if(height == 2)
				logX = logX + 6;
			if(height == 3)
				logX = logX + 4;
		
	}
	
	
	
}
