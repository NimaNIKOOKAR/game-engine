package framework.geometry;

public class FrameworkVector {
	private int X;
	private int Y;

	public FrameworkVector(int initX, int initY) {
		this.X = initX;
		this.Y = initY;
	}

	public FrameworkVector() {
		this(0,0);
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		this.X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		this.Y = y;
	}

	public void setCoordinate(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public FrameworkVector add(FrameworkVector frameworkVector){
		return new FrameworkVector(getX() + frameworkVector.getX(), getY() + frameworkVector.getY());
	}

	public FrameworkVector subtract(FrameworkVector frameworkVector){
		return new FrameworkVector(getX() - frameworkVector.getX(), getY() - frameworkVector.getY());
	}

	public FrameworkVector scale(int scale){
		return new FrameworkVector(getX() * scale, getY() * scale);
	}

	public int squaredDistance(FrameworkVector p){
		return (int) Math.sqrt(Math.pow(getX() - p.getX(),2) + Math.pow(getY() - p.getY(), 2));
	}

	public FrameworkVector opposite() {
		return new FrameworkVector(-this.getX(), -this.getY());
	}

	public FrameworkVector oppositeY() {
		return new FrameworkVector(this.getX(), -this.getY());
	}

	@Override
	public boolean equals(Object o){
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FrameworkVector point = (FrameworkVector) o;
		return X == point.X && Y == point.Y;
	}

	@Override
	public String toString(){
		return "Point (" + "X :" + X + ", Y :" + Y + ")";
	}
}
