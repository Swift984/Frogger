import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen extends JPanel implements Runnable , KeyListener
{
	private File Screen;
	private File Log0;
	private File Log1;
	private File Log2;
	private File Turtle0;
	private File Turtle1;
	private File FrogIMG;
	private File Car4;
	private File Car3;
	private File Car2;
	private File Car1;
	private File Car0;
	
	private int MouseX;
	private int MouseY;
	private int playerX, playerY;
	private int score = 0;
	
	private int moveDistance = 64;
	
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
	
	private Car car1;
	private Car car2;
	private Car car3;
	private Car car4;
	
	private Car car5;
	private Car car6;
	private Car car7;
	private Car car8;
	
	private Car tractor1;
	private Car tractor2;
	private Car tractor3;
	private Car tractor4;
	
	private Car racecar1;
	private Car racecar2;
	private Car racecar3;
	private Car racecar4;
	
	private Car truck1;
	private Car truck2;
	private Car truck3;
	private Car truck4;
	
	private File PressStart2P;
	private Font BaseFont;
	private Font ArcadeFont;
	
	public Screen() throws FontFormatException, IOException
	{
		setBackground(Color.WHITE);
		
		PressStart2P = new File("PressStart2P.ttf");
		BaseFont = Font.createFont( Font.TRUETYPE_FONT, PressStart2P);
		ArcadeFont = BaseFont.deriveFont(0, 32);
		
		Screen = new File("screen.png");
		Log0 = new File("Log.0.png");
		Log1 = new File("Log.1.png");
		Log2 = new File("Log.2.png");
		Turtle0 = new File("Turtle.0.0.png");
		Turtle1 = new File("Turtle.1.0.png");
		FrogIMG = new File("Frog.up.0.png");
		
		Car4 = new File("Car.4.png");
		Car3 = new File("Car.3.png");
		Car2 = new File("Car.2.png");
		Car1 = new File("Car.1.png");
		Car0 = new File("Car.0.png");
		
		frog = new Frog(448, 896, 64, 64, FrogIMG);
		
		addKeyListener( this );
		setFocusable( true );
		new Thread(this).start();
		
		log = new Log(0, 384, 1);
		log2 = new Log(384,384,1);
		log3 = new Log(768,384,1);
		
		mid = new Log(0, 320, 2);
		mid2 = new Log(448, 320, 2);	// im so fucking tired i can't comprehend this shit anymore
		mid3 = new Log(960, 320, 2);
		
		top = new Log(0, 192, 3);
		top2 = new Log(384, 192, 3);
		top3 = new Log(768, 192, 3);
		
		up = new Turtle(900, 256,2);
		up2 = new Turtle(625, 256,2);
		up3 = new Turtle(300, 256,2);
		
		down = new Turtle(900, 448,1);
		down2 = new Turtle(625, 448,1);
		down3 = new Turtle(300, 448,1);
		
		car1 = new Car(800, 825, 1, true);
		car2 = new Car(500, 825, 1, true);
		car3 = new Car(250, 825, 1, true);
		car4 = new Car(0, 825, 1, true);
		
		tractor1 = new Car(800, 760, 2, false);
		tractor2 = new Car(500, 760, 2, false);
		tractor3 = new Car(250, 760, 2, false);
		tractor4 = new Car(0, 760, 2, false);
		
		car5 = new Car(800, 700, 3, true);
		car6 = new Car(500, 700, 3, true);
		car7 = new Car(250, 700, 3, true);
		car8 = new Car(0, 700, 3, true);
		
		racecar1 = new Car(800, 640, 4, false);
		racecar2 = new Car(500, 640, 4, false);
		racecar3 = new Car(250, 640, 4, false);
		racecar4 = new Car(0, 640, 4, false);
		
		truck1 = new Car(800, 580, 5, true);
		truck2 = new Car(500, 580, 5, true);
		truck3 = new Car(250, 580, 5, true);
		truck4 = new Car(0, 580, 5, true);
	}
	
	public void paint( Graphics window )
	{
		window.clearRect( 0,0, WIDTH, HEIGHT);
		try {
			window.drawImage(ImageIO.read(Screen), 0, 0, 224*4, 256*4, null);
			
			
			window.drawImage(ImageIO.read(Log0), log.getX(), log.getY(), 192, 64, null);
			window.drawImage(ImageIO.read(Log0), log2.getX(), log2.getY(), 192, 64, null);
			window.drawImage(ImageIO.read(Log0), log3.getX(), log3.getY(), 192, 64, null);
			
			window.drawImage(ImageIO.read(Log1), mid.getX(), mid.getY(), 384, 64, null);
			window.drawImage(ImageIO.read(Log1), mid2.getX(), mid2.getY(), 384, 64, null);
			window.drawImage(ImageIO.read(Log1), mid3.getX(), mid3.getY(), 384, 64, null);
			
			window.drawImage(ImageIO.read(Log2), top.getX(), top.getY(), 256, 64, null);
			window.drawImage(ImageIO.read(Log2), top2.getX(), top2.getY(), 256, 64, null);
			window.drawImage(ImageIO.read(Log2), top3.getX(), top3.getY(), 256, 64, null);
			
			window.drawImage(ImageIO.read(Turtle0), up.getX(), up.getY(), 128, 64, null);
			window.drawImage(ImageIO.read(Turtle0), up2.getX(), up2.getY(), 128, 64, null);
			window.drawImage(ImageIO.read(Turtle0), up3.getX(), up3.getY(), 128, 64, null);
			
			window.drawImage(ImageIO.read(Turtle1), down.getX(), down.getY(), 192, 64, null);
			window.drawImage(ImageIO.read(Turtle1), down2.getX(), down2.getY(), 192, 64, null);
			window.drawImage(ImageIO.read(Turtle1), down3.getX(), down3.getY(), 192, 64, null);
			
			window.drawImage(ImageIO.read(Car4), truck1.getX(), truck1.getY(), 128, 64, null);
			window.drawImage(ImageIO.read(Car4), truck2.getX(), truck2.getY(), 128, 64, null);
			window.drawImage(ImageIO.read(Car4), truck3.getX(), truck3.getY(), 128, 64, null);
			window.drawImage(ImageIO.read(Car4), truck4.getX(), truck4.getY(), 128, 64, null);
			
			window.drawImage(ImageIO.read(Car3), racecar1.getX(), racecar1.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car3), racecar2.getX(), racecar2.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car3), racecar3.getX(), racecar3.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car3), racecar4.getX(), racecar4.getY(), 64, 64, null);
			
			window.drawImage(ImageIO.read(Car2), car5.getX(), car5.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car2), car6.getX(), car6.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car2), car7.getX(), car7.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car2), car8.getX(), car8.getY(), 64, 64, null);
			
			window.drawImage(ImageIO.read(Car1), tractor1.getX(),  tractor1.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car1), tractor2.getX(),  tractor2.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car1), tractor3.getX(),  tractor3.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car1), tractor4.getX(),  tractor4.getY(), 64, 64, null);
			
			window.drawImage(ImageIO.read(Car0), car1.getX(), car1.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car0), car2.getX(), car2.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car0), car3.getX(), car3.getY(), 64, 64, null);
			window.drawImage(ImageIO.read(Car0), car4.getX(), car4.getY(), 64, 64, null);
			
			window.drawImage(ImageIO.read(FrogIMG), frog.getX(), frog.getY(), 64, 64, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		window.setFont(ArcadeFont);
		window.setColor(Color.WHITE);
		window.drawString("    1-UP  HI-SCORE          ", 0, 32 );
		window.setColor(Color.RED);
		window.drawString("   00000   00000            ", 0, 64 );
		
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
			
			car1.slide();
			car2.slide();
			car3.slide();
			car4.slide();
			
			tractor1.slide();
			tractor2.slide();
			tractor3.slide();
			tractor4.slide();
			
			car5.slide();
			car6.slide();
			car7.slide();
			car8.slide();
			
			racecar1.slide();
			racecar2.slide();
			racecar3.slide();
			racecar4.slide();
			
			truck1.slide();
			truck2.slide();
			truck3.slide();
			truck4.slide();
		}
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(keyDown);
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
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_A)
			keyDown = false;
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
	
}
