package booking.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SiteMap {
	public static void main(String[] args) {
		File file = new File ("/Users/tasneem/workspace/tasneem/Algorithm/src/booking/com/log.txt");
		try {
			Scanner scan = new Scanner(file);
			HashMap<String, String> userMap = new HashMap<>();
			HashMap<String, HashSet<String>> siteMap = new HashMap<>();
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String [] arr = line.trim().split(",");
				if (arr != null && arr.length >= 2) {
					String user = arr[0];
					String page = arr[1];
					if (userMap.containsKey(user)) {
						if (siteMap.containsKey(userMap.get(user))) {
							siteMap.get(userMap.get(user)).add(page);
						} else {
							HashSet<String> set = new HashSet<>();
							set.add(page);
							siteMap.put(userMap.get(user), set);
						}
					}
					userMap.put(user, page);
				} else {
					System.err.println("Provide proper format such user:A,page:2 ");
				}
			}
			System.out.println(siteMap);
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
//		File file = new File("/Users/tasneem/workspace/tasneem/Algorithm/src/booking/com/log.txt");
//		HashMap<String,String> currentPageTracker = new HashMap<String,String>();
//		HashMap<String,HashSet<String>> links = new HashMap<>();
//		try {
//			Scanner input = new Scanner(file);
//			while(input.hasNextLine()) {
//				String line = input.nextLine(); 
//				String[] tokens = line.split(" ");
//				if(!currentPageTracker.containsKey(tokens[0])) {
//					currentPageTracker.put(tokens[0], tokens[1]);
//				}else{
//					String prevPage = currentPageTracker.get(tokens[0]);
//					if(links.containsKey(prevPage)){
//						links.get(prevPage).add(tokens[1]);
//					}else{
//						HashSet<String> set = new HashSet<String>();
//						set.add(tokens[1]);
//						links.put(prevPage, set);
//					}
//					currentPageTracker.put(tokens[0], tokens[1]);
//				}
//			}
//			System.out.println(links);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
