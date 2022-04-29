import java.awt.*;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Frogger extends JFrame
{
	public static final int WIDTH = (224*4)+16;
	public static final int HEIGHT = (256*4)+39;
	
	public Frogger() throws IOException, FontFormatException
	{
		super("FROGGA");
		
		setSize(WIDTH,HEIGHT);
		setLocation(650,0);
		setIconImage(new ImageIcon("Frog.up.0.png").getImage());

		
		getContentPane().add(new Screen() );
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main( String args[] ) throws IOException, FontFormatException
	{
		Frogger run = new Frogger();
	}
}
