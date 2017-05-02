package booking.com;

import java.util.Scanner;

public class PerfectSquar {
	static int count = 1;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.close();
		
	sqrt(a);
	
	System.out.println("Total : "+count);
	}
	
	private static void sqrt(int a) {
		int sqrt = (int)Math.sqrt(a);
		int temp = a - sqrt*sqrt;
		System.out.println("Number : "+sqrt*sqrt+" Sqrt : "+sqrt + " Diff : "+temp);
		if (temp == 0) {
			System.out.println("Final : 1");
		} else {
			count ++;
			sqrt(temp);
		}
	}
}
