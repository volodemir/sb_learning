package Task3_2;

import java.beans.FeatureDescriptor;
import java.util.Scanner;

public class CalcLetterFreq {
    private static String alphabet;

    public CalcLetterFreq(String alphabet) {
        this.alphabet = alphabet;
    }

    public static void main(String[] args) {

        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int [] alphabet_num = new int [26];
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String inputLine = sc.nextLine();
        System.out.println("Будем считать буквы в строке: " + inputLine);
        inputLine = inputLine.toUpperCase();
        sc.close();

        for (int i = 0; i < alphabet.length(); i++) {
            for (char ch : inputLine.toCharArray()) {
                if (alphabet.charAt(i) == ch){
                    alphabet_num[i] ++;
                }
            }
            System.out.println("Буква " + alphabet.charAt(i) + " повторяется в тексте " + alphabet_num[i] + " раз(а)");
        }
    }
}
