package framework.graphical;
import framework.geometry.FrameworkVector;
import framework.graphical.sprite.Sprite;
import framework.graphical.sprite.SpriteSheet;

public class GraphicalObject {
	private final FrameworkVector position;
	private final int id;
	private Sprite sprite;
	private boolean visible;

	public GraphicalObject(int id, Sprite sprite) {
		this.sprite = sprite;
		this.id = id;
		position = new FrameworkVector();
		visible = true;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public void setSpriteSheet(SpriteSheet spriteSheet) {
		this.sprite.setSpriteSheet(spriteSheet);
	}

	public void setPosition(int X, int Y) {
		position.setCoordinate(X, Y);
	}

	public FrameworkVector getPosition() {
		return position;
	}

	public boolean isVisible() {
		return visible;
	}

	public void show() {
		visible = true;
	}

	public void hide() {
		visible = false;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GraphicalObject)) return false;

		GraphicalObject other = (GraphicalObject) obj;

		return getId() == other.getId();
	}

	@Override
	public String toString() {
		return "GraphicObject{" +
				"position=" + position +
				", visible=" + visible +
				", sprite=" + sprite +
				", id=" + id +
				'}';
	}
}

