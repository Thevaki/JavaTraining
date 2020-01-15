package FileReading;

public class NumberFormat {
	public static void main(String args[]) {
		try {
			// code that may raise exception
			String s="abc";  
			int i=Integer.parseInt(s);//NumberFormatException  
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
	}
}
