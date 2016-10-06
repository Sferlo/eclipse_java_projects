package tareaComplejidadesUO225811;

import org.junit.Test;

public class TestAlgorithm {

	@Test
	public void test() {
		AlgorithmsBenchmark a = new AlgorithmsBenchmark();
		int n = 10;
		a.test0("SalidaTest0.csv");
		a.test1("SalidaTest1.csv",n);
		a.test2("SalidaTest2.csv", 0, n);
		a.test3("SalidaTest3.csv", 1, 1, n);
		a.test("linear1.csv", 1, 1, 10, "tareaComplejidadesUO225811.Algorithms", "linear1");
		a.test("linear2.csv", 1, 1, 10, "tareaComplejidadesUO225811.Algorithms", "linear2");
		a.test("quadratic1.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "quadratic1");
		a.test("quadratic2.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "quadratic2");
		a.test("cubic1.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "cubic1");
		a.test("cubic2.csv", 1, 1, 6, "tareaComplejidadesUO225811.Algorithms", "cubic2");
		a.test("logaritmic.csv", 1, 1, 30, "tareaComplejidadesUO225811.Algorithms", "logaritmic");
		a.test("pow2iter.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "pow2iter");
		System.out.println("pow2iter acabada");
		a.test("pow2rec1.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "pow2rec1");
		System.out.println("pow2rec1 acabada");
		a.test("pow2rec2.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "pow2rec2");
		System.out.println("pow2rec2 acabada");
		a.test("pow2rec3.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "pow2rec3");
		System.out.println("pow2rec3 acabada");
		a.test("pow2rec4.csv", 1, 1, n, "tareaComplejidadesUO225811.Algorithms", "pow2rec4");
		System.out.println("Pruebas terminadas");
	}
}
