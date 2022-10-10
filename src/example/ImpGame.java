package example;

import java.util.Random;

public class ImpGame implements Game {

    static String mot_a_deviner;
    static String foundLettersList = "";
    static Integer nbChances = 3;

    public String sayHello() {
        return "Bonjour et bienvenue ! Voulez-vous débuter une partie du jeu \"Le pendu\" ?";
    }

    public Integer getNbChances(){
        return ImpGame.nbChances;
    }

    public String newHiddenWord() {
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

    public Boolean verifyLetter(String letter){
        String mot = ImpGame.mot_a_deviner;
        if (mot.indexOf(letter.charAt(0)) == -1) {
            ImpGame.nbChances = ImpGame.nbChances - 1;
            return false;
        }else{
            ImpGame.nbChances = 3;
            return true;
        }
    }

    public String foundLetters(String letter) {
        String mot = ImpGame.mot_a_deviner;
        String underscore = "";
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == letter.charAt(0) || ImpGame.foundLettersList.indexOf(mot.charAt(i)) != -1) {
                underscore = underscore + mot.charAt(i) + " ";
                if (ImpGame.foundLettersList.indexOf(mot.charAt(i)) == -1) {
                    ImpGame.foundLettersList += mot.charAt(i);
                }
            } else {
                underscore = underscore + "_ ";
            }
        }
        return underscore;
    }

}
