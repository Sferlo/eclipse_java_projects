package tareaComplejidadesUO225811;

public class Algorithms {
	public static final int SLEEP_TIME = 250;
	
	/**
	 * Method that does nothing during the specified time(ms)
	 */
	public static void doNothing(){
		try{
			Thread.sleep(SLEEP_TIME);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Linear working method
	 * @param times for the times it works
	 * @throws InterruptedException
	 */
	public void linear1(int times){
		for(int i = 0; i < times; i++){
			System.out.println(i);
		}
	}
	
	/**
	 * Linear working method with doNothing delay inclusion
	 * @param times for the times it works
	 * @throws InterruptedException
	 */
	public void linear2(int times){
		for(int i = 0; i < times; i++){
			System.out.println(i);
			doNothing();
		}
	}

	/**
	 * Method which executes the quadratic nested complexity 
	 * @param times
	 */
	public void quadratic1(int times){
		for (int i = 0; i < times; i++)
			for (int j = 0; j < times; j++){
				System.out.println(i+";"+j);
		}
	}
	
	/**
	 * Method which executes the quadratic nested complexity with doNothing delay
	 * @param times time it is repeated
	 */
	public void quadratic2(int times){
		for (int i = 0; i < times; i++)
			for (int j = 0; j < times; j++){
				System.out.println(i+";"+j);
				doNothing();
		}
	}
	
	/**
	 * Triple for nesting which elevates the execution complexity up to O(n^3) 
	 * @param times time it is repeated in each loop equally
	 */
	public void cubic1(int times){
		for (int i = 0; i < times; i++)
			for (int j = 0; j < times; j++)
				for (int k = 0; k < times; k++){
					System.out.println(i + ";" + j + ";" + k);
				
				}
	}
	
	/**
	 * The same as cubic1 but with a time delay from doNothing method 
	 * each time it reaches the third for loop
	 * @param times
	 */
	public void cubic2(int times){
		for (int i = 0; i < times; i++)
			for (int j = 0; j < times; j++)
				for (int k = 0; k < times; k++){
					System.out.println(i + ";" + j + ";" + k);
					doNothing();
				}
	}
	
	/**
	 * M�todo de complejidad logar�tmica
	 * @param times 
	 * 			   carga de trabajo
	 */
	public void logaritmic(int times){
		for(int i = times; i > 0; i/=2)
			doNothing();
	}
	
	/**Algoritmo de complejidad lineal que calcula la potencia de 2 de forma iterativa
	 * @param n 
	 * @throws InterruptedException
	 */
	public long pow2iter(int n){
		Algorithms.doNothing();
		long pow= 1;
		for(int i=0; i<n; i++){
			pow=pow*2;
		}
		return pow;
	}
	
	/**Algoritmo de complejidad lineal que calcula la potencia de 2 de forma recursiva
	 * @param n 
	 * 		   potencia deseada
	 * @throws InterruptedException
	 */
	public long pow2rec1(int n){
		Algorithms.doNothing();
		if(n == 0)
			return 1;
		else
			return 2*pow2rec1(n-1);
	}
	
	/**Algoritmo de complejidad exponencial O(2^n) que calcula la potencia de 2 de forma recursva
	 * @param n
	 * @throws InterruptedException
	 */
	public long pow2rec2(int n){
		Algorithms.doNothing();
		if(n == 0)
			return 1;
		else
			return pow2rec2(n-1)+pow2rec2(n-1);
	}
	
	/**Algoritmo de complejidad lineal que calcula la potencia de 2 de forma recursiva
	 * @param n
	 * @throws InterruptedException
	 */
	public long pow2rec3(int n){
		Algorithms.doNothing();
		if(n == 0)
			return 1;
		else if(n%2 == 0)
			return pow2rec3(n/2)*pow2rec3(n/2);
		else
			return 2*pow2rec3(n/2)*pow2rec3(n/2);
	}
	
	/**Algoritmo de complejidad logaritmica O(log2 n) que calcula la potencia de 2 de forma recursiva
	 * @param n
	 * @throws InterruptedException
	 */
	public long pow2rec4(int n){
		Algorithms.doNothing();
		long valor = pow2rec3(n/2);
		if(n == 0)
			return 1;
		else if(n%2 == 0)
			return valor*valor;
		else
			return 2*valor*valor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
