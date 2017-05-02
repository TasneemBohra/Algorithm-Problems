
public class QuickUnion {
	private static int [] arr = {0,1,2,3,4,5,6,7,8,9};
	
	private static boolean ifConnecte(int p, int q) {
		return root(p) == root(q);
	}
	
	private static int root(int i) {
		while (arr[i] != i) {
			i = arr[i];
		}
		return i;
	}
	
	private static void union (int p, int q) {
		if (!ifConnecte(p, q)) {
			int pRoot = root(p);
			int qRoot = root(q);
			arr[pRoot] = qRoot; 
		}
	}
	
	public static void main(String[] args) {
		union (3,4);
	}
	
}
