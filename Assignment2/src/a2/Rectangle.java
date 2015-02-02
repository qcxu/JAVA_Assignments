package a2;

public class Rectangle {

	// These are the object fields
	// that represent the bottom left and upper right
	// corners of the rectangle. 
	//
	// Do not change the declaration of these fields.
	// Do not add any additional fields.

	private Point bottom_left;
	private Point upper_right;
	private String label;
	
	// This is the constructor for a Rectangle object.
	// It requires the x and y coordinates of two points
	// for opposite corners of the rectangle. The coordinates
	// as given may or may not be the bottom left and upper right
	// corners (you'll have to check and adust as necessary). 
	// Complete the constructor to initialize
	// the rectangle's fields as appropriate.
	public Rectangle(int x1, int y1, int x2, int y2, String l) {
		
		int bottom_left_x = (x1 < x2) ? x1 : x2;
		int bottom_left_y = (y1 < y2) ? y1 : y2;
		int upper_right_x = (x1 > x2) ? x1 : x2;
		int upper_right_y = (y1 > y2) ? y1 : y2;
		
		this.bottom_left = new Point(bottom_left_x, bottom_left_y);
		this.upper_right = new Point(upper_right_x, upper_right_y);
		this.label = l;

	}
	
	// This method should return the label
		// for the rectangle.
		public String getLabel() {
			
			return this.label;
			
		}
	
	// This method should return the x-coordinate of the
	// rectangle's left side.
	public int getLeft() {

		return bottom_left.getX();

	}
	
	// This method should return the x-coordinate of the
	// rectangle's right side.
	public int getRight() {

		return upper_right.getX();

	}

	// This method should return the y-coordinate of the
	// rectangle's top side.
	public int getTop() {

		return upper_right.getY();

	}
	
	// This method should return the y-coordinate of the
	// rectangle's bottom side.
	public int getBottom() {

		return bottom_left.getY();

	}
	
	// This method should return the width of the rectangle.
	public int getWidth() {

		return getRight() - getLeft();

	}
	
	// This method should return the height of the rectangle.
	public int getHeight() {

		return getTop() - getBottom();

	}
	
	// This method should return the area of the rectangle.
	public int getArea() {

		return getWidth() * getHeight();

	}
	
	// This method should return the perimeter of the rectangle.
	public int getPerimeter() {

		return 2 * (getWidth() + getHeight());

	}
	
	// This method should return a new Rectangle object
	// that is the same size as the rectangle but
	// translated by dx in the x-direction and dy in
	// the y-direction.
	public Rectangle translate(int dx, int dy) {

		int bottom_left_x = this.bottom_left.getX() + dx;
		int bottom_left_y = this.bottom_left.getY() + dy;
		int upper_right_x = this.upper_right.getX() + dx;
		int upper_right_y = this.upper_right.getY() + dy;
		String l = this.label;

		return new Rectangle(bottom_left_x, bottom_left_y, 
				upper_right_x, upper_right_y, l);

	}
	
	// This method should test the given Point p
	// for being inside the rectangle. Note that
	// a point on the edge of a rectangle is NOT inside.
	public boolean testPoint(Point p) {
		
		return (p.getX() > this.bottom_left.getX() 
				&& p.getX() < this.upper_right.getX()
				&& p.getY() > this.bottom_left.getY() 
				&& p.getY() < this.upper_right.getY());

	}
	
	// This method should test the given Rectangle r
	// for having the same geometry (i.e., same 
	// coordinates for top/bottom/left/right).
	public boolean equals(Rectangle r) {

		return (this.bottom_left.getX() == r.bottom_left.getX() 
				&& this.bottom_left.getY() == r.bottom_left.getY()
				&& this.upper_right.getX() == r.upper_right.getX()
				&& this.upper_right.getY() == r.upper_right.getY());

	}
	
	// This method should test the given Rectangle r
	// for intersection with the rectangle. 
	public boolean intersects(Rectangle r) {
		if (r.bottom_left.getX() >= this.upper_right.getX()) 
			return false;
		if (r.bottom_left.getY() >= this.upper_right.getY())
			return false;
		if (r.upper_right.getX() <= this.bottom_left.getX())
			return false;
		if (r.upper_right.getY() <= this.bottom_left.getY())
			return false;
		return true;
			
	}
	
	// This method should test whether the 
	// rectangle is taller than it is wide.
	public boolean isTall() {

		return (getWidth() < getHeight());

	}
	
	// This method should test whether the
	// rectangle is wider than it is tall.
	public boolean isWide() {

		return (getWidth() > getHeight());

	}
	
	// This method should test whether the
	// rectangle is a square.
	public boolean isSquare() {

		return (getWidth() == getHeight());

	}
}

