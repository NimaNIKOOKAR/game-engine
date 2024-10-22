package framework.geometry.collisions;

import framework.geometry.FrameworkShape;

public interface ICollisionStrategy {
	boolean intersect(FrameworkShape shape1, FrameworkShape shape2);
}
