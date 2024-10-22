package framework.geometry.collisions;

import framework.geometry.FrameworkRectangle;
import framework.geometry.FrameworkShape;

public class RectangleRectangleCollisionStrategy implements ICollisionStrategy {

	@Override
	public boolean intersect(FrameworkShape shape1, FrameworkShape shape2) {
		if (shape1 instanceof FrameworkRectangle && shape2 instanceof FrameworkRectangle) {
			FrameworkRectangle rect1 = (FrameworkRectangle) shape1;
			FrameworkRectangle rect2 = (FrameworkRectangle) shape2;

			return rect1.getX() + rect1.getWidth() > rect2.getX() &&
					rect1.getY() + rect1.getHeight() > rect2.getY() &&
					rect1.getX() < rect2.getX() + rect2.getWidth() &&
					rect1.getY() < rect2.getY() + rect2.getHeight();
		}
		return false;
	}
}
