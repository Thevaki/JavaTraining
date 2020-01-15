
public class PrintMathTable{
	public static void main(String[] args) {
		
		System.out.printf("  ");
		for (int i = 1; i <= 9; i++) {
		System.out.printf("%5s",i);
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%2s",i + " |");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%5s",i * j + " ");
			}
			System.out.println();
		}
	}
}
