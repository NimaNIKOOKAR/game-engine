package unit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import framework.geometry.FrameworkVector;

public class TestFrameworkVector {
	@Test
	public void testFrameworkVectorInitialization() {
		FrameworkVector FrameworkVector = new FrameworkVector(10, 20);
		assertEquals(10, FrameworkVector.getX());
		assertEquals(20, FrameworkVector.getY());
	}

	@Test
	public void testDefaultFrameworkVectorInitialization() {
		FrameworkVector FrameworkVector = new FrameworkVector();
		assertEquals(0, FrameworkVector.getX());
		assertEquals(0, FrameworkVector.getY());
	}

	@Test
	public void testSetters() {
		FrameworkVector FrameworkVector = new FrameworkVector();
		FrameworkVector.setX(10);
		FrameworkVector.setY(20);
		assertEquals(10, FrameworkVector.getX());
		assertEquals(20, FrameworkVector.getY());
	}

	@Test
	public void testSetCoordinate() {
		FrameworkVector FrameworkVector = new FrameworkVector();
		FrameworkVector.setCoordinate(10, 20);
		assertEquals(10, FrameworkVector.getX());
		assertEquals(20, FrameworkVector.getY());
	}

	@Test
	public void testAddition() {
		FrameworkVector FrameworkVector1 = new FrameworkVector(10, 20);
		FrameworkVector FrameworkVector2 = new FrameworkVector(5, 15);
		FrameworkVector result = FrameworkVector1.add(FrameworkVector2);
		assertEquals(15, result.getX());
		assertEquals(35, result.getY());
	}

	@Test
	public void testSubtraction() {
		FrameworkVector FrameworkVector1 = new FrameworkVector(10, 20);
		FrameworkVector FrameworkVector2 = new FrameworkVector(5, 15);
		FrameworkVector result = FrameworkVector1.subtract(FrameworkVector2);
		assertEquals(5, result.getX());
		assertEquals(5, result.getY());
	}

	@Test
	public void testScaling() {
		FrameworkVector FrameworkVector = new FrameworkVector(10, 20);
		FrameworkVector scaledFrameworkVector = FrameworkVector.scale(2);
		assertEquals(20, scaledFrameworkVector.getX());
		assertEquals(40, scaledFrameworkVector.getY());
	}

	@Test
	public void testCalculateDistance() {
		FrameworkVector FrameworkVector1 = new FrameworkVector(10, 20);
		FrameworkVector FrameworkVector2 = new FrameworkVector(15, 30);
		int distance = FrameworkVector1.squaredDistance(FrameworkVector2);

		// The expected result should be the Euclidean distance between the two FrameworkVectors.
		// In this case, it's the square root of (25 + 100) = 11.18 (approximately)
		assertEquals(11, distance);
	}

	@Test
	public void testEquality() {
		FrameworkVector FrameworkVector1 = new FrameworkVector(10, 20);
		FrameworkVector FrameworkVector2 = new FrameworkVector(10, 20);
		FrameworkVector FrameworkVector3 = new FrameworkVector(5, 15);

		assertEquals(FrameworkVector1, FrameworkVector2);
		assertNotEquals(FrameworkVector1, FrameworkVector3);
	}

	@Test
	public void testToString() {
		FrameworkVector FrameworkVector = new FrameworkVector(10, 20);
		assertEquals("Point (X :10, Y :20)", FrameworkVector.toString());
	}
}
