package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements
		ServiceInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceImpl() throws RemoteException {
		super();
	}
        
	/**
	 *   Métodos remotos
	 */

	public String sayHello(String name) throws RemoteException {
		return "Hello " + name;
	}
	
	public float soma(float a, float b) throws RemoteException {
		return a + b;
	}
        
        public float subtracao( float a, float b) throws RemoteException{
           return a - b; 
        }
        
        @Override
        public float divisao( float a, float b) throws RemoteException{
           return a / b; 
        }

        public float media( float list[] ) throws  RemoteException{
            int size = list.length;
            if( size == 0 ){
                return 0;
            }
            float soma = 0;
            float media = 0;
            for (int i = 0; i < size; i++) {
                soma = soma + list[i];
            }
            media = soma / size; 
            return media;
        }
        
        public int maximo( List list ) throws  RemoteException{
            
            int size = list.size();
            int maximo = (int) list.get(0);
            
            if( size == 0 ){
                return 0;
            }

            for (int i = 0; i < size; i++) {
                
                if((int)list.get(i) > maximo ){
                    maximo = (int) list.get(i);
                }
            }         
            return maximo;
        }
        
        public int minimo( List list ) throws  RemoteException{
            
            int size = list.size();
            int minimo = (int) list.get(0);
            
            if( size == 0 ){
                return 0;
            }

            for (int i = 0; i < size; i++) {

                if((int)list.get(i) < minimo){
                    minimo = (int) list.get(i);
                }
            }
            return minimo;
        }
        
        
        public double variancia( float list[] ) throws  RemoteException{
            
            int size = list.length;
             
            float media = media(list);
            
            double soma = 0;
            double variancia = 0;
            
            if( size == 0 ){
                return 0;
            }
          
            for (int i = 0; i < size; i++) {
                
                soma += Math.pow((list[i] - media ), 2); 
            }
            
            variancia = soma / size;
            
            return variancia;
        }
        
        
        public double desvioPadrao( float list[] ) throws RemoteException{
            
            return Math.sqrt(variancia(list));
        }
        
        public List ordenacao ( ArrayList listaInt) throws RemoteException{
            
            List<Integer> listaOrd = new ArrayList<>();
            Collections.sort(listaInt);
            listaOrd = listaInt;
            return listaOrd;
        }
        
        
        public int nClasses(List lista ) throws  RemoteException{
            
            int tamLista = lista.size();
            
            if( tamLista == 0 ){
                return 0;
            }
            
            return (int)Math.sqrt(tamLista);
        }
        
        public int amplitudeAmostral(int maximo, int minimo){

            return maximo - minimo; 
        }
        
        public int amplitudeClasse (int aA, int numClasses){
            
            return Math.round(aA/numClasses) ;
        }
}
