package framework.graphical;

import java.awt.Graphics2D;

public interface IGraphicalEngine {
	public void addObject(GraphicalObject obj);

	public void removeObject(GraphicalObject obj);

	public void update();

	public void draw(Graphics2D g);
}
