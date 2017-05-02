
public class StaticTest {
	public static void main(String[] args) {
		System.out.println("1. Value : "+StaticClass.getC());
		StaticClass2 obj = new StaticClass2();
		obj.printC();
		StaticClass.setC(5);
		System.out.println("2. Value : "+StaticClass.getC());
		obj.printC();
	}

}
