package framework.physical;

import java.util.Vector;

public interface IPhysicalEngine {
	public void addObject(PhysicalObject obj);

	public Vector<PhysicalObject> getObjects();

	public void removeObject(PhysicalObject obj);

	public void update();
}
