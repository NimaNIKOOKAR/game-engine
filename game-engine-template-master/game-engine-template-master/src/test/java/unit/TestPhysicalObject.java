package unit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import framework.geometry.FrameworkRectangle;
import framework.physical.PhysicalObject;

public class TestPhysicalObject {
	private PhysicalObject physicalObject;

	@BeforeEach
	public void setUp() {
		// Create a PhysicalObject for testing
		physicalObject = new PhysicalObject(1, 10, 20, 30, 40);
	}

	@Test
	public void testPositionInitialization() {
		assertEquals(10, physicalObject.getX());
		assertEquals(20, physicalObject.getY());
	}

	@Test
	public void testVelocityInitialization() {
		assertEquals(0, physicalObject.getVelocityX());
		assertEquals(0, physicalObject.getVelocityY());
	}

	@Test
	public void testHitboxInitialization() {
		FrameworkRectangle hitbox = (FrameworkRectangle) physicalObject.getHitbox();
		assertEquals(0, hitbox.getX());
		assertEquals(30, hitbox.getWidth());
		assertEquals(0, hitbox.getY());
		assertEquals(40, hitbox.getHeight());
	}

	@Test
	public void testSetPosition() {
		physicalObject.setPosition(15, 25);
		assertEquals(15, physicalObject.getX());
		assertEquals(25, physicalObject.getY());
	}

	@Test
	public void testSetVelocity() {
		physicalObject.setVelocity(2, 3);
		assertEquals(2, physicalObject.getVelocityX());
		assertEquals(3, physicalObject.getVelocityY());
	}

	@Test
	public void testSetHitbox() {
		FrameworkRectangle newHitbox = new FrameworkRectangle(5, 50, 5, 60);
		physicalObject.setHitbox(newHitbox);
		assertEquals(newHitbox, physicalObject.getHitbox());
	}

	@Test
	public void testCollideWithRectangle() {
		FrameworkRectangle rectangle = new FrameworkRectangle(10, 30, 20, 40);
		assertTrue(physicalObject.collideWith(rectangle));
	}

	@Test
	public void testCollideWithPhysicalObject() {
		PhysicalObject otherObject = new PhysicalObject(2, 5, 15, 30, 50);
		assertTrue(physicalObject.collideWith(otherObject));
	}

	@Test
	public void testEquality() {
		PhysicalObject otherObject = new PhysicalObject(1, 10, 20, 30, 40);
		assertEquals(physicalObject, otherObject);
	}
}
