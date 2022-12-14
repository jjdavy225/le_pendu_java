package example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Game extends Remote {
    String sayHello() throws RemoteException;
    Integer getNbChances() throws RemoteException;
    String newHiddenWord() throws RemoteException;
    String foundLetters(String letter) throws RemoteException;
    Integer verifyLetter(String letter) throws RemoteException;
    Void restart() throws RemoteException;
}