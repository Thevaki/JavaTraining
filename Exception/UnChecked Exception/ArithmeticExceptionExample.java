package FileReading;

public class ArithmeticExceptionExample {
	public static void main(String args[]) {
		try {
			// code that may raise exception
			int number = 100 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
	}
}
