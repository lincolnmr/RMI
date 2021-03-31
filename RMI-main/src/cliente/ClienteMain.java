package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import servidor.ServiceInterface;

public class ClienteMain {

    public static void main(String[] args) {

        try {
            int port = 2016;
            int maximo = 0, minimo = 0, quantClasses = 0, aA = 0, aC = 0;

            Random gerador = new Random();

            List<Integer> listaInt = new ArrayList<Integer>();
            
            // Registrar a conexao com o servidor
            Registry registry = LocateRegistry.getRegistry("localhost", port);

            // A partir da conexao, obter o objeto stub para executar os metodos remotos
            ServiceInterface stub = (ServiceInterface) registry.lookup("Service_01");
            // stub conhece a lista de metodos implementado no servidor

            /*
            
            // invocao do metodo remoto
            String response = stub.sayHello("Joas ");
            float resultado = stub.soma(10, 3);
            System.out.println("response: " + response);
            System.out.println("response: " + resultado);
            resultado = stub.subtracao(10, 3);
            System.out.println("sub: " + resultado);
            
            
            float divi = stub.divisao(16, 4);
            System.out.println("divisao: " + divi);
            
            
            float list[] = {2, 8};
            
            float media = stub.media(list);
            
            System.out.println("Média: " + media);
          
            float maximo = stub.maximo(list);
            float minimo = stub.minimo(list);
            
            System.out.println("Maximo: " + maximo + " Minimo: " + minimo);
            
            double variancia = stub.variancia(list);
            
            System.out.println("Variância: " + variancia);
            
            double desvioPadrao = stub.desvioPadrao(list);
            
            System.out.println("Desvio Padrao: " + desvioPadrao);

            */
            
            
            for (int i = 0; i < 20; i++) {
                listaInt.add(gerador.nextInt(40));
            }
            
            listaInt = stub.ordenacao((ArrayList) listaInt);
            
            System.out.println("Lista ordenada" );
            System.out.println(Arrays.toString(listaInt.toArray()));
            
            // Raiz quadrada do tamanho da lista
            quantClasses = stub.nClasses(listaInt);
            System.out.println("Quantidade de classes: " + quantClasses);
            
            maximo = stub.maximo(listaInt);
            minimo = stub.minimo(listaInt);
            
            System.out.println("Maximo: " + maximo + " Minimo: " + minimo);
            
            // Valor maximo da lista - Valor minimo
            aA = stub.amplitudeAmostral(maximo, minimo);
            System.out.println("Amplitude amostral: " + aA);
            
            // Valor da amplitude amostral divido pela quantidade de classes
            aC = stub.amplitudeClasse(aA, quantClasses);
            System.out.println("Amplitude de Classes: " + aC);
            
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
