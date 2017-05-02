package booking.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
	
	public static void main (String[] args) throws java.lang.Exception {
        String arr [] = {"aca", "hello", "world", "cat", "sdb", "acacabcatghhellomvnsdb"};
        String input = "acacabcatghhellomvnsdb";
        
        HashMap<String, Integer> map = new HashMap<>();
        // put all words into map - O(l)
        for (int i  = 0 ; i < arr.length; i ++) {
            map.put(arr[i], 0);
            int len = arr[i].length();
            int j = input.indexOf(arr[i].charAt(0));
            while (j < input.length()) {
                try {
                    String str = input.substring(j, len+j);
                    if (str.equals(arr[i])) {
                        map.put(str, map.get(str) + 1);
                    }
                    
                } catch(StringIndexOutOfBoundsException e) {

                }
                j++;
            } 
        }
        
        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i] + " : " + map.get(arr[i]));
        }
        
    }
	
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String line = scan.nextLine();
//		ArrayList<String> arr =  new ArrayList<>();
//		int i = 0;
//		while (i < 4)  {
//			arr.add(scan.next());
//			i++;
//		}
//		scan.close();
//		for (String string : arr) {
//			findWord(line, string);	
//		}
//		
//	}
//	
//	private static void findWord(String line, String word) {
//		int l = word.length();
//		int count = 0; 
//		for (int i = 0; i < line.length(); i ++) {
//			for (int j = 0; j < word.length() && i+j < line.length(); j ++) {
//				char c1 = word.charAt(j);
//				char c2 = line.charAt(i+j);
//				if (c1 == c2) {
//					l -- ;
//				} else {
//					break;
//				}
//			}
//			if (l == 0) count ++;
//			l = word.length();
//		}
//		
//		System.out.println(word + " : " +count);
//	}
}
