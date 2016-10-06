package tareaComplejidadesUO225811;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import tareaComplejidadesUO225811.Algorithms;

/*
 * Fichero que saca en un fichero csv el tiempo de ejecuci�n de un algoritmo
 */
public class AlgorithmsBenchmark {

	/**
	 * M�todo principal que hace la llamada a los dem�s m�todos
	 * 
	 * @param args
	 *            par�metros de ser necesarios
	 * @throws InterruptedException
	 
	public static void main(String[] args) throws InterruptedException {
		AlgorithmsBenchmark t = new AlgorithmsBenchmark();
		// Algorithms a = new Algorithms();
		// a.linear(1000);
		// t.test1("salida.csv");
		// t.test3(5);
		// t.test2();
		t.test3("linear2.csv", 10, 0, 100);
	}
	*/
	
	/**
	 * M�todo que extrae datos en un fichero
	 * 
	 * @param output
	 *            nombre del fichero de salida
	 */
	public void test0(String output) {
		FileWriter file = null;
		PrintWriter pw;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = 1; i <= 10; i++) {
				pw.println(i + ";" + i * 10);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * M�todo que saca por fichero los datos cuando se ejecuta linear(endN)
	 * 
	 * @param output
	 *              el fichero de salida
	 * @param endN
	 *            l�mite superior de la carga de trabajo
	 */
	public void test1(String output, int endN) {
		FileWriter file = null;
		PrintWriter pw;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			Algorithms al = new Algorithms();
			long ini = System.currentTimeMillis();
			al.linear2(endN);
			pw.println(endN + ";"+ (System.currentTimeMillis() - ini));
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * M�todo que calcula el tiempo empleado por la ejecuci�n de un m�todo
	 * 
	 * @param output
	 * 				el nombre del fichero
	 * @param startN 
	 *  			n�mero m�nimo de iteraciones
	 * @param 
	 *              n�mero m�ximo de iteraciones
	 */
	public void test2(String output, int startN, int endN) {
		FileWriter file = null;
		PrintWriter pw;
		long tIni = 0;
		long tFin = 0;
		try{
			file = new FileWriter(output);
			pw = new PrintWriter(file);   
			Algorithms a = new Algorithms();
			for (int i = startN; i < endN; i++){
				tIni = System.currentTimeMillis();
				a.linear1(i);
				tFin = System.currentTimeMillis();
				pw.println(i + ";" + (tFin-tIni));
			}
			file.close();
		}catch(IOException e){
			System.err.println("Error en el tratamiento del fichero");
		}
	}

	/**
	 * Repite el metodo un n�mero de veces las veces que le indica desde startN
	 * a endN y calcula la media del tiempo de ejecuci�n
	 * 
	 * @param output
	 *            el nombre del fichero de salida
	 * @param times
	 *            las veces que se ejecuta el m�todo
	 * @param startN
	 *            numero inicial de la carga de trabajo
	 * @param endN
	 *            limite superior de la carga de trabajo
	 */
	public void test3(String output, int times, int startN, int endN) {
		FileWriter file = null;
		PrintWriter pw;
		Algorithms a = new Algorithms();
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			// workLoad defines the times
			for (int workLoad = startN; workLoad < endN; workLoad++) {
				long startTime = System.currentTimeMillis();
				for (int time = 0; time < times; time++){
					a.linear2(workLoad);
				}
				long finaltime = System.currentTimeMillis();
				long elapsedTime = (finaltime - startTime) / times;
				pw.println(workLoad+";"+elapsedTime);
			}
			pw.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	/**
	 * M�todo que devuelve el n�mero de milisegundos que tarda en ejecutarse el 
	 * m�todo de una clase concreta
	 * 
	 * @param nomClase
	 * 				  el nombre de la clase 
	 * @param nomMetodo
	 * 				  nombre del m�todo 
	 * @param n
	 * 			par�metro entero correspondiente al m�todo
	 * @return
	 * 		  milisegundos que tarda en ejecutarse el m�todo (�ste con un par�metro n)
	 */
	public long testAlgorithm(String nomClase, String nomMetodo, int n){
		try{ 
			Class<?> clase;
			Object miClase;
			Method metodo;
			
			clase = Class.forName(nomClase);
			miClase = clase.newInstance();
			metodo = clase.getMethod(nomMetodo, int.class);
			long ini = System.currentTimeMillis();
			metodo.invoke(miClase, new Integer(n));
			long end = System.currentTimeMillis();
			return end-ini;
		}catch(NullPointerException np){
			np.printStackTrace();
		}catch(ClassNotFoundException e){
			System.out.println("No se encuentra la clase");
			e.printStackTrace();
		}catch(NoSuchMethodException e){
			System.out.println("No se encuentra el m�todo");
			e.printStackTrace();
		}catch(IllegalAccessException e){
			System.out.println("El m�todo es privado");
			e.printStackTrace();
		}catch(IllegalArgumentException e){
			System.out.println("Par�metro inv�lido");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param output
	 * 				el fichero de salida 
	 * @param times
	 * 				las veces que se ejecuta
	 * @param startN
	 * 				carga de trabajo inicial
	 * @param endN
	 * 				carga de trabajo l�mite
	 * @param nomClase
	 * 				  nombre de la clase que se le pasa por par�metro
	 * @param nomMetodo
	 * 				 m�todo que se eval�a pasado por par�metro
	 */
	public void test (String output, int times, int startN, int endN, String nomClase, String nomMetodo){
		FileWriter file = null;
		PrintWriter pw;
		try{
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = startN; i < endN; i++){
				long tAlgoritmo = 0;
				for(int veces = 0; veces < times; veces++){
					tAlgoritmo += testAlgorithm(nomClase, nomMetodo, i);
				}
			pw.println(i+";"+tAlgoritmo/times);
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (file !=null) 
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
