package booking.com;

import java.util.Arrays;

public class Checkin {
	public static void main(String[] args) {
		int A[] = {1,2,10,5,5};
		int B[] = {4,5,12,9,12};
		
		// Sort array with days 
		Arrays.sort(A); //{1,2,5,5,10};
		Arrays.sort(B); // {4,5,9,12,12};
		
		int count = 0;
		int i = 0;
		int j = 0;
		int max = 0;
		int day = A[0];
		
		if (A[A.length - 1] < B[0]) { day = A[A.length - 1]; }
		else {
			while (i < A.length && j < B.length) {
				if (A[i] <= B[j]) {
					count ++;
					if (max < count) {
						max = count;
						day = A[i];
					}
					i ++;
				} else {
					count --;
					j ++;
				}
			}
		}
		
		//System.out.println(day);
		
		loginLogout();
	}
	
	
	private static void loginLogout() {
		int A[] = {1, 3, 1, 123123123, 1};
		int B[] = {3, 4, 2, 987987987, 3};
		
		Arrays.sort(A); // {1,1,1,3,123123123}
		Arrays.sort(B); // {2,3,3,4,987987987}
	
		
		int count = 0;
		int i = 0;
		int j = 0;
		int max = 0;
		
		while (i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				count ++;
				i ++;
				if (max < count) {
					max = count;
				}
				System.out.println("Max value "+max);
			}  else {
				count --;
				j++;
			}
		}
		
		System.out.println(max);
		
	}
}
