package FileReading;

public class NullPointer {
	public static void main(String args[]) {
		try {
			// code that may raise exception
			String s = null;
			System.out.println(s.length());// NullPointerException
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
	}
}
