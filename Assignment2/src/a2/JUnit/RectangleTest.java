/**
 * Recitation 3 � JUNIT Testing of Assignment 2 Rectangle Class
 * 
 * @Author : KJ Moon & Brian Cristante
 * Written expressively for COMP 401 Spring 2015 w/ Dr. Ketan Mayer-Patel
 */

package a2.JUnit;
import a2.Rectangle;

import static org.junit.Assert.*;
import org.junit.Test;

public class RectangleTest {
	
	@Test
	// This one is done for you as a model
	public void testConstructor1() {
		// Unit under test
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2,  "uut");
		
		// Expected values
		int left_expected   = 0;  int right_expected = 10;
		int bottom_expected = 0;  int top_expected   = 10;
		
		// Call your methods to get their actual values
		int left_actual   = uut.getLeft();  
		int right_actual  = uut.getRight();
		int bottom_actual = uut.getBottom();  
		int top_actual    = uut.getTop();
		
		// Check the outputs against what you expected
		assertEquals(left_expected,   left_actual);
		assertEquals(right_expected,  right_actual);
		assertEquals(bottom_expected, bottom_actual);
		assertEquals(top_expected,    top_actual);
	}
	
	@Test
	public void testConstructor2() {
		// Unit under test
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;
		Rectangle uut = new Rectangle(x2, y2, x1, y1, "uut");
		
		/* This is the same Rectangle as in testConstructor1(), 
		 * but the points have been given in a different order.
		 * 
		 * TODO fill in the test below to make sure your constructor still works!
		 */
		
		
		// Expected values
//		TODO Highlight and Ctrl+/ to un-comment this code and fill it in
		int left_expected   = 0;  int right_expected = 10;
		int bottom_expected = 0;  int top_expected   = 10;
		
		// Call your methods to get their actual values
		int left_actual   = uut.getLeft();  
		int right_actual  = uut.getRight();
		int bottom_actual = uut.getBottom();  
		int top_actual    = uut.getTop();
		
		// TODO Check the outputs against what you expected
		assertEquals(left_expected,   left_actual);
		assertEquals(right_expected,  right_actual);
		assertEquals(bottom_expected, bottom_actual);
		assertEquals(top_expected,    top_actual);
		
		//fail();  // TODO remove this when you've finished this test
	}
	
	@Test
	public void testConstructor3() {
		// Unit under test
		int x1 =  0;  int y1 = 10;
		int x2 = 10;  int y2 =  0;
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		// Expected values
		int left_expected   = 0;  int right_expected = 10;
		int bottom_expected = 0;  int top_expected   = 10;
		
		// Call your methods to get their actual values
		int left_actual   = uut.getLeft();  
		int right_actual  = uut.getRight();
		int bottom_actual = uut.getBottom();  
		int top_actual    = uut.getTop();
		
		// Check the outputs against what you expected
		assertEquals(left_expected,   left_actual);
		assertEquals(right_expected,  right_actual);
		assertEquals(bottom_expected, bottom_actual);
		assertEquals(top_expected,    top_actual);
	}
	
	@Test
	public void testGetWidth1() {
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		int expected_width = 10;
		assertEquals(expected_width, uut.getWidth());		
	}
	
	@Test
	public void testGetWidth2() {
		int x1 = - 5;  int y1 = 0;
		int x2 = -10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		int expected_width = 5;
		assertEquals(expected_width, uut.getWidth());			
	}
	
	@Test
	public void testGetHeight() {
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		int expected_height = 10;
		assertEquals(expected_height, uut.getHeight());	
	}
	
	@Test
	public void testEquals() {
		// TODO You're on your own for this one!
		int x1 = 10;  int y1 = 20;
		int x2 = 10; int y2 = 10;
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		int x3 = 5;  int y3 = 10;
		int x4 = 10; int y4 = 20;
		Rectangle uub = new Rectangle(x4, y4, x3, y3, "uutb");
		
		//assertTrue(uut.equals(uub));
		assertFalse(uut.equals(uub));
	}
	
	@Test
	public void testIsTall() {
		int x1 = -5;  int y1 = -15;
		int x2 =  5;  int y2 =   0;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		assertTrue(uut.isTall());
		assertFalse(uut.isWide());
		assertFalse(uut.isSquare());
	}
	
	@Test
	public void testIsWide() {
		// TODO You're on your own for this one!
		int x1 = -10;  int y1 = -10;
		int x2 =  5;  int y2 =   0;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		assertTrue(uut.isWide());
		assertFalse(uut.isTall());
		assertFalse(uut.isSquare());
	}
	
	@Test
	public void testIsSquare() {
		// TODO You're on your own for this one!
		int x1 = -5;  int y1 = -10;
		int x2 =  5;  int y2 =   0;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		assertTrue(uut.isSquare());
		assertFalse(uut.isWide());
		assertFalse(uut.isTall());
	}
}