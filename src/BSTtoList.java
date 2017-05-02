
public class BSTtoList {
	public static void main(String[] args) {
		combination("1123");
	}
	
	private static void combination(String str) {
		// Char array initialization
		char arr [] = new char[26];
		for (int i = 0 ; i < 26; i ++) {
			arr[i] = (char)(97 + i);
		}
		
		
		for (int i = 0 ; i < str.length(); i ++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0 ; j < str.length(); j++) {
				int index = (int)str.charAt(i) - '1';
				if (index >= 0 && index <= 25) {
					builder.append(arr[(int)str.charAt(j) - '1']);
				}
			}
			System.out.println(builder.toString());
		}
		
		
	}
	
	
	private static Node treeToList(Node root) {
		return root;
	}
}

class Node {
	int val;
	Node next;
	Node prev;
	
	public Node(int val, Node next, Node prev) {
		this.val = val;
		setNext(next);
		setPrev(prev);		
	}
	
	public void setNext(Node node) {
		if (node != null) {
			this.next = node;
			node.setPrev(this);
		}
	}
	
	public void setPrev(Node node) {
		if (node != null) {
			this.prev = node;
			node.setNext(this);
		}
	}
}

class TreeNode {
	
}
