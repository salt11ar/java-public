package count;

import java.util.Scanner;

public class CountWordsWithoutUsingMethods {

    public static int countWords(String str) {
		char SPACE = ' ';
		int countWords = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == SPACE) {
				countWords++;
			}
		}

		return countWords;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sentence");
		String str = sc.nextLine();
		System.out.println(countWords(str));
		sc.close();
 	}

}