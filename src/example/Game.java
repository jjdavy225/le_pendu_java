package example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Game extends Remote {
    String sayHello() throws RemoteException;
    String startGame() throws RemoteException;
    String verifyLetter(String letter) throws RemoteException;
}