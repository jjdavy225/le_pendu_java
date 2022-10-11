package example;
        
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
        
public class Server extends ImpGame {
        
    public Server() {}
        
    public static void main(String args[]) {
        
        try {
            ImpGame obj = new ImpGame();
            Game stub = (Game) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Game", stub);

            System.err.println("Serveur prêt !");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}