package a1;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		//Read input
		Scanner s = new Scanner(System.in);

		//Process the input
	    process(s);

	}
	
	public static void process(Scanner s) {
		//The number of rectangles
		int rect_count = s.nextInt();
		//The array to store labels of rectangles
		String[] labels = new String[rect_count];
		//The array to store the number of intersect rectangles of each rectangle
		int[] num_intersect = new int[rect_count];
		//The array to store points of the rectangles, each row represents a rectangle
		int[][] rect_array = new int[rect_count][4];
		//The array to store whether two rectangles intersect, if two rectangles intersect, 
		//the corresponding element is 1, otherwise 0
		int[][] intersect_flag = new int[rect_count][rect_count];
		
		for (int i=0; i<rect_count; i++) {
			//Store the label into array labels
			labels[i] = s.next();
			//Store point values to one row of rect_array
			for (int j=0; j<4; j++) {
				rect_array[i][j] = s.nextInt();
			}
		}
		
		//Check whether two rectangle intersect
		for (int i=0; i<rect_count; i++) {
			for (int j=i+1; j<rect_count; j++) {
				//If two rectangle intersect, set intersect_flag to 1, increase num_intersect by 1
				if (isIntersect(rect_array[i], rect_array[j])) {
					intersect_flag[i][j] = 1;
					intersect_flag[j][i] = 1;
					num_intersect[i] += 1;
					num_intersect[j] += 1;
				}
			}
		}
		
		//Print the report
		for (int i=0; i<rect_count; i++) {
			System.out.print(labels[i] + " intersects");
			//Check whether a rectangle intersects another, if not, print "nothing"
			if (num_intersect[i] != 0) {
				for (int j=0; j<rect_count; j++) {
					//If the corresponding intersect_flag is 1, print the label of the rectangle
					if (intersect_flag[i][j] == 1) {
						System.out.print(" " + labels[j]);
					}
				}
				System.out.print("\n");
			} else {
				System.out.print(" nothing\n");
			}
			
		}
		
	}
	
	/* Check whether rectangle rect1 intersects rectangle rect2
	 * Input: array of the rectangle rect1, rect2 contains four elements: x1, y1, x2, y2
	 */
	public static boolean isIntersect(int[] rect1, int[] rect2) {
		//If rect2's right x bound not greater than rect1's left x bound, not intersect
		if (Math.max(rect2[0], rect2[2]) <= Math.min(rect1[0], rect1[2])) {
			return false;
		}
		//If rect2's left x bound not smaller than rect1's right x bound, not intersect
		if (Math.min(rect2[0], rect2[2]) >= Math.max(rect1[0], rect1[2])) {
			return false;
		}
		//If rect2's upper y bound not greater than rect1's lower y bound, not intersect
		if (Math.max(rect2[1], rect2[3]) <= Math.min(rect1[1], rect1[3])) {
			return false;
		}
		//If rect2's lower y bound not smaller than rect1's upper y bound, not intersect
		if (Math.min(rect2[1], rect2[3]) >= Math.max(rect1[1], rect1[3])) {
			return false;
		}
		//Other situations, intersect
		return true;
		
	}

}
