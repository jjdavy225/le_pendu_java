package example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private static String startGame;

    private Client() {}

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(1116);
            Game server = (Game) registry.lookup("Game");
            String response = server.sayHello();
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Serveur: " + response);
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Répondez par oui ou non !");
            String ans = input.nextLine();
            System.out.println();
            if (ans.equals("OUI") || ans.equals("oui")|| ans.equals("Oui")) {
                startGame = server.startGame();
                Integer nb_chances = 3;
                System.out.println("Vous avez " + nb_chances + " chances restantes pour deviner le mot du jour");
                System.out.println("Mot à deviner : " + startGame);
                
                while (nb_chances > 0) {
                    String letter = input.nextLine();
                    System.out.println(server.verifyLetter(letter));
                    
                }

                
            } else {
                System.out.println();
                System.out.println("Serveur: Recontactez-moi en cas de besoin.");
                System.out.println("---------------------------------------------------------------------------------------");

            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
