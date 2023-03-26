package Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Credit_card_validat {
	long cardNumber = 0;
	int arr[];
	String cardName;

	public void crd_No() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Place Enter Debit card Number : ");
		try {
			cardNumber = sc.nextLong();
			total_No();
		} catch (InputMismatchException e) {

			System.out.println("Place enter must Number : ");
		}

	}

	public void total_No() {
		int count = 0;
		long num = cardNumber;

		while (num > 0) {
			num = num / 10;
			count++;
		}

		System.out.println("card total number :  " + count);

		arr = new int[count];

		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = (int) (cardNumber % 10);
			cardNumber = cardNumber / 10;
		}

		System.out.println("");

		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println("");
		// validation();
		cardType();
	}

	public void cardType() {
		int cardLength = arr.length;

		switch (cardLength) {
		case 13:
			if (arr[0] == 4) {
				cardName = "VISA";
				validation();
			} else {
				System.out.println("Card number is Invalid");
			}
			break;
		case 16:
			if (arr[0] == 4) {
				cardName = "VISA";
				validation();
			} else if (arr[0] == 5 && arr[1] == 1 || arr[0] == 5 && arr[1] == 2 || arr[0] == 5 && arr[1] == 3
					|| arr[0] == 5 && arr[1] == 4 || arr[0] == 5 && arr[1] == 5) {
				cardName = "Master ";
				validation();
			} else if (arr[0] == 6 && arr[1] == 0 || arr[0] == 6 && arr[1] == 5 || arr[0] == 8 && arr[1] == 1
					|| arr[0] == 8 && arr[1] == 2 || arr[0] == 5 && arr[1] == 0 && arr[2] == 8) {
				cardName = "Rupay";
				validation();
			} else {
				System.out.println("Card number is Invalid");
			}
			break;
		case 15:
			if (arr[0] == 3 && arr[1] == 4 || arr[0] == 3 && arr[1] == 7) {
				cardName = "American Express";
				validation();
			} else {
				System.out.println("Card number is Invalid");
			}

		}

	}

	public void validation() {

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = arr[i] * 2;
				// System.out.println(arr[i]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			if (arr[i] >= 10) {
				sum = (int) (arr[i] % 10 + arr[i] / 10);
				arr[i] = sum;
			}
			// System.out.println(arr[i]);
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {

			sum = (int) (arr[i] + sum);
		}

		System.out.println("\n" + "sum of card number :  " + sum);

		if (sum % 10 == 0) {

			System.out.println("\n" + cardName + " card valid ");

		} else {

			System.out.println("\n" + "invalid");

		}
	}

	public static void main(String[] args) {
		Credit_card_validat oo = new Credit_card_validat();
		oo.crd_No();
		// oo.total_No();
		// oo.validation();
	}

}
