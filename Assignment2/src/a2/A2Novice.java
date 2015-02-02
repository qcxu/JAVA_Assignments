package a2;

import java.util.Scanner;

public class A2Novice {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process_input(s);
	}

	public static void process_input(Scanner s) {
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
			
			Rectangle rect = new Rectangle(x1, y1, x2, y2, label);

			//Check whether the rectangle is square
			if (rect.isSquare()) {
				square_count += 1;
				//Check whether the rectangle is wider
			} else if (rect.isWide()) {
				wide_count += 1;
				//Check whether the rectangle is taller
			} else {
				tall_count += 1;
			}

			//Calculate the perimeter of the rectangle
			int peri = rect.getPerimeter();
			//Compare the perimeter with the current maximum perimeter
			if (peri > max_peri) {
				max_peri = peri;
				max_peri_label = rect.getLabel();
			}
			//Compare the perimeter with the current minimum perimeter
			if (peri < min_peri) {
				min_peri = peri;
				min_peri_label = rect.getLabel();
			}

			//Calculate the area of the rectangle
			int rect_area = rect.getArea();
			//Compare the area with the current maximum area
			if (rect_area > max_area) {
				max_area = rect_area;
				max_area_label = rect.getLabel();	
			}
			//Compare the area with the current minimum area
			if (rect_area < min_area) {
				min_area = rect_area;
				min_area_label = rect.getLabel();
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
}

