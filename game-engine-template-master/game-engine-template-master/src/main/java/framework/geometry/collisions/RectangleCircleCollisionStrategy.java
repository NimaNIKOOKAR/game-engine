package framework.geometry.collisions;

import framework.geometry.FrameworkCircle;
import framework.geometry.FrameworkRectangle;
import framework.geometry.FrameworkShape;

public class RectangleCircleCollisionStrategy implements ICollisionStrategy {

	@Override
	public boolean intersect(FrameworkShape shape1, FrameworkShape shape2) {
		if (shape1 instanceof FrameworkRectangle && shape2 instanceof FrameworkCircle) {
			FrameworkRectangle rect = (FrameworkRectangle) shape1;
			FrameworkCircle circle = (FrameworkCircle) shape2;

			int closestX = clamp(circle.getX(), rect.getX(), rect.getX() + rect.getWidth());
			int closestY = clamp(circle.getY(), rect.getY(), rect.getY() + rect.getHeight());

			int distanceX = circle.getX() - closestX;
			int distanceY = circle.getY() - closestY;

			return (distanceX * distanceX + distanceY * distanceY) <= (circle.getRadius() * circle.getRadius());
		}
		return false;
	}

	private int clamp(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}
}
