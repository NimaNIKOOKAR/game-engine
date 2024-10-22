package framework.geometry;

import framework.geometry.collisions.RectangleCircleCollisionStrategy;
import framework.geometry.collisions.RectangleRectangleCollisionStrategy;

public class FrameworkRectangle extends FrameworkShape {
	private int width;
	private int height;

	public FrameworkRectangle(int x, int y, int width, int height) {
		super(x,y);
		this.width = width;
		this.height = height;
	}

	public FrameworkRectangle() {
		this(0, 0, 0, 0);
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setRectangle(int x, int width, int y, int height) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public FrameworkVector getPosition() {
		return new FrameworkVector(getX(), getY());
	}

	public FrameworkVector getCenter() {
		return new FrameworkVector(getX() + getWidth() / 2, getY() + getHeight() / 2);
	}

	public FrameworkRectangle extend(int X, int Y) {
		return new FrameworkRectangle(
				getX() + X,
				getWidth(),
				getY() + Y,
				getHeight()
				);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FrameworkRectangle frameworkRectangle = (FrameworkRectangle) o;
		return x == frameworkRectangle.x &&
				y == frameworkRectangle.y &&
				width == frameworkRectangle.width &&
				height == frameworkRectangle.height;
	}

	@Override
	public String toString() {
		return "Rect{" +
				"x=" + x +
				", y=" + y +
				", width=" + width +
				", height=" + height +
				"}";
	}

	@Override
	public boolean intersect(FrameworkShape shape) {
		if (shape instanceof FrameworkRectangle) {
			super.setCollisionStrategy(new RectangleRectangleCollisionStrategy());

		} else if (shape instanceof FrameworkCircle) {
			super.setCollisionStrategy(new RectangleCircleCollisionStrategy());
		}

		return collisionStrategy.intersect(this, shape);
	}
}

