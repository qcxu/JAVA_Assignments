package a1;
import java.util.Scanner;

public class A1Adept {
	
	public static void main(String[] args) {
		//Read input
		Scanner s = new Scanner(System.in);

		//Process the input
	    process(s);

	}
	
	public static void process(Scanner s) {
		//Initialize variables
		//The number of rectangles
		int rect_count = s.nextInt();
		//The array to store labels of rectangles
		String[] labels = new String[rect_count];
		//The array to store number of rectangles intersects
		int[] num_contain = new int[rect_count];
		//The array to store points of the rectangles, each row represents a rectangle
		int[][] rect_array = new int[rect_count][4];
		
		for (int i=0; i<rect_count; i++) {
			//Store the label into array labels
			labels[i] = s.next();
			//Store point values to one row of rect_array
			for (int j=0; j<4; j++) {
				rect_array[i][j] = s.nextInt();
			}
		}
		
		//The number of points
		int point_count = s.nextInt();
		//The array to store the number of points containing in each rectangle
		int[][] point_array = new int[point_count][2];
		//Store point x,y value to point_array
		for (int i=0; i<point_count; i++) {
			point_array[i][0] = s.nextInt();
			point_array[i][1] = s.nextInt();
		}
		
		//Check whether the point is contained in the rectangle
		for (int i=0; i<rect_count; i++) {
			for (int j=0; j<point_count; j++) {
				//If the point is contained in the rectangle, increase the num_contain of that rectangle by 1
				if (isContain(rect_array[i], point_array[j])) {
					num_contain[i] += 1;
				}
			}
		}
		
		//Print the report
		for (int i=0; i<rect_count; i++) {
			System.out.println(labels[i] + " contains " + num_contain[i] + " points");
		}
		
	}
	
	/* Check whether the rectangle contains the point
	 * Input: array of the rectangle rect contains four elements: x1, y1, x2, y2
	 * Input: array of the point point contains two elements: x, y
	 */
	public static boolean isContain(int[] rect, int[] point) {
		//Get the smaller value of the rectangle point on x-coordinate
		int x_min = Math.min(rect[0], rect[2]);
		//Get the larger value of the rectangle point on x-coordinate
		int x_max = Math.max(rect[0], rect[2]);
		//Get the smaller value of the rectangle point on y-coordinate
		int y_min = Math.min(rect[1], rect[3]);
		//Get the larger value of the rectangle point on x-coordinate
		int y_max = Math.max(rect[1], rect[3]);
		//Check whether the point's x-value is between rectangle's x range
		if (point[0] > x_min && point[0] < x_max) {
			//Check whether the point's y-value is between rectangle's y range
			if (point[1] >y_min && point[1] < y_max) {
				return true;
			}
		}
		return false;
	}

}
