import java.awt.*;
import javax.sound.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Car {
	
	private int CarX;
	private int CarY;
	private int height;
	private int speed;
	private Boolean Left = true;
	
	Car(int x, int y, int h, int s, Boolean l)
	{
		CarX = x;
		CarY = y;
		height = h;
		speed = s;
		Left = l;
		
	}
	
	public int getX()
	{
		return CarX;
	}
	
	public void changeX(int x)
	{
		CarX = x;
	}
	
	public int getY()
	{
		return CarY;
	}
	
	public void changeY(int y)
	{
		CarY = y;
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
		CarX = 1000;
	}
	
	public void Returntoleft()
	{
		CarX = -200;
	}
	
	
	public void slide()
	{	
		
		if(CarX <= -150 && Left == true)
			Returntoright();
		if(CarX >= 900 && Left == false)
			Returntoleft();
		
		if(height == 1)
			CarX = CarX - speed;
		if(height == 2)
			CarX = CarX + speed;
		if(height == 3)
			CarX = CarX - speed;
		if(height == 4)
			CarX = CarX + speed;
		if(height == 5)
			CarX = CarX - speed;
		
	}
	
	public Boolean isColliding(int fX, int fY) {
		//System.out.println("Distance X: " + (fX - CarX) + ", Y: " + CarY + ", " + fY);
		
		int xPadding = 30;	
		int yPadding = 0; 	// remove if not needed
		
		if((fX - CarX + xPadding) > 0 && (fX - CarX + xPadding) <= 64 && CarY == fY)
			return true;
		
		return false;
	}
	
	public Boolean isColliding(int fX, int fY, int size) {
		//System.out.println("Distance X: " + (fX - CarX) + ", Y: " + CarY + ", " + fY);
		
		int xPadding = 30;	
		int yPadding = 0; 	// remove if not needed
		
		if((fX - CarX + xPadding) > 0 && (fX - CarX + xPadding) <= size && CarY == fY)
			return true;
		
		return false;
	}
	
}
