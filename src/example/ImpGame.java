package example;

import java.util.Random;

public class ImpGame implements Game {

    static String mot_a_deviner;
    static String foundLetters = "";

    public String sayHello() {
        return "Bonjour et bienvenue ! Voulez-vous débuter une partie du jeu \"Le pendu\" ?";
    }

    public String startGame() {
        String[] mots = { "Avion", "Bateau", "Voiture", "Bouteille", "Ventilateur", "Frigo" };
        Random obj = new Random();
        int index = obj.nextInt(5);
        ImpGame.mot_a_deviner = mots[index];
        String underscore = "";
        for (int i = 0; i < mot_a_deviner.length(); i++) {
            underscore = underscore + "_ ";
        }

        return underscore;
    }

    public String verifyLetter(String letter) {
        String mot = ImpGame.mot_a_deviner;
        String underscore = "";
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == letter.charAt(0) || ImpGame.foundLetters.indexOf(mot.charAt(i)) != -1) {
                underscore = underscore + mot.charAt(i) + " ";
                if (ImpGame.foundLetters.indexOf(mot.charAt(i)) == -1) {
                    ImpGame.foundLetters += mot.charAt(i);
                }
            } else {
                underscore = underscore + "_ ";
            }
        }

        return underscore;
    }

}
