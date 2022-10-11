package example;

import java.util.Random;

public class ImpGame implements Game {

    private String mot_a_deviner;
    private String foundLettersList = "";
    private Integer nbChances = 3;

    public String sayHello() {
        return "Bonjour et bienvenue ! Voulez-vous débuter une partie du jeu \"Le pendu\" ?";
    }

    public Void restart() {
        this.foundLettersList = "";
        this.nbChances = 3;

        return null;
    }

    public Integer getNbChances() {
        return this.nbChances;
    }

    public String newHiddenWord() {
        String[] mots = { "Avion", "Bateau", "Voiture", "Bouteille", "Ventilateur", "Frigo" };
        Random obj = new Random();
        int index = obj.nextInt(5);
        this.mot_a_deviner = mots[index];
        String underscore = "";
        for (int i = 0; i < this.mot_a_deviner.length(); i++) {
            underscore = underscore + "_ ";
        }

        return underscore;
    }

    public Integer verifyLetter(String letter) {
        String mot = this.mot_a_deviner;
        if (mot.toLowerCase().indexOf(letter.toLowerCase().charAt(0)) == -1) {
            this.nbChances = this.nbChances - 1;
            return 0;
        }else if(this.foundLettersList.toLowerCase().indexOf(letter.toLowerCase().charAt(0)) != -1){
            return 1;
        } else {
            this.nbChances = 3;
            return 2;
        }
    }

    public String foundLetters(String letter) {
        String mot = this.mot_a_deviner;
        String underscore = "";
        for (int i = 0; i < mot.length(); i++) {
            if (mot.toLowerCase().charAt(i) == letter.toLowerCase().charAt(0)
                    || this.foundLettersList.indexOf(mot.charAt(i)) != -1) {
                underscore = underscore + mot.charAt(i) + " ";
                if (this.foundLettersList.indexOf(mot.charAt(i)) == -1) {
                    this.foundLettersList += mot.charAt(i);
                }
            } else {
                underscore = underscore + "_ ";
            }
        }
        return underscore;
    }

}
