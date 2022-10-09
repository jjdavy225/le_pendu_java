package example;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String[] mots = {"Avion","Bateau","Voiture"};
        Random obj = new Random();
        int index = obj.nextInt(3);
        String mot_a_deviner = mots[index];
        System.out.println(mot_a_deviner);
        
    }   
}

