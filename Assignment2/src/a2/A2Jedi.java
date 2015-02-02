package a2;

import java.util.Scanner;

public class A2Jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process_input(s);
	}

	public static void process_input(Scanner s) {
		//The number of rectangles
		int rect_count = s.nextInt();
		//The array to store the number of intersect rectangles of each rectangle
		int[] num_intersect = new int[rect_count];
		//The array to store points of the rectangles, each row represents a rectangle
		Rectangle[] rect_array = new Rectangle[rect_count];
		//The array to store whether two rectangles intersect, if two rectangles intersect, 
		//the corresponding element is 1, otherwise 0
		int[][] intersect_flag = new int[rect_count][rect_count];

		for (int i=0; i<rect_count; i++) {
			//Store the label into array labels
			String label = s.next();
			//Store point values to one row of rect_array
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			rect_array[i] = new Rectangle(x1, y1, x2, y2, label);	
		}

		//Check whether two rectangle intersect
		for (int i=0; i<rect_count; i++) {
			for (int j=i+1; j<rect_count; j++) {
				//If two rectangle intersect, set intersect_flag to 1, increase num_intersect by 1
				if (rect_array[i].intersects(rect_array[j])) {
					intersect_flag[i][j] = 1;
					intersect_flag[j][i] = 1;
					num_intersect[i] += 1;
					num_intersect[j] += 1;
				}
			}
		}

		//Print the report
		for (int i=0; i<rect_count; i++) {
			System.out.print(rect_array[i].getLabel() + " intersects");
			//Check whether a rectangle intersects another, if not, print "nothing"
			if (num_intersect[i] != 0) {
				for (int j=0; j<rect_count; j++) {
					//If the corresponding intersect_flag is 1, print the label of the rectangle
					if (intersect_flag[i][j] == 1) {
						System.out.print(" " + rect_array[j].getLabel());
					}
				}
				System.out.print("\n");
			} else {
				System.out.print(" nothing\n");
			}

		}

	}
}
