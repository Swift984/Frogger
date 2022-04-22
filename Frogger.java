import java.awt.*;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Frogger extends JFrame
{
	public static final int WIDTH = 467*2;//224*4;
	public static final int HEIGHT = 652*2;//256*4;
	
	public Frogger() throws IOException
	{
		super("FROGGER");
		
		setSize(WIDTH,HEIGHT);
		setLocation(650,0);
		
		getContentPane().add(new Screen() );
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void main( String args[] ) throws IOException
	{
		Frogger run = new Frogger();
	}
}
