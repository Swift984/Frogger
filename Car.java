import java.awt.*;
import javax.sound.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Car {
	
	// 128, 64
	
	private int CarX;
	private int CarY;
	private int height;
	private Boolean Left = true;
	
	Car(int x, int y, int h, Boolean l)
	{
		CarX = x;
		CarY = y;
		height = h;
		Left = l;
		
	}
	
	public int getX()
	{
		return CarX;
	}
	
	public int getHeight()
	{
		return height;
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
			CarX = CarX - 5;
		if(height == 2)
			CarX = CarX + 3;
		if(height == 3)
			CarX = CarX - 3;
		if(height == 4)
			CarX = CarX + 15;
		if(height == 5)
			CarX = CarX - 2;
		
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
