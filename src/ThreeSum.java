import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {
	
	private class ThreeSumSlow {
		int count(int[] a) {
			int count = 0;
			int length = a.length;
			for (int i = 0; i < length; i++) {
				for (int j = i+1; j< length ; j++) {
					for (int k = j+1 ; k< length ; k++) {
						if (a[i]+a[j]+a[k] == 0) {
							count ++;
						}
					}
				}
			}
			return count;
		}
	}
	
	private class ThreeSumFast {
		int count(int[] a) {
			int count = 0;
			int n = a.length;
			//Sort array
			Arrays.sort(a);
			 if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
			 for (int i = 0; i < n; i++) {
		            for (int j = i+1; j < n; j++) {
		                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
		                if (k > j) count++;
		            }
		        }
			return count;
		}
		
		// returns true if the sorted array a[] contains any duplicated integers
	    private boolean containsDuplicates(int[] a) {
	        for (int i = 1; i < a.length; i++)
	            if (a[i] == a[i-1]) return true;
	        return false;
	    }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int [] arr = new int[size];
		for (int i = 0; i<size ; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		System.out.println("Triplets : "+new ThreeSum().new ThreeSumSlow().count(arr));
		
	}
}
