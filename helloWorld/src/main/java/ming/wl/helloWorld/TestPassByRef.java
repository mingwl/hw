package ming.wl.helloWorld;

public class TestPassByRef {

	public static void main(String[] args) {
		Dog aDog = new Dog("Max");
		foo(aDog);

		if (aDog.getName().equals("Max")) { // true
			System.out.println("Java passes by value.");

		} else if (aDog.getName().equals("Fifi")) {
			System.out.println("Java passes by reference.");
		}
	}

	public static void foo(Dog d) {
		d.getName().equals("Max"); // true

		d = new Dog("Fifi");
		d.getName().equals("Fifi"); // true
	}

}
