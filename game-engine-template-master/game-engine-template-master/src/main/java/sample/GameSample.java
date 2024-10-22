package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import framework.input.KeyHandler;

public class GameSample extends JPanel implements Runnable, ActionListener {
	//SCREEN SETTINGS
	final int originalTilteSize = 16; //16x16 tiles
	final int scale = 3;

	final int titleSize = originalTilteSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 14;
//48x 3x16
	final int screenWidth = titleSize * maxScreenCol;
	final int screenHeight = titleSize * maxScreenRow;

	final int FPS = 60;

	private boolean play;
	private Timer time;
	private int delay = 8;
	KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;

	//SET PLAYER DEFAULT POSITION
	int ballPosX = 0;
	int ballPosY = 0;
	int ballXdir = -1;
	int ballYdir = -2;
	int speed = 20;

	int playerX = 300;

	public GameSample() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
		this.requestFocus();
		time = new Timer(8, this);
		time.start();
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	//	@Override
	//	public void run() {
	//		double drawInterval = 1_000_000_000/FPS;
	//		double nextImage = System.nanoTime() + drawInterval;
	//
	//		while(true) {
	//			update();
	//
	//			repaint();
	//
	//			try {
	//				double remainingTime = (nextImage - System.nanoTime())/1_000_000;
	//				System.out.println(remainingTime);
	//
	//				if(remainingTime < 0) remainingTime = 0;
	//
	//				Thread.sleep((long) remainingTime);
	//
	//				nextImage += drawInterval;
	//
	//			} catch (InterruptedException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		}
	//	}

	@Override
	public void run() {
		double drawInterval = 1_000_000_000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;

			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}

	public void update() {

		if(keyHandler.rightPressed)
			if (playerX >=620){
				playerX = 620;
			} else {
				play = true;
				playerX += speed;
			}
		if(keyHandler.leftPressed)
			if (playerX <= 0){
				playerX = 0;
			} else {
				play = true;
				playerX -= speed;
			}
	}

	@Override
	public void actionPerformed(ActionEvent e){
		time.start();
		if (play){
			if (new Rectangle(ballPosX, ballPosY, 20,20).intersects(new Rectangle(playerX,screenHeight-20, 150,10 ))){
				ballYdir = - ballYdir;
			}
			ballPosX += ballXdir;
			ballPosY += ballYdir;
			if (ballPosX < 0){
				ballXdir = -ballXdir;
			}
			if(ballPosY < 0){
				ballYdir = -ballYdir;
			}
			if (ballPosX > 650){
				ballXdir = -ballXdir;
			}

		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("C:\\MASTER 1\\GL\\game-engine-template\\src\\assets\\Character\\ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2.setColor(Color.white);

		//g2.fillRect(x, y, titleSize, titleSize);

		//g2.drawImage(image, ballPosX, ballPosY, null);

		// the border
		g2.setColor(Color.GREEN);
		g2.fillRect(0, 0, 3, screenHeight);
		g2.fillRect(0, 0, screenWidth, 3);
		g2.fillRect(screenWidth-3, 0, 3, screenHeight);

		//the paddle
		g2.setColor(Color.BLUE);
		g2.fillRect(playerX, screenHeight-20, 150,10);

		//the bakk
		g2.setColor(Color.RED);
		g2.fillOval(ballPosX, ballPosY, 20, 20);

		g2.dispose();
	}
}
