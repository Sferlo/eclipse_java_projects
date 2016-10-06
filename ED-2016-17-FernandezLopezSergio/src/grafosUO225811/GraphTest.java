package grafosUO225811;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test() {
		Graph<Integer> g = new Graph<Integer>(5);
		
		assertEquals(0, g.addNode(2));  
		assertEquals(0, g.addNode(7));
		assertEquals(0, g.addNode(8));
		assertEquals(0, g.addNode(23));
		assertEquals(0, g.addNode(18));
		assertEquals(-1, g.addNode(4));
		assertEquals(-1, g.addNode(null));
		assertEquals(-1, g.addNode(-1));
		
		assertEquals(0, g.getNode(2));
		assertEquals(1, g.getNode(7));
		assertEquals(2, g.getNode(8));
		assertEquals(3, g.getNode(23));
		assertEquals(4, g.getNode(18));
		assertEquals(-1, g.getNode(4));
		
		assertTrue(g.existNode(2));
		assertTrue(g.existNode(7));
		assertTrue(g.existNode(8));
		assertTrue(g.existNode(23));
		assertTrue(g.existNode(18));
		assertFalse(g.existNode(4));
		
		assertEquals(0, g.addEdge(2, 7, 5));
		assertEquals(0, g.addEdge(2, 8, 3));
		assertEquals(0, g.addEdge(2, 23, 2));
		assertEquals(0, g.addEdge(18, 23, 10));
		assertEquals(0, g.addEdge(18, 8, 1));
		assertEquals(-1, g.addEdge(4, 8, 1));
		assertEquals(0, g.addEdge(2, 18, 9));
		assertEquals(0, g.addEdge(18, 7, 6));
		
		assertEquals(5, g.getEdge(2, 7), DELTA);
		assertEquals(3, g.getEdge(2, 8), DELTA);
		assertEquals(2, g.getEdge(2, 23), DELTA);
		assertEquals(10, g.getEdge(18, 23), DELTA);
		assertEquals(1, g.getEdge(18, 8), DELTA);
		assertEquals(-1, g.getEdge(4, 8), DELTA);
		assertEquals(-1, g.getEdge(null, 8), DELTA);
		assertEquals(-1, g.getEdge(null, null), DELTA);
		assertEquals(6, g.getEdge(18, 7), DELTA);
		
		assertEquals(0, g.removeEdge(2, 18));
		assertEquals(0, g.removeEdge(18, 7));
		assertEquals(-1, g.removeEdge(null, 18));
		assertEquals(-1, g.removeEdge(null, null));
		assertEquals(-1, g.removeEdge(4, 8));
		
		assertTrue(g.existEdge(2, 7));
		assertTrue(g.existEdge(2, 8));
		assertTrue(g.existEdge(2, 23));
		assertTrue(g.existEdge(18, 23));
		assertTrue(g.existEdge(18, 8));
		assertFalse(g.existEdge(18, 2));
		
		System.out.println(g.toString());
		
		assertEquals(0, g.removeNode(23));
		assertEquals(0, g.removeNode(2));
		assertEquals(0, g.removeNode(18));
		assertEquals(-1, g.removeNode(18));
		
		assertFalse(g.existEdge(2, 7));
		assertFalse(g.existEdge(2, 8));
		assertFalse(g.existEdge(2, 23));
		assertFalse(g.existEdge(18, 23));
		assertFalse(g.existEdge(18, 8));
		assertFalse(g.existEdge(18, 2));
		
		System.out.println(g.toString());	
	}

}
