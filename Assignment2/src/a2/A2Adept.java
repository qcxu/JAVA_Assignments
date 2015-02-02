package a2;

import java.util.Scanner;

public class A2Adept {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process_input(s);
	}

	public static void process_input(Scanner s) {
		//Initialize variables
		//The number of rectangles
		int rect_count = s.nextInt();
		//The array to store number of rectangles intersects
		int[] num_contain = new int[rect_count];
		//The array to store points of the rectangles, each row represents a rectangle
		Rectangle[] rect_array = new Rectangle[rect_count];

		for (int i=0; i<rect_count; i++) {
			//Store the label into array labels
			String label = s.next();
			//Get point values
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			rect_array[i] = new Rectangle(x1, y1, x2, y2, label);	
		}

		//The number of points
		int point_count = s.nextInt();
		//The array to store the number of points containing in each rectangle
		Point[] point_array = new Point[point_count];
		//Store point x,y value to point_array
		for (int i=0; i<point_count; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			point_array[i] = new Point(x, y);
		}

		//Check whether the point is contained in the rectangle
		for (int i=0; i<rect_count; i++) {
			for (int j=0; j<point_count; j++) {
				//If the point is contained in the rectangle, increase the num_contain of that rectangle by 1
				if (rect_array[i].testPoint(point_array[j])) {
					num_contain[i] += 1;
				}
			}
		}

		//Print the report
		for (int i=0; i<rect_count; i++) {
			System.out.println(rect_array[i].getLabel() + " contains " + num_contain[i] + " points");
		}

	}
}
