package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice2_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer[] array = new Integer[5];
		Integer nB;
		// Scanner
		Scanner saisie = new Scanner(System.in);
		System.out.println("Veuillez entrer 5 nombres dans le tableau :");
		for (int i = 0; i < array.length; i++) {
			nB = saisie.nextInt();
			array[i] = nB;
		}
		for (Integer value : array) {
			System.out.println(value);
		}

	}

}
