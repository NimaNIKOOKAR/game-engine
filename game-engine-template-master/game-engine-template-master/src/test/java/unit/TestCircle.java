package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import framework.geometry.FrameworkCircle;

public class TestCircle {
	@Order(0)
	@Test
	public void testCircleInitialization() {
		FrameworkCircle circle = new FrameworkCircle(100, 100, 200);
		assertEquals(100, circle.getX());
		assertEquals(100, circle.getY());
		assertEquals(200, circle.getRadius());
	}

	@Order(10)
	@Test
	public void testSetters() {
		FrameworkCircle circle = new FrameworkCircle(100, 100, 200);
		circle.setX(200);
		circle.setY(300);
		circle.setRadius(400);

		assertEquals(200, circle.getX());
		assertEquals(300, circle.getY());
		assertEquals(400, circle.getRadius());
	}

	@Order(20)
	@Test
	public void testEquality() {
		FrameworkCircle circle1 = new FrameworkCircle(100, 100, 200);
		FrameworkCircle circle2 = new FrameworkCircle(100, 100, 200);
		FrameworkCircle circle3 = new FrameworkCircle(150, 100, 200);
		FrameworkCircle circle4 = circle2;

		assertEquals(circle1, circle2);
		assertEquals(circle2, circle4);
		assertEquals(circle1, circle4);
		assertNotEquals(circle1, circle3);

	}

	@Order(30)
	@Test
	public void testToString() {
		FrameworkCircle circle = new FrameworkCircle(100, 100, 200);
		assertEquals("Circle{x=100, y=100, radius=200}", circle.toString());
	}

	@Order(40)
	@Test
	public void testCircleToCircleCollision() {
		FrameworkCircle circle1 = new FrameworkCircle(100, 100, 200);
		FrameworkCircle circle2 = new FrameworkCircle(200, 200, 200);
		FrameworkCircle circle3 = new FrameworkCircle(380, 380, 50);
		FrameworkCircle circle4 = new FrameworkCircle(380, 380, 200);

		assertTrue(circle1.intersect(circle2));
		assertFalse(circle1.intersect(circle3));
		assertTrue(circle1.intersect(circle4));

	}

}
