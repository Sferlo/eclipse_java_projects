package grafosUO225811;

import java.text.DecimalFormat;

public class Graph<T> {
	private T[] nodes; // Vector de nodos
	private boolean[][] edges; // matriz de aristas
	private double[][] weights; // matriz de pesos
	private int numNodes; // nï¿½mero de elementos en un momento dado
	
	//Vectores para Dijkstra
	private boolean[] s; //vector de nodos ya visitados
	private double[] d; //vector de costes 
	
	// tam: numero maximo de nodos que va a tener el grafo
	@SuppressWarnings("unchecked")
	public Graph(int tam) {
		nodes = (T[]) new Object[tam];
		this.edges = new boolean[tam][tam];
		this.weights = new double[tam][tam];
		this.numNodes = 0;
		this.s = new boolean[tam];
		this.d = new double[tam];
	}

	/**
	 * Inserta un nuevo nodo que se le pasa como parÃ¡metro, en el vector de
	 * nodos, si existe no lo inserta
	 * 
	 * @param node
	 *            el nodo que se quiere insertar
	 * 
	 * @return 0 si lo inserta, -1 si no puede insertarlo
	 */
	public int addNode(T node) {
		if (node != null && numNodes < nodes.length && !existNode(node)) {
			nodes[numNodes] = node;
			numNodes++;
			return 0;
		}
		return -1;
	}

	/**
	 * Obtiene el ï¿½ndice de un nodo en el vector de nodos
	 *
	 * ï¿½ï¿½ï¿½ OJO que es privado porque depende de la implementaciï¿½n !!!
	 * 
	 * @param node
	 *            el nodo que se busca
	 * @return la posiciï¿½n del nodo en el vector ï¿½ -1 si no lo encuentra o es
	 *         null
	 */
	public int getNode(T node) {
		if (node != null) {
			for (int i = 0; i < numNodes; i++)
				if (node.equals(nodes[i]))
					return i; // Ya existe el nodo, devuelve la posicion
			return -1;
		} else
			return -1;
	}

	/**
	 * @param node
	 *            Nodo que se quiere consultar
	 * @return si existe o no el nodo
	 */
	public boolean existNode(T node) {
		return getNode(node) != -1 ? true : false;
	}

	/**
	 * Inserta una arista con el peso indicado (> 0) entre dos nodos, uno origen
	 * y otro destino. Si la arista existe, le cambia el peso. Devuelve 0 si la
	 * inserta (o cambia el peso) y -1 si no lo hace
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @param edgeWeight
	 *            peso de la arista, debe ser > 0
	 * @return 0 si lo hace y -1 si no lo hace (tambiï¿½n si el peso es < 0)
	 */
	public int addEdge(T source, T target, double edgeWeight) {
		int origen = getNode(source);
		int destino = getNode(target);
		if (edgeWeight > 0 && origen != -1 && destino != -1) {
			if (edges[origen][destino] == true || edges[destino][origen] == true) { // arista
				edges[origen][destino] = true;
				weights[origen][destino] = edgeWeight; // cambiamos peso
				return 0;
			} else {
				edges[origen][destino] = true;
				weights[origen][destino] = edgeWeight;
				return 0;
			}
		}
		return -1;
	}

	/**
	 * Borra el nodo deseado del vector de nodos asï¿½ como las aristas de las que
	 * forma parte
	 * 
	 * @param node
	 *            que se quiere borrar
	 * @return 0 si lo borra o -1 si no lo hace
	 * 
	 */
	public int removeNode(T node) {
		int nodeRm = getNode(node);
		if (nodeRm != -1) {
			for (int i = 0; i < numNodes; i++) {
				edges[i][nodeRm] = edges[i][numNodes - 1];
				edges[nodeRm][i] = edges[numNodes - 1][i];
				weights[i][nodeRm] = weights[i][numNodes - 1];
				weights[nodeRm][i] = weights[numNodes - 1][i];
			}
			edges[nodeRm][nodeRm] = edges[numNodes - 1][numNodes - 1]; 
			weights[nodeRm][nodeRm] = weights[numNodes - 1][numNodes - 1];
			nodes[nodeRm] = nodes[numNodes - 1];
			nodes[numNodes - 1] = null;
			numNodes--;
			return 0;
		}
		return -1;
	}

	/**
	 * Comprueba si existe una arista entre dos nodos que se pasan como
	 * parametro
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @return verdadero o falso si existe o no, si alguno de los nodos no
	 *         existe tambien falso
	 */
	public boolean existEdge(T source, T target) {
		if (existNode(source) && existNode(target))
			return edges[getNode(source)][getNode(target)];
		return false;
	}

	/**
	 * Borra una arista del grafo que conecta dos nodos
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @return 0 si la borra o -1 si no lo hace (tambiï¿½n si no existe alguno de
	 *         sus nodos)
	 *
	 */
	public int removeEdge(T source, T target) { 
		int origen = getNode(source);
		int destino = getNode(target);
		if(origen != -1 && destino != -1 && existEdge(source, target)) {
			edges[origen][destino] = false;
			weights[origen][destino] = 0;
			return 0;
		}
		return -1;
	}

	/**
	 * Devuelve el peso de la arista que conecta dos nodos, si no existe la
	 * arista, devuelve -1 (tambien si no existe alguno de los nodos)
	 * 
	 * @param source
	 * @param target
	 * @return El peso de la arista o -1 si no existe
	 *
	 */
	public double getEdge(T source, T target) {
		int origen = getNode(source);
		int destino = getNode(target);
		if (origen != -1 && destino != -1 && edges[origen][destino] == true)
			return weights[origen][destino];
		return -1;
	}
	  
	/**
	 * trata el nodo que se le pasa por parametro, en este caso lo muestra por
	 * pantalla con un tabulador detras
	 * 
	 * @param nodo
	 */
	@SuppressWarnings("unused")
	private void tratarNodo(T nodo) {
		System.out.print(nodo.toString() + "\t"); // toString para aclarar...
	}

	/**
	 * Devuelve un String con la informacion del grafo
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "VECTOR NODOS\n";
		for (int i = 0; i < numNodes; i++) {
			cadena += nodes[i].toString() + "\t";
		}
		cadena += "\n\nMATRIZ ARISTAS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				if (edges[i][j])
					cadena += "T\t";
				else
					cadena += "F\t";
			}
			cadena += "\n";
		}
		cadena += "\nMATRIZ PESOS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				cadena += df.format(weights[i][j]) + "\t";
			}
			cadena += "\n";
		}

		return cadena;
	}
	
	/**
	 *  Algoritmo de Dijkstra para encontrar el camino de coste mínimo desde nodoOrigen 
	 *  hasta el resto de nodos
	 *  
	 * @param nodoOrigen
	 * @return vector D de dijkstra para comprobar funcionamiento
	 */
	public double[] dijkstra(T nodoOrigen) {
		int origen = getNode(nodoOrigen);
		boolean[] visitados = new boolean[numNodes];
		double[] distancias = new double[numNodes];
		
	}



	/**
	 * Busca el nodo con distancia mínima en D al resto de nodos
	 * @param dist  vector d
	 * @param v vector con visitados (conjunto S)
	 * @return índice del nodo buscado o -1 si el grafo es no conexo o no quedan nodos sin visitar
	 */
	public int minCost(double[] dist, boolean[] v) {
		double minPes = Double.MAX_VALUE;
		int actualNode = 0;
		for (int i = 0; i < numNodes; i++){
			if (minPes > dist[i] && v[i] == false){
				minPes = dist[i];
				actualNode = i;
			}
		}
		return actualNode;
	}	
}
