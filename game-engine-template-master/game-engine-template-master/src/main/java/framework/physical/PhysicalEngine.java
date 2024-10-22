package framework.physical;

import java.util.Vector;

import framework.tools.IdFactory;

public class PhysicalEngine implements IPhysicalEngine {
	private final Vector<PhysicalObject> objects;

	public PhysicalEngine() {
		objects = new Vector<>();
	}

	public static PhysicalObject createObject(int initX, int width, int initY, int height) {
		return new PhysicalObject(initX, width, initY, height, IdFactory.nextId());
	}

	@Override
	public void addObject(PhysicalObject object) {
		objects.add(object);
	}

	@Override
	public Vector<PhysicalObject> getObjects() {return this.objects;}

	@Override
	public void removeObject(PhysicalObject object) {
		objects.remove(object);
	}

	@Override
	public void update() {
		for (PhysicalObject object : objects) {
			object.setPosition(object.getPosition().add(object.getVelocity()));
		}
	}

}
