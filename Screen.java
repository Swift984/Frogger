import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Screen extends JPanel  implements Runnable, KeyListener  {
	
	private File Screen;
	private File Log;
	private File Turt;
	private File FrogIMG;
	
	private int MouseX;
	private int MouseY;
	private int playerX, playerY;
	
	private int moveDistance = 50;
	
	private Boolean keyDown = false;
	private Boolean living = true;
	
	private Frog frog;
	
	private Log log;
	private Log log2;
	private Log log3;

	private Log mid;
	private Log mid2;
	private Log mid3;

	private Log top;
	private Log top2;
	private Log top3;
	
	private Turtle up;
	private Turtle up2;
	private Turtle up3;
	
	private Turtle down;
	private Turtle down2;
	private Turtle down3;

	
	public Screen()
	{
		setBackground(Color.WHITE);
		
		Screen = new File("screen.png");
		Log = new File("Log.png");
		Turt = new File("turt.png");
		FrogIMG = new File("placeholder.jpg");
		
		frog = new Frog(400, 857, 50, 50, FrogIMG);
		
		setFocusable( true );
		addKeyListener( this );
		new Thread(this).start();
		
		log = new Log(10, 350, 1);
		log2 = new Log(320,350,1);
		log3 = new Log(660,350,1);
		
		mid = new Log(10, 275, 2);
		mid2 = new Log(360, 275, 2);
		mid3 = new Log(710, 275, 2);

		top = new Log(10, 150, 3);
		top2 = new Log(320, 150, 3);
		top3 = new Log(660, 150, 3);
		
		up = new Turtle(900, 250,2);
		up2 = new Turtle(625, 250,2);
		up3 = new Turtle(300, 250,2);
		
		down = new Turtle(900, 450,1);
		down2 = new Turtle(625, 450,1);
		down3 = new Turtle(300, 450,1);
	}
	
	
	public void paint(Graphics window) 
	{
		window.clearRect( 0,0, 1280, 1280);
		try {
			window.drawImage(ImageIO.read(Screen), 0, 0, 896, 1024, null);
			
			
			window.drawImage(ImageIO.read(Log), log.getX(), log.getY(), 200, 150, null);
			window.drawImage(ImageIO.read(Log), log2.getX(), log2.getY(), 200, 150, null);
			window.drawImage(ImageIO.read(Log), log3.getX(), log3.getY(), 200, 150, null);
			
			window.drawImage(ImageIO.read(Log), mid.getX(), mid.getY(), 200, 150, null);
			window.drawImage(ImageIO.read(Log), mid2.getX(), mid2.getY(), 200, 150, null);
			window.drawImage(ImageIO.read(Log), mid3.getX(), mid3.getY(), 200, 150, null);
			
			window.drawImage(ImageIO.read(Log), top.getX(), top.getY(), 200, 150, null);
			window.drawImage(ImageIO.read(Log), top2.getX(), top2.getY(), 200, 150, null);
			window.drawImage(ImageIO.read(Log), top3.getX(), top3.getY(), 200, 150, null);
			
			window.drawImage(ImageIO.read(Turt), up.getX(), up.getY(), 200, 75, null);
			window.drawImage(ImageIO.read(Turt), up2.getX(), up2.getY(), 200, 75, null);
			window.drawImage(ImageIO.read(Turt), up3.getX(), up3.getY(), 200, 75, null);
			
			window.drawImage(ImageIO.read(Turt), down.getX(), down.getY(), 200, 75, null);
			window.drawImage(ImageIO.read(Turt), down2.getX(), down2.getY(), 200, 75, null);
			window.drawImage(ImageIO.read(Turt), down3.getX(), down3.getY(), 200, 75, null);
			
			window.drawImage(ImageIO.read(frog.sprite), frog.x, frog.y, frog.w, frog.h, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MouseX = MouseInfo.getPointerInfo().getLocation().x-getLocationOnScreen().x;
		MouseY = MouseInfo.getPointerInfo().getLocation().y-getLocationOnScreen().y;
		window.setFont( new Font("Arial", 0, 12) );

		window.drawString( MouseX + " ," + MouseY, 20, 30 );
		
		if(living = true)
		{
			log.slide();
			log2.slide();
			log3.slide();
			
			mid.slide();
			mid2.slide();
			mid3.slide();
			
			top.slide();
			top2.slide();
			top3.slide();
			
			up.slide();
			up2.slide();
			up3.slide();	
			
			down.slide();
			down2.slide();
			down3.slide();
		}
	}
	
	
	
	public void run()
	{
		try
		{
			while( true )

			{
			   Thread.sleep(34);
			   repaint();
			}
		}
		catch( Exception e )
		{
			
		}
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(keyDown);
		// TODO Auto-generated method stub
		if((e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) && keyDown == false) {
			frog.move(-moveDistance, 0);
			keyDown = true;
		}
		if((e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) && keyDown == false) {
			frog.move(moveDistance, 0);
			keyDown = true;
		}
		if((e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) && keyDown == false) {
			frog.move(0, moveDistance);
			keyDown = true;
		}
		if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP && keyDown == false)) {
			frog.move(0, -moveDistance);
			keyDown = true;
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_A)
			keyDown = false;
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
