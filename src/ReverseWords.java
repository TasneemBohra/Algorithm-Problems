import java.util.Stack;

public class ReverseWords {
	public static void main(String[] args) {
		char a[] = {'T','a','s',' ','b','o','h', ' ', '1', '2'};
		StringBuilder builder = new StringBuilder();
		int index = 0;
		for (int i = a.length-1; i >= 0 ; i-- ) {
			if (a[i] != ' ') {
				builder.insert(index, a[i]);
			} else {
				builder.append(" ");
				index = builder.length();
			}
		}
		System.out.println(builder.toString());
	}
}
