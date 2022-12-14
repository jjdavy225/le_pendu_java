package example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {
    }

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("192.168.97.86",1099);
            Game server = (Game) registry.lookup("Game");
            server.restart();
            String response = server.sayHello();
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Serveur: " + response);
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Répondez par oui ou non !");
            String ans = input.nextLine();
            while (ans.toLowerCase().equals("oui") || ans.toLowerCase().equals("o")) {
                String newHiddenWord = server.newHiddenWord();
                Integer nb_chances = server.getNbChances();
                System.out.println();
                System.out.println("Vous avez " + nb_chances + " chances restantes pour deviner le mot du jour");
                System.out.println("Mot à deviner : " + newHiddenWord);
                String foundLetters = "";
                Boolean endGame = true;

                while (nb_chances > 0 && endGame) {
                    String letter = input.nextLine();
                    while (letter.length() > 1) {
                        System.out.println();
                        System.out.println("Veuillez rentrer une seule lettre à la fois");
                        letter = input.nextLine();
                    }
                    nb_chances = server.getNbChances();
                    foundLetters = server.foundLetters(letter);
                    Integer verifyLetter = server.verifyLetter(letter);
                    if (verifyLetter == 2) {
                        nb_chances = server.getNbChances();
                        System.out.println();
                        System.out.println(
                                "Bravo :) ! Continuer ainsi ;) Vous avez encore " + nb_chances + " chances restantes");
                        System.out.println("Mot à deviner : " + foundLetters);
                    } else if(verifyLetter == 1){
                        nb_chances = server.getNbChances();
                        System.out.println();
                        System.out.println("Vous avez déjà trouvé cette lettre. Veuillez réessayer. Vous avez encore " + nb_chances + " chance(s) restante(s)");
                        System.out.println("Mot à deviner : " + foundLetters);
                    } else if(verifyLetter == 0){
                        nb_chances = server.getNbChances();
                        System.out.println();
                        System.out.println("Oups :( Vous avez encore " + nb_chances + " chance(s) restante(s)");
                        System.out.println("Mot à deviner : " + foundLetters);
                    }
                    endGame = foundLetters.indexOf("_") != -1;
                }
                if (endGame) {
                    System.out.println();
                    System.out.println("Oups vous avez perdu la partie :( Voulez-vous réessayer ?");
                    System.out.println("Répondez par oui ou non !");
                    ans = input.nextLine();
                } else {
                    System.out.println();
                    System.out.println("Félécitations à vous :) ;) Une nouvelle partie ?");
                    System.out.println("Répondez par oui ou non !");
                    ans = input.nextLine();
                }
                server.restart();
            }
            if (!ans.toLowerCase().equals("oui") && !ans.toLowerCase().equals("o")) {
                System.out.println();
                System.out.println("Serveur: Recontactez-moi en cas de besoin.");
                System.out.println(
                        "---------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
