package unit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import framework.geometry.FrameworkCircle;
import framework.geometry.FrameworkRectangle;

public class TestRectangle {
	@Order(0)
	@Test
	public void testRectangleInitialization() {
		FrameworkRectangle rectangle = new FrameworkRectangle(10, 20, 30, 40);
		assertEquals(10, rectangle.getX());
		assertEquals(20, rectangle.getY());
		assertEquals(30, rectangle.getWidth());
		assertEquals(40, rectangle.getHeight());
	}

	@Order(10)
	@Test
	public void testDefaultRectangleInitialization() {
		FrameworkRectangle rectangle = new FrameworkRectangle();
		assertEquals(0, rectangle.getX());
		assertEquals(0, rectangle.getY());
		assertEquals(0, rectangle.getWidth());
		assertEquals(0, rectangle.getHeight());
	}

	@Order(20)
	@Test
	public void testSetters() {
		FrameworkRectangle rectangle = new FrameworkRectangle();
		rectangle.setX(10);
		rectangle.setWidth(20);
		rectangle.setY(30);
		rectangle.setHeight(40);
		assertEquals(10, rectangle.getX());
		assertEquals(20, rectangle.getWidth());
		assertEquals(30, rectangle.getY());
		assertEquals(40, rectangle.getHeight());
	}

	@Order(30)
	@Test
	public void testPositionAndCenter() {
		FrameworkRectangle rectangle = new FrameworkRectangle(10, 30, 20, 40);
		assertEquals(10, rectangle.getPosition().getX());
		assertEquals(30, rectangle.getPosition().getY());
		assertEquals(20, rectangle.getCenter().getX());
		assertEquals(50, rectangle.getCenter().getY());
	}

	@Order(40)
	@Test
	public void testRectangleToRectangleCollision() {
		FrameworkRectangle rectangle1 = new FrameworkRectangle(10, 20, 30, 40);
		FrameworkRectangle rectangle2 = new FrameworkRectangle(15, 25, 35, 45);
		FrameworkRectangle rectangle3 = new FrameworkRectangle(50, 20, 30, 40);

		assertTrue(rectangle1.intersect(rectangle2));
		assertFalse(rectangle1.intersect(rectangle3));

		FrameworkRectangle rectangle4 = new FrameworkRectangle(10, 10, 30, 40);
		assertTrue(rectangle1.intersect(rectangle4));

		FrameworkRectangle rectangle5 = new FrameworkRectangle(20, 20, 30, 40);
		assertTrue(rectangle4.intersect(rectangle5));
		assertTrue(rectangle1.intersect(rectangle5));
	}

	@Order(45)
	@Test
	public void testRectangleToCircleCollision() {
		FrameworkRectangle rectangle = new FrameworkRectangle(10, 20, 30, 40);
		FrameworkCircle circle = new FrameworkCircle(15, 25, 30);
		FrameworkCircle circle2 = new FrameworkCircle(150, 70, 30);

		assertTrue(rectangle.intersect(circle));
		assertTrue(circle.intersect(rectangle));
		assertFalse(rectangle.intersect(circle2));
	}

	@Order(50)
	@Test
	public void testExtension() {
		FrameworkRectangle rectangle = new FrameworkRectangle(10, 20, 30, 40);
		FrameworkRectangle extendedRectangle = rectangle.extend(5, 10);

		assertEquals(15, extendedRectangle.getX());
		assertEquals(30, extendedRectangle.getY());
		assertEquals(30, extendedRectangle.getWidth());
		assertEquals(40, extendedRectangle.getHeight());
	}

	@Order(60)
	@Test
	public void testEquality() {
		FrameworkRectangle rectangle1 = new FrameworkRectangle(10, 20, 30, 40);
		FrameworkRectangle rectangle2 = new FrameworkRectangle(10, 20, 30, 40);
		FrameworkRectangle rectangle3 = new FrameworkRectangle(15, 25, 35, 45);

		assertEquals(rectangle1, rectangle2);
		assertNotEquals(rectangle1, rectangle3);
	}

	@Order(70)
	@Test
	public void testToString() {
		FrameworkRectangle rectangle = new FrameworkRectangle(10, 20, 30, 40);
		assertEquals("Rect{x=10, y=20, width=30, height=40}", rectangle.toString());
	}
}
