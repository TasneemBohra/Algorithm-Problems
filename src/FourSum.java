import java.util.HashMap;
import java.util.HashSet;

public class FourSum {
	public static void main(String[] args) {
		String str = "/* Test program */"
				+ "int main()"
				+ "{"
				+ "// variable declaration"
				+ "int a, b, c;"
				+ "/* This is a test"
				+ "multiline"
				+ "comment for"
				+ "testing */"
				+ "a = b + c;"
				+ "}";
		boolean singleline = false;
		boolean multiline = false;
		String finalStr = "";
		for (int i = 0 ; i < str.length() - 1; i++) {
			if (multiline && str.charAt(i) == '*' && str.charAt(i + 1) == '/') {
				multiline = false;
				i++;
			} else if (singleline && str.charAt(i) == '\n') {
				singleline = false;
			} else if (singleline || multiline) {
				continue;
			} else if (str.charAt(i) == '/') {
				if (str.charAt(i + 1) == '/') {
					singleline = true;
					i++;
				} else if (str.charAt(i + 1) == '*') {
					multiline = true;
					i++;
				} 
			} else {
				finalStr = finalStr + str.charAt(i);
			}
			
		}
		
		System.out.println(finalStr);
		
		
	}
}

