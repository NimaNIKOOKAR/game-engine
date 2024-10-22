package framework.graphical.sprite;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private SpriteSheet spriteSheet;

	private BufferedImage image;
	private int x;
	private int y;
	private int height;
	private int width;


	public Sprite(String imagePath, int x, int y, int height, int width) {
		try {
			this.image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public Sprite(BufferedImage image) {
		this.image = image;
		this.x = 0;
		this.y = 0;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}


	public Sprite(SpriteSheet spriteSheet) {
		// TODO Auto-generated constructor stub
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Sprite getSubImage(int x, int y, int w, int h) {
		return new Sprite(image.getSubimage(x, y, w, h));
	}

	public Sprite getNewSubImage(int x, int y, int w, int h) {
		BufferedImage temp = image.getSubimage(x, y, w, h);
		BufferedImage newImage = new BufferedImage(image.getColorModel(), image.getRaster().createCompatibleWritableRaster(w,h), image.isAlphaPremultiplied(), null);
		temp.copyData(newImage.getRaster());
		return new Sprite(newImage);
	}

	public Sprite getNewSubImage() {
		return getNewSubImage(0, 0, this.width, this.height);
	}

	public void update(int x, int y) {
		setX(x);
		setY(y);
	}

	public void setSpriteSheet(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
}
