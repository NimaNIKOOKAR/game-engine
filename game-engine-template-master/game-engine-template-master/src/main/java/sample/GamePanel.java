package sample;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import framework.core.CoreEngine;
import framework.graphical.GraphicalObject;
import framework.graphical.sprite.Sprite;
import framework.physical.PhysicalObject;
import framework.tools.IdFactory;

public class GamePanel extends JPanel{
	//SCREEN SETTINGS
	final int originalTilteSize = 16; //16x16 tiles
	final int scale = 3;

	final int titleSize = originalTilteSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 14;

	final int screenWidth = titleSize * maxScreenCol;
	final int screenHeight = titleSize * maxScreenRow;

	CoreEngine core = new CoreEngine(this);

	Thread coreThread = new Thread(core);

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(core.getKeyHandler());
		this.setFocusable(true);
		this.requestFocus();

		core.createCharacter(new PhysicalObject(IdFactory.nextId()),
				new GraphicalObject(IdFactory.nextId(),new Sprite("C:\\Users\\Dang Dinh NGUYEN\\Documents\\M1-INFO\\S7\\GL\\game-engine-template\\src\\assets\\Character\\New Piskel.png",0,0,titleSize,titleSize)));
	}

	public void startGamePanel() {
		coreThread.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Engine
		core.renderDraw((Graphics2D) g);
	}

}
