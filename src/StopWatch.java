import java.util.Scanner;

public class StopWatch {
	
	private final long start;
	
	public StopWatch() {
		start = System.currentTimeMillis();
	}
	
	public double stopWatch() {
		return System.currentTimeMillis() - start;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter n :");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		
		
		StopWatch timer1 = new StopWatch();
		double sqrt = 1;
		for (int i = n-1; i >= 0; i--) {
			sqrt*=2;
		}
		System.out.println("Power : " + sqrt);
		System.out.println(timer1.stopWatch());
		 
		StopWatch timer2 = new StopWatch();
		sqrt = Math.pow(3, n);
		System.out.println("Power : "+ sqrt);
		System.out.println(timer2.stopWatch()); 
		
		
		StopWatch timer3 = new StopWatch();
		sqrt = 1;
		for (int i = 0; i < n; i++) {
			sqrt*=4;
		}
		System.out.println("Power : " + sqrt);
		System.out.println(timer3.stopWatch());
		
	}
	

}
