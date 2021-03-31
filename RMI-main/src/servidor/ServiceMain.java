package servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServiceMain {

    public static void main(String[] args) {

        run(2016, "Service_01");
    }

    public static void run(int pPort, String nome) {
        try {
            ServiceInterface objServiceInterface = new ServiceImpl() {};
            Registry registry = LocateRegistry.createRegistry(pPort);

            //ligacao ao objeto que tem referenciados os metodos 
            registry.bind(nome, objServiceInterface);

            //mostra as infos do servidor
            System.out.println("Respondendo: Service 01, Port: " + pPort);

        } catch (RemoteException | AlreadyBoundException e) {
           System.out.println( e.getMessage() );
        }
    }

}
