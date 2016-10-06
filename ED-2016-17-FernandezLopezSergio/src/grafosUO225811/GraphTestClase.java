package grafosUO225811;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTestClase {

	@Test
	public void test() {
		Graph<Integer> g = new Graph<Integer>(5);
		boolean[] v = {true,false,false,false,false};
		double[] d = {0,400,20,3,500};
		
		assertEquals(0, g.addNode(0));
		assertEquals(0, g.addNode(1));
		assertEquals(0, g.addNode(2));
		assertEquals(0, g.addNode(3));
		assertEquals(0, g.addNode(4));
		
		assertEquals(0, g.addEdge(0, 1, 100));
		assertEquals(0, g.addEdge(0, 4, 500));
		assertEquals(0, g.addEdge(0, 1, 400));
		assertEquals(0, g.addEdge(0, 3, 3));
		assertEquals(0, g.addEdge(0, 2, 20));
		assertEquals(0, g.addEdge(2, 1, 12));
		assertEquals(0, g.addEdge(3, 1, 31));
		assertEquals(0, g.addEdge(1, 4, 41));
		assertEquals(0, g.addEdge(4, 0, 40));
		
		System.out.println(g.toString());
		
		//assertArrayEquals(new double[]{0.0, 32.0, 20.0, 3.0, 73.0}, g.dijkstra(0), 0.0001);
		
		assertEquals(3, g.minCost(d,v));
		
	}

}
