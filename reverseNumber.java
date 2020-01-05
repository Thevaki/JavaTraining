import java.util.Scanner;

public class reverseNumber{
	public static void main (String[] args){
		System.out.println("Input the number you want to reverse");

		Scanner sc = new Scanner(System.in);
		long inputNum = sc.nextInt();

		long reverseNum = 0;

		while(inputNum != 0){
			long num = inputNum % 10;
			reverseNum = (reverseNum * 10) + num;
			inputNum /= 10;
		}
	
		System.out.println("Reversed Number: " + reverseNum);

	}
}