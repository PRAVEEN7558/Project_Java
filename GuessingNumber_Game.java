package Project;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingNumber_Game {

	Scanner sc = new Scanner(System.in);
	int range;
	int randomArray[];
	int userNumber;

	public void randomInput() {
		try {
			range = sc.nextInt();
		} catch (InputMismatchException a) {
			System.out.println("Pls enter Number must ");
		}

		Random RandomNumber = new Random();
		randomArray = new int[range];

		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = RandomNumber.nextInt(1, 9);
		}

		for (int j = 0; j < randomArray.length; j++) {
			//System.out.print(randomArray[j] + " ");
		}

		System.out.println(" ");
	}

	public void userInput() {
		System.out.println("enter the user input : ");
		Scanner sc = new Scanner(System.in);
		try {
			userNumber = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Pls must enter the number ");
			userInput();
		}
		int userArray[] = new int[range];
		int index = userArray.length - 1;
		while (userNumber > 0) {
			userArray[index] = userNumber % 10;

			userNumber /= 10;
			index--;
		}
		char aa[] = new char[range];

		int u = 0;
		for (int j = 0; j < userArray.length; j++) {
			for (u = j; u < randomArray.length; u++) {
				if (userArray[j] == randomArray[u] && j == u) {
					aa[j] = 'c';
					break;
				}
			}
		}

		for (int j = 0; j < userArray.length; j++) {
			if (aa[j] != 'c') {
				for (u = 0; u < randomArray.length; u++) {

					if (userArray[j] == randomArray[u] && aa[u] != 'c') {
						aa[j] = 'p';

						break;
					}
				}

				if (u == userArray.length && aa[j] != 'c') {
					aa[j] = 'x';
				}
			}
		}
		boolean flag = true;

		for (int j = 0; j < aa.length; j++) {
			if (aa[j] != 'c')
				flag = false;
		}
		if (flag == false) {

			for (int j = 0; j < aa.length; j++) {
				System.out.print(aa[j] + " ");
			}
			System.out.println(" ");
			userInput();
		} else {
			for (int j = 0; j < aa.length; j++) {
				System.out.print(aa[j] + " ");
			}
			System.out.println("Your Guessing Number is correct");
		}
	}

	public static void main(String[] args) {
		GuessingNumber_Game obj = new GuessingNumber_Game();
		System.out.println("c--->Correct Number & Position same");
		System.out.println("p--->Correct Number & Position Not same");
		System.out.println("x--->wrong Number");
		System.out.println("Pleace enter the Range Number 1 to 9 ");
		obj.randomInput();
		obj.userInput();

	}
}