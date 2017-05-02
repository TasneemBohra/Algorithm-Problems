package booking.com;

import java.util.Scanner;

public class TrieSolution {
	class Node {
		char key;
		Node[] children = new Node[26];
		boolean leaf;
	}
	
	class Trie {
		Node root = new Node();
		
		/**
		 * O(NM)
		 * Create trie for the String Line
		 * @param str
		 */
		public void createTrie(String str) {
			String word = "";
			for (int i = 0; i < str.length(); i ++) {
				char c = str.charAt(i);
				if (c == ' ') {
					addNode(word);
					word = "";
				} else {
					word = word + c;
				}
			}
			
			if (word != "") {
				addNode(word);
			}
		}
		
		/**
		 * Add node to trie for the word
		 * @param word 
		 */
		public void addNode(String word) {
			Node temp = root;
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';
				System.out.println("addNode - index : "+index+" char "+word.charAt(i));
				if (temp.children[index] == null) {
					//insert
					Node child = new Node();
					child.key = word.charAt(i);
					temp.children[index] = child;
					temp = child;
				} else {
					temp = temp.children[index];
				}
			}
			temp.leaf = true;
		}
		
		public void findWord(String word) {
			Node temp = root;
			int i = 0;
			while (i < word.length()) {
				char c = word.charAt(i);
				int index = c - 'a';
				Node n = temp.children[index];
				if (n == null) break;
				temp = n;
				i++;
			}
			if (temp.leaf) System.out.println("Found"); else System.out.println("NOPE");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String word = scan.next();
		scan.close();
		line = line.toLowerCase();
		Trie trie = new TrieSolution().new Trie();
		trie.createTrie(line);
		
		trie.findWord(word);
		
		
	}
	
	
}
