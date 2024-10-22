package framework.graphical;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JPanel;

import framework.geometry.FrameworkVector;
import framework.graphical.sprite.Sprite;
import framework.graphical.sprite.SpriteSheet;
import framework.tools.IdFactory;

public class GraphicalEngine implements IGraphicalEngine {
	private final Vector<GraphicalObject> objects;
	private final JPanel panel;

	public GraphicalEngine(JPanel panel) {
		objects = new Vector<>();
		this.panel = panel;
	}

	public static GraphicalObject createObject(SpriteSheet spriteSheet) {
		Sprite sprite = new Sprite(spriteSheet);
		return new GraphicalObject(IdFactory.nextId(), sprite);
	}

	@Override
	public void addObject(GraphicalObject object) {
		objects.add(object);

	}

	@Override
	public void removeObject(GraphicalObject object) {
		objects.remove(object);
	}

	@Override
	public void update() {
		panel.repaint();
	}

	@Override
	public void draw(Graphics2D g) {
		for (int i = 0; i < objects.size(); i++) {
			GraphicalObject object = objects.get(i);
			if (!object.isVisible()) continue;

			try {
				//System.out.println("drawing " + i);
				FrameworkVector position = object.getPosition();
				BufferedImage image = object.getSprite().getImage();
				g.drawImage(image, position.getX(), position.getY(), null);
			} catch (Exception e) {
				System.err.println("can't draw " + object);
			}
		}
		g.dispose();
	}

}
