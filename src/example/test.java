package example;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String mot = "Ventilateur";
        System.out.println(mot);
        String foundLetters = "";
        String underscore = "";
        Scanner input = new Scanner(System.in);
        String letter = input.nextLine();
        System.out.println(letter);
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == letter.charAt(0) || foundLetters.indexOf(mot.charAt(i)) != -1) {
                underscore = underscore + letter.charAt(0) + " ";
                foundLetters += letter.charAt(0);
            } else {
                underscore = underscore + "_ ";
            }
        }
        System.out.println(underscore);
        
    }   
}

