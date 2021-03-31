package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ServiceInterface extends Remote {

    String sayHello(String name) throws RemoteException;

    float soma(float a, float b) throws RemoteException;
    
    float subtracao( float a, float b) throws RemoteException;
    
    float divisao( float a, float b) throws RemoteException;
    
    float media( float list[] ) throws RemoteException;
    
    int maximo(List list) throws RemoteException;
    
    int minimo( List list) throws RemoteException;
    
    double variancia( float list[]) throws RemoteException;
    
    double desvioPadrao( float list[]) throws RemoteException;
    
    List ordenacao ( ArrayList list) throws RemoteException;
    
    int nClasses(  List list) throws RemoteException;
    
    int amplitudeAmostral (int maximo, int minimo) throws RemoteException;
    
    int amplitudeClasse (int aA, int numClasses)  throws RemoteException;
    
}
