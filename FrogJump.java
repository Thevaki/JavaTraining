package FileReading;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FrogJump{
	public static void main(String[] args) {
		validateInput();
	}

	public static void FindDistance() {
		int D5 = 0;
		int D3 = 0;
		int D1 = 0;

		System.out.println("Enter the distance");

		Scanner sc = new Scanner(System.in);
		int inputDistance = sc.nextInt();
		int remaining = inputDistance % 9;
		D5 = inputDistance / 9;
		D3 = inputDistance / 9;
		D1 = inputDistance / 9;

		if (remaining <= 5) {
			D5++;
		} else if (remaining <= 8) {
			D5++;
			D3++;
		}
		/*System.out.println("D5 " + D5);
		System.out.println("D3 " + D3);
		System.out.println("D1 " + D1);*/

		int totalTime = (D5 * 1) + (D3 * 2) + (D1 * 5);
		System.out.println("Total time taken to reach " + inputDistance + "m is " + totalTime + "s");
	}

	public static void FindTime() {

		int T1 = 0;
		int T2 = 0;
		int T5 = 0;

		System.out.println("Enter the Time");

		Scanner sc = new Scanner(System.in);
		int inputTime = sc.nextInt();
		int remaining = inputTime % 8;
		T1 = inputTime / 8;
		T2 = inputTime / 8;
		T5 = inputTime / 8;

		if (remaining == 1) {
			T1++;
		} else if (remaining == 2) {
			T1++;
			T2++;
		} else if (remaining > 2) {
			T1++;
			T2++;
			T5++;
		}
		/*System.out.println("T1 " + T1);
		System.out.println("T2 " + T2);
		System.out.println("T5 " + T5);*/

		int totalDistance = (T1 * 5) + (T2 * 3) + (T5 * 1);
		System.out.println("John can go " + totalDistance + "m in " + inputTime + "s");
	}

	public static void validateInput() {
		boolean error = false;
		int inputNumber = 0;
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Press 1 to input the distance");
				System.out.println("Press 2 to input the travelled time");
				inputNumber = scanner.nextInt();
				if (inputNumber == 1 || inputNumber == 2) {
					error = false;
				} else {
					System.out.println("Invalid Input");
					error = true;
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid Input..Pls Input Integer Only..");
				error = true;
			} catch (Exception ex) {
				System.out.println("Invalid Input..Pls Input Integer Only..");
				error = true;
			}
		} while (error);

		switch (inputNumber) {
		case 1:
			FindDistance();
			break;
		case 2:
			FindTime();
			break;

		// default:System.out.println("Error. Please press 1 or 2");
		}
	}

}
