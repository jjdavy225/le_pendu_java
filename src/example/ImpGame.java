package example;

import java.util.Random;

public class ImpGame implements Game {

    public String sayHello() {
        return "Bonjour et bienvenue ! Voulez-vous débuter une partie du jeu \"Le pendu\" ?";
    }

    public String startGame() {
        String[] mots = {"Avion","Bateau","Voiture","Bouteille","Ventilateur","Frigo"};
        Random obj = new Random();
        int index = obj.nextInt(5);
        String mot_a_deviner = mots[index];
        
        
        return mot_a_deviner;
    }
    
}
