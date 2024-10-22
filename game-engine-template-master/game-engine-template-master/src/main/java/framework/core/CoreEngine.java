package framework.core;

import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.JPanel;

import framework.graphical.GraphicalEngine;
import framework.graphical.GraphicalObject;
import framework.graphical.IGraphicalEngine;
import framework.input.ISource;
import framework.input.I_InputEngine;
import framework.input.InputEngine;
import framework.physical.IPhysicalEngine;
import framework.physical.PhysicalEngine;
import framework.physical.PhysicalObject;
import framework.tools.IGameEngine;
import framework.tools.IdFactory;

public class CoreEngine implements Runnable{
	final int TICKS = 50;
	final int FPS = 60;

	private final IPhysicalEngine physicalEngine;
	private final IGraphicalEngine graphicalEngine;
	private final I_InputEngine inputEngine;
	//private final KeyHandler keyHandler;
	private final IGameEngine gameEngine;

	private Vector<GameObject> gameObjects;

	public CoreEngine(JPanel panel, IGameEngine gameEngine) {
		this.physicalEngine = new PhysicalEngine();
		this.graphicalEngine = new GraphicalEngine(panel);
		this.inputEngine = new InputEngine();
		this.gameEngine = gameEngine;
		this.gameObjects = new Vector<>();
	}

	public GameObject createGameObject(PhysicalObject physicalObject, GraphicalObject graphicalObject) {
		return new GameObject(physicalObject, graphicalObject, IdFactory.nextId());
	}

	public void addGameObject(PhysicalObject physicalObject, GraphicalObject graphicalObject) {
		GameObject gameObject = new GameObject(physicalObject, graphicalObject, IdFactory.nextId());

		addGameObject(gameObject);
	}

	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
		if (gameObject.getPhysicalObject() != null)
			physicalEngine.addObject(gameObject.getPhysicalObject());

		if (gameObject.getGraphicalObject() != null)
			graphicalEngine.addObject(gameObject.getGraphicalObject());
	}

	public void removeGameObject(GameObject gameObject) {
		if (gameObject.getPhysicalObject() != null)
			physicalEngine.removeObject(gameObject.getPhysicalObject());

		if (gameObject.getGraphicalObject() != null)
			graphicalEngine.removeObject(gameObject.getGraphicalObject());

		gameObjects.remove(gameObject);
	}

	public void clear() {
		for(GameObject gameObject : gameObjects)
			removeGameObject(gameObject);
	}

	public void update() {
		for(GameObject gameObject : gameObjects) {
			if (gameObject.getPhysicalObject() == null || gameObject.getGraphicalObject() == null) continue;

			PhysicalObject physicalObject = gameObject.getPhysicalObject();

			gameObject.getGraphicalObject().setPosition(physicalObject.getX(), physicalObject.getY());
		}
	}

	@Override
	public void run() {
		Thread rendering = new Thread(() -> {
			long start, elapsed ;
			while(true) {
				start = System.currentTimeMillis();
				graphicalEngine.update();
				elapsed = System.currentTimeMillis() - start;

				try {
					Thread.sleep(Math.max(0, 1000/ FPS - elapsed));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread others = new Thread(() -> {
			int tick;
			long start, elapsed ;
			while(true) {
				tick = 0;
				start = System.currentTimeMillis();
				while(tick < TICKS) {
					tick++;
					inputEngine.update();
					physicalEngine.update();
					update();
					gameEngine.update();
				}
				elapsed = System.currentTimeMillis() - start;

				try {
					Thread.sleep(Math.max(0, 10 - elapsed));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		rendering.start();
		others.start();
	}

	public void renderDraw(Graphics2D g) {
		graphicalEngine.draw(g);
	}

	public ISource addInputSource(ISource source) {
		return inputEngine.addSource(source);
	}

}
