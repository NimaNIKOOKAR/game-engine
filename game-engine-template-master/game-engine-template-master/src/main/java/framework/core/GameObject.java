package framework.core;

import framework.graphical.GraphicalObject;
import framework.physical.PhysicalObject;

public class GameObject {
	private PhysicalObject physicalObject;
	private GraphicalObject graphicalObject;
	private final int id;

	public GameObject(PhysicalObject physicalObject, GraphicalObject graphicalObject, int id) {
		this.setPhysicalObject(physicalObject);
		this.setGraphicalObject(graphicalObject);
		this.id = id;
	}

	public PhysicalObject getPhysicalObject() {
		return physicalObject;
	}

	public void setPhysicalObject(PhysicalObject physicalObject) {
		this.physicalObject = physicalObject;
	}

	public GraphicalObject getGraphicalObject() {
		return graphicalObject;
	}

	public void setGraphicalObject(GraphicalObject graphicalObject) {
		this.graphicalObject = graphicalObject;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GameObject gameObject = (GameObject) o;
		return id == gameObject.id;
	}

	@Override
	public String toString() {
		return "Character{" +
				"graphicObject=" + graphicalObject +
				", phyObject=" + physicalObject +
				", id=" + id +
				'}';
	}
}
