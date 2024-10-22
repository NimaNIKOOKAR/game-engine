package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import framework.physical.PhysicalEngine;
import framework.physical.PhysicalObject;

public class TestPhysicalEngine {
	private PhysicalEngine physicalEngine;

	@BeforeEach
	public void setUp() {
		physicalEngine = new PhysicalEngine();
	}

	@Test
	public void testAddObject() {
		PhysicalObject object = new PhysicalObject(1, 10, 20, 30, 40);
		physicalEngine.addObject(object);

		Vector<PhysicalObject> objects = physicalEngine.getObjects();
		assertTrue(objects.contains(object));
	}

	@Test
	public void testRemoveObject() {
		PhysicalObject object = new PhysicalObject(1, 10, 20, 30, 40);
		physicalEngine.addObject(object);
		physicalEngine.removeObject(object);

		Vector<PhysicalObject> objects = physicalEngine.getObjects();
		assertFalse(objects.contains(object));
	}

	@Test
	public void testUpdate() {
		PhysicalObject object = new PhysicalObject(1, 10, 20, 30, 40);
		physicalEngine.addObject(object);

		object.setVelocity(5, 5);
		physicalEngine.update();

		Vector<PhysicalObject> objects = physicalEngine.getObjects();
		PhysicalObject updatedObject = objects.firstElement();

		assertEquals(15, updatedObject.getX());
		assertEquals(25, updatedObject.getY());
	}
}
