import java.util.Scanner;

public class Diamond{

	public static void main(String[] args) {

		int n = 9;
		int gap = n - 1;

		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= gap; i++) {
				System.out.print(" ");
			}
			gap--;
			for (int i = 1; i <= 2 * j - 1; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		gap = 1;
		for (int j = 1; j <= n - 1; j++) {
			for (int i = 1; i <= gap; i++) {
				System.out.print(" ");
			}
			gap++;
			for (int i = 1; i <= 2 * (n - j) - 1; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
