package framework.geometry;

import framework.geometry.collisions.CircleCircleCollisionStrategy;
import framework.geometry.collisions.RectangleCircleCollisionStrategy;

public class FrameworkCircle extends FrameworkShape{
	private int radius;

	public FrameworkCircle(int initX, int initY, int initRadius) {
		super(initX, initY);
		this.setRadius(initRadius);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setCircle(int x, int y, int radius) {
		setX(x);
		setY(y);
		setRadius(radius);
	}

	public FrameworkVector getCenter() {
		return new FrameworkVector(getX(), getY());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FrameworkCircle circle = (FrameworkCircle) o;
		return x == circle.x &&
				y == circle.y &&
				radius == circle.radius;
	}

	@Override
	public String toString() {
		return "Circle{" +
				"x=" + x +
				", y=" + y +
				", radius=" + radius +
				"}";
	}

	@Override
	public boolean intersect(FrameworkShape shape) {
		if (shape instanceof FrameworkRectangle) {
			super.setCollisionStrategy(new RectangleCircleCollisionStrategy());
			return super.getCollisionStrategy().intersect(shape, this);

		} else if (shape instanceof FrameworkCircle) {
			super.setCollisionStrategy(new CircleCircleCollisionStrategy());
		}

		return collisionStrategy.intersect(this, shape);
	}
}
