
public class PrintJSOn {
	 public static void main(String[] args) {
		 String str = "{id: 0001,type: donut,name:Cake,ppu: 0.55,"
		 		+ "batters:{batter:[{ id: 1001, type: Regular },{ id: 1002, type: Chocolate }]},"
		 				+ "topping:[{ id: 5001, type: None },{ id: 5002, type: Glazed }]}";
		System.out.println(generate(str));
	 }
	 
	 private static String generate(String jsonString) {
		 StringBuilder builder = new StringBuilder();
		 StringBuilder spaces = new StringBuilder();
		 
		 for (int i = 0; i < jsonString.length(); i ++) {
			 char c = jsonString.charAt(i);
			 switch (c) {
			 	case '{' :
			 		spaces.append(' ');
			 		builder.append(c).append('\n').append(spaces);
			 		break;
			 	case '[' :
			 		spaces.append('\t');
			 		builder.append(c).append('\n').append(spaces);
			 		break;
			 	case ']' :
			 		builder.append('\n').append(spaces).append(c);
			 		spaces.deleteCharAt(spaces.length()-1);
			 		break;
			 	case '}' : 
			 		spaces.deleteCharAt(spaces.length()-1);
			 		builder.append('\n').append(spaces).append(c);
			 		break;
			 	case ',':
			 		builder.append(c).append('\n').append(spaces);
			 		break;
			 	default :
			 		builder.append(c);
			 }
		 }
		 
		 return builder.toString();
	 }
}
