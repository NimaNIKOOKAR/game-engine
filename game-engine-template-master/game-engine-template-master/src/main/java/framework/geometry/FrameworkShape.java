package framework.geometry;

import framework.geometry.collisions.ICollisionStrategy;

public abstract class FrameworkShape {
	protected int x;
	protected int y;
	protected ICollisionStrategy collisionStrategy;

	public FrameworkShape(int initX, int initY) {
		this.x = initX;
		this.y = initY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract boolean intersect(FrameworkShape shape);

	public void setCollisionStrategy(ICollisionStrategy strategy) {
		this.collisionStrategy = strategy;
	}

	public ICollisionStrategy getCollisionStrategy() {
		return this.collisionStrategy;
	}

	public abstract FrameworkVector getCenter();
}
