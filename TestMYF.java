package Assignment5;

import java.util.Scanner;

public class TestMYF {
	public static void main(String[] args) {
		final int factor = 5;
		int num;
		Scanner keyboard = new Scanner(System.in);
		MyFunctionalInterface fiveMore = x -> x + factor;
		System.out.printf("Please enter an integer: ");
		num = keyboard.nextInt();
		System.out.printf("The integer %d incremented by 5 is %d\n", num, fiveMore.incrementByFive(num));
		System.out.printf("Please enter an integer: ");
		num = keyboard.nextInt();
		System.out.printf("The integer %d incremented by 5 is %d\n", num, fiveMore.incrementByFive(num));
		System.out.printf("Please enter an integer: ");
		num = keyboard.nextInt();
		System.out.printf("The integer %d incremented by 5 is %d\n", num, fiveMore.incrementByFive(num));
		keyboard.close();
	}

}
