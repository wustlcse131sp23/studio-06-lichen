package studio6;

import java.util.function.IntPredicate;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
		if (n == 0) {
			return 0;
		}else {
			return 1/Math.pow(2, n) + geometricSum(n-1);
		}
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q==0) {
			return p;
		}else {
			int temp = q;
			q = p % q;
			p = temp;
			return gcd(p, q);
		}
		
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
		int[] temp = new int[array.length];
		if (array.length==0) {
			return temp;
		}else if(array.length == 1) {
			temp[0] = array[0];
			return temp;
		}
		else {
			return updateReversed(array, temp, 0);
		}
		
	}
	public static int[] updateReversed(int[] array, int[] temp, int index) {
		if (index == array.length) {
			return temp;
		}else {
			temp[index] = array[array.length-index-1];
			return updateReversed(array, temp, index+1);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(xCenter, yCenter, radius);
		if (radius>radiusMinimumDrawingThreshold*3) {
			circlesUponCircles(xCenter, yCenter + radius, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter + radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
		}
	}

}
