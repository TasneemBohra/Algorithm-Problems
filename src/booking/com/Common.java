package booking.com;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

public class Common {
	public static void main(String[] args) {

		int a[] = {6, 2, 2, 0, 4};
		int b[] = {5, 0, 2, 6, 7, 1};
		int c[] = {6, 7, 9, 9};

		//{2, 0, 7}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n = 0; n < a.length; n++) {
			map.put(a[n], 1);
		}
		
		for (int n = 0; n < b.length ; n ++) {
			if (map.containsKey(b[n])) {
				map.put(b[n], map.get(b[n])+1);
			} else map.put(b[n], 1);
		}
		
		for (int n  = 0; n < c.length; n++) {
			if (map.containsKey(c[n])) {
				map.put(c[n], map.get(c[n])+1);
			} else map.put(c[n], 1);
		}
		
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 2) {
				System.out.println(entry.getKey());
			}
		}
	}
	
}
