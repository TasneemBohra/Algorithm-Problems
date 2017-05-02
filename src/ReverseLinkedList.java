
public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(0);
		head = initialize(head);
		print(head);
		System.out.println();
		LinkedNode stackTop = createStackLinked(head, null);
		print(stackTop);
		
		
	}
	
	private static LinkedNode initialize (LinkedNode head) {
		LinkedNode firstNode = head;
		for (int i = 1; i <= 5; i++) {
			LinkedNode secondNode = new LinkedNode(i);
			firstNode.next = secondNode;
			firstNode = secondNode;
		}
		return head.next;
	}
	
	private static void print(LinkedNode head) {
		LinkedNode node = head;
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
			if (node != null) {
				System.out.print(" -> ");
			}
		}
	}
	
	private static LinkedNode createStackLinked(LinkedNode head, LinkedNode top) {
		if (head == null) {
			return top;
		}
		
		LinkedNode node = new LinkedNode(head.val);
		node.next = top;
		return createStackLinked(head.next, node);
	}
}

class LinkedNode {
	int val;
	LinkedNode next;
	
	public LinkedNode(int val) {
		this.val = val;
	}
}


