package a1;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		//Read input
		Scanner s = new Scanner(System.in);
		
		//Process the input
	    process(s);

	}
	
	public static void process(Scanner s) {
		//Initialize variables
		//The number of rectangles that were square
		int square_count = 0;
		//The number of rectangles that were wider than they were tall
		int wide_count = 0;
		//The number of rectangles that were taller than they were wide
		int tall_count = 0;
		//The rectangle with the maximum perimeter
		int max_peri = 0;
		//The rectangle with the minimum perimeter
		int min_peri = Integer.MAX_VALUE;
		//The rectangle with the maximum area, initialize to zero
		int max_area = 0;
		//The rectangle with the minimum area, initialize to MAX_VALUE
		int min_area = Integer.MAX_VALUE;
		//The Label of rectangle of each result
		String max_peri_label = null;
		String min_peri_label = null;
		String max_area_label = null;
		String min_area_label = null;
		
		//The number of rectangles
		int rect_count = s.nextInt();
		
		//Loop through each rectangles
		for (int i=0; i<rect_count; i++) {
			//The label of the rectangle
			String label = s.next();
			//Two (x,y) points of the rectangle
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			
			//Check whether the rectangle is square
			if (isSquare(x1, y1, x2, y2)) {
				square_count += 1;
			//Check whether the rectangle is wider
			} else if (isWider(x1, y1, x2, y2)) {
				wide_count += 1;
			//Check whether the rectangle is taller
			} else {
				tall_count += 1;
			}
			
			//Calculate the perimeter of the rectangle
			int peri = perimeter(x1, y1, x2, y2);
			//Compare the perimeter with the current maximum perimeter
			if (peri > max_peri) {
				max_peri = peri;
				max_peri_label = label;
			
			} 
			//Compare the perimeter with the current minimum perimeter
			if (peri < min_peri) {
				min_peri = peri;
				min_peri_label = label;
			}
			
			//Calculate the area of the rectangle
			int rect_area = area(x1, y1, x2, y2);
			//Compare the area with the current maximum area
			if (rect_area > max_area) {
				max_area = rect_area;
				max_area_label = label;
			
			}
			//Compare the area with the current minimum area
			if (rect_area < min_area) {
				min_area = rect_area;
				min_area_label = label;
			}
			
		}
		
		//Print the report
		System.out.println("Square count = " + square_count);
		System.out.println("Wide count = " + wide_count);
		System.out.println("Tall count = " + tall_count);
		System.out.println("Min perimeter = " + min_peri + " (" + min_peri_label + ")");
		System.out.println("Max perimeter = " + max_peri + " (" + max_peri_label + ")");
		System.out.println("Min area = " + min_area + " (" + min_area_label + ")");
		System.out.println("Max area = " + max_area + " (" + max_area_label + ")");
	}
	
	
	//Check whether the rectangle is square
		public static boolean isSquare(int x1, int y1, int x2, int y2) {
			//Get the length of wide side
			int wLength = Math.abs(x2 - x1);
			//Get the length of tall side
			int tLength = Math.abs(y2 - y1);
			//Check whether the wide length equals the tall length
			if (wLength == tLength) {
				return true;
			} else return false;
		}
		
		//Check whether the rectangle is wider
		public static boolean isWider(int x1, int y1, int x2, int y2) {
			//Get the length of wide side
			int wLength = Math.abs(x2 - x1);
			//Get the length of tall side
			int tLength = Math.abs(y2 - y1);
			//Check whether the wide length greater than the tall length
			if (wLength > tLength) {
				return true;
			} else return false;
		}
		
		//Calculate the perimeter of the rectangle
		public static int perimeter(int x1, int y1, int x2, int y2) {
			//Get the length of wide side
			int wLength = Math.abs(x2 - x1);
			//Get the length of tall side
			int tLength = Math.abs(y2 - y1);
			//Calculate the perimeter
			int p = 2 * (wLength + tLength);
			return p;
		}
		
		//Calculate the area of the rectangle
		public static int area(int x1, int y1, int x2, int y2) {
			//Get the length of wide side
			int wLength = Math.abs(x2 - x1);
			//Get the length of tall side
			int tLength = Math.abs(y2 - y1);
			//Calculate the area
			int a = wLength * tLength;
			return a;
		}

}
