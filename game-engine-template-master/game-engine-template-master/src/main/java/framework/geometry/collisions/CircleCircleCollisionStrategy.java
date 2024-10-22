package framework.geometry.collisions;

import framework.geometry.FrameworkCircle;
import framework.geometry.FrameworkShape;

public class CircleCircleCollisionStrategy implements ICollisionStrategy {
	@Override
	public boolean intersect(FrameworkShape shape1, FrameworkShape shape2) {
		if (shape1 instanceof FrameworkCircle && shape2 instanceof FrameworkCircle) {
			FrameworkCircle circle1 = (FrameworkCircle) shape1;
			FrameworkCircle circle2 = (FrameworkCircle) shape2;

			int distance = (int) Math.sqrt(Math.pow((circle2.getX() - circle1.getX()), 2) +
					Math.pow((circle2.getY() - circle1.getY()), 2));
			return distance <= (circle1.getRadius() + circle2.getRadius());
		}
		return false;
	}
}
