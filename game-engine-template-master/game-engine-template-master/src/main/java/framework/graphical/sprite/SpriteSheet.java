package framework.graphical.sprite;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private Sprite SPRITESHEET = null;
	private Sprite[][] spriteArray;
	private final int TILE_SIZE = 32;
	public int width;
	public int height;
	private int wSprite;
	private int hSprite;
	private String file;

	public SpriteSheet(String file) {
		this.file = file;
		width = TILE_SIZE;
		height = TILE_SIZE;

		System.out.println("Loading: " + file + "...");
		SPRITESHEET = new Sprite(loadSprite(file));

		wSprite = SPRITESHEET.getImage().getWidth() / width;
		hSprite = SPRITESHEET.getImage().getHeight() / height;
		loadSpriteArray();
	}

	public SpriteSheet(Sprite sprite, String name, int w, int h) {
		this.width = w;
		this.height = h;

		System.out.println("Loading: " + name + "...");
		SPRITESHEET = sprite;

		wSprite = SPRITESHEET.getImage().getWidth() / w;
		hSprite = SPRITESHEET.getImage().getHeight() / h;
		loadSpriteArray();

	}

	public SpriteSheet(String file, int w, int h) {
		this.width = w;
		this.height = h;
		this.file = file;

		System.out.println("Loading: " + file + "...");
		SPRITESHEET = new Sprite(loadSprite(file));

		wSprite = SPRITESHEET.getImage().getWidth() / w;
		hSprite = SPRITESHEET.getImage().getHeight() / h;
		loadSpriteArray();
	}

	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(int width) {
		this.width = width;
		wSprite = SPRITESHEET.getImage().getWidth() / width;
	}

	public void setHeight(int height) {
		this.height = height;
		hSprite = SPRITESHEET.getImage().getHeight() / height;
	}

	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getRows() { return hSprite; }
	public int getCols() { return wSprite; }
	public int getTotalTiles() { return wSprite * hSprite; }
	public String getFilename() { return file; }

	private BufferedImage loadSprite(String file) {
		BufferedImage sprite = null;
		try {
			sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
		} catch (Exception e) {
			System.out.println("ERROR: could not load file: " + file);
		}
		return sprite;
	}

	public void loadSpriteArray() {
		spriteArray = new Sprite[hSprite][wSprite];

		for (int y = 0; y < hSprite; y++) {
			for (int x = 0; x < wSprite; x++) {
				spriteArray[y][x] = getSprite(x, y);
			}
		}
	}


	public Sprite getSpriteSheet() {
		return SPRITESHEET;
	}

	public Sprite getSprite(int x, int y) {
		return SPRITESHEET.getSubImage(x * width, y * height, width, height);
	}

	public Sprite getNewSprite(int x, int y) {
		return SPRITESHEET.getNewSubImage(x * width, y * height, width, height);
	}

	public Sprite getSprite(int x, int y, int w, int h) {
		return SPRITESHEET.getSubImage(x * w, y * h, w, h);
	}

	public BufferedImage getSubimage(int x, int y, int w, int h) {
		return SPRITESHEET.getImage().getSubimage(x, y, w, h);
	}

	public Sprite[] getSpriteArray(int i) {
		return spriteArray[i];
	}

	public Sprite[][] getSpriteArray2() {
		return spriteArray;
	}

}