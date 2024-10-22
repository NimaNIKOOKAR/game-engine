package framework.physical;

import framework.geometry.FrameworkRectangle;
import framework.geometry.FrameworkShape;
import framework.geometry.FrameworkVector;

public class PhysicalObject {
	private FrameworkVector position;
	private FrameworkVector velocity;
	private FrameworkShape hitbox;
	private final int id;


	public PhysicalObject(int id) {
		this.id = id;
		this.position = new FrameworkVector();
		this.velocity = new FrameworkVector();
		this.hitbox = new FrameworkRectangle();
	}

	public PhysicalObject(int id, int initX, int initY, int width, int height) {
		this.id = id;
		this.position = new FrameworkVector(initX, initY);
		this.velocity = new FrameworkVector();
		this.hitbox = new FrameworkRectangle(0, 0, width, height);
	}

	public FrameworkVector getPosition() {
		return position;
	}

	public void setPosition(FrameworkVector position) {
		this.position = position;
	}

	public void setPosition(int x, int y) {
		position.setCoordinate(x, y);
	}

	public int getX() {
		return position.getX();
	}

	public void setX(int x) {
		position.setX(x);
	}

	public int getY() {
		return position.getY();
	}

	public void setY(int y) {
		position.setY(y);
	}

	public FrameworkVector getVelocity() {
		return velocity;
	}

	public void setVelocity(FrameworkVector velocity) {
		this.velocity = velocity;
	}

	public void setVelocity(int x, int y) {
		velocity.setCoordinate(x, y);
	}

	public int getVelocityX() {
		return velocity.getX();
	}

	public void setVelocityX(int x) {
		velocity.setX(x);
	}

	public int getVelocityY() {
		return velocity.getY();
	}

	public void setVelocityY(int y) {
		velocity.setY(y);
	}

	public FrameworkShape getHitbox() {
		return hitbox;
	}

	public void setHitbox(FrameworkShape hitbox) {
		this.hitbox = hitbox;
	}

	public int getId() {
		return id;
	}

	public boolean collideWith(FrameworkShape frameworkShape) {
		return getHitbox().intersect(frameworkShape);
	}

	public boolean collideWith(PhysicalObject physicalObject) {
		return collideWith(physicalObject.getHitbox());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PhysicalObject phyObject = (PhysicalObject) o;
		return id == phyObject.id;
	}
}
