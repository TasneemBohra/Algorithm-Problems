package techgig;

import java.util.Scanner;

public class LargestIncreasingSequence {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int totalWords = scan.nextInt();
//		String str = null;
//		int i = 0;
//		while (i < totalWords) {
//			String str2 = longestIncreasingSubsequence(scan.next());
//			if (str == null) {
//				str = str2;
//			} else if (str.length() < str2.length()) {
//				str = str2;
//			}
//			i++;
//		}
//		scan.close();
//		
//		System.out.println("Max :"+str);
		System.out.println(longestIncreasingSubsequenceLength("abcbcbcd"));
		
	}
	
	 public static int longestIncreasingSubsequenceLength(String str) {
	        // Add boundary case, when array size is one
	 
	        char[] tailTable   = new char[str.length()];
	        int len; // always points empty slot
	 
	        tailTable[0] = str.charAt(0);
	        len = 1;
	        for (int i = 1; i < str.length(); i++){
	            if (str.charAt(i) < tailTable[0])
	                // new smallest value
	                tailTable[0] = str.charAt(i);
	 
	            else if (str.charAt(i) > tailTable[len-1])
	                // A[i] wants to extend largest subsequence
	                tailTable[len++] = str.charAt(i);
	 
	            else
	                // A[i] wants to be current end candidate of an existing
	                // subsequence. It will replace ceil value in tailTable
	                tailTable[CeilIndex(tailTable, -1, len-1, str.charAt(i))] = str.charAt(i);
	        }
	 
	        return len;
	    }
	 
	 	// Binary search (note boundaries in the caller) A[] is ceilIndex in the caller
	    public static int CeilIndex(char A[], int l, int r, char key) {
	        while (r - l > 1) {
	            int m = l + (r - l)/2;
	            if (A[m]>=key)
	                r = m;
	            else
	                l = m;
	        }
	 
	        return r;
	    }
	
	public static String longestIncreasingSubsequence(String input1) {
		int dp[] = new int[input1.length()];
        int i,j,max = 0;
        StringBuilder str = new StringBuilder();

        /* Initialize LIS values for all indexes */
         for ( i = 0; i < input1.length(); i++ )
            dp[i] = 1;

         /* Compute optimized LIS values in bottom up manner */
         for ( i = 1; i < input1.length(); i++ )
            for ( j = 0; j < i; j++ ) 
                  if (input1.charAt(i) >= input1.charAt(j) && dp[i] < dp[j]+1)
                	  dp[i] = dp[j] + 1;

         /* Pick maximum of all LIS values */
         for ( i = 0; i < input1.length(); i++ ) {
            if ( max < dp[i] ) {
            	 max = dp[i];
            	 if (i + 1 < input1.length() && max == dp[i+1] && input1.charAt(i+1) < input1.charAt(i)) {
            		 str.append(input1.charAt(i+1));
            		 i++;
            	 } else {
            		 str.append(input1.charAt(i)); 
            	 }
            }
         }
         return str.toString();
    }
}
