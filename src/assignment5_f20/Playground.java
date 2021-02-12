package assignment5_f20;

public class Playground {
	public static void main (String [] args) {
		
		/*
		d.delEdge("f","s");
		d.addNode(1,"f");
		d.addNode(3,"s");
		d.addEdge(0,"f","s", 1, null);
		d.delEdge("f","s");
		d.delEdge("f","s");
		d.addEdge(0,"f","s", 1, null);
		d.delEdge("f","s");
		*/
		//zero();
		//one();
		//two();
		//three();
		four();
		//five();
		
		
	}
	public static void zero() {
		DiGraph g = new DiGraph();
		g.addNode(0, "a");
		g.addNode(1, "b");
		g.addNode(2, "c");
		g.addEdge(0, "a", "b", 3, null);
		g.addEdge(1, "a", "c", 5, null);
		g.addEdge(2, "b", "c", 4, null);
		ShortestPathInfo [] s = g.shortestPath("a");
		for (int i = 0; i < 3;i++) {
			System.out.println(s[i]);
		}
		System.out.println("\n");
	}
	public static void one() {
		DiGraph e = new DiGraph();
		e.addNode(0, "a");
		e.addNode(1, "b");
		e.addNode(2, "c");
		e.addEdge(0, "a", "b", 3, null);
		e.addEdge(1, "a", "c", 10, null);
		e.addEdge(2, "b", "c", 4, null);
		ShortestPathInfo [] s = e.shortestPath("a");
		for (int i = 0; i < 3;i++) {
			System.out.println(s[i]);
		}
		System.out.println("\n");
	}
	public static void two() {
		DiGraph d = new DiGraph();
		d.addNode(0, "a");
		d.addNode(1, "b");
		d.addNode(2, "c");
		d.addNode(3, "d");
		d.addEdge(0, "a", "b", 1, null);
		d.addEdge(1, "b", "c", 2, null);
		d.addEdge(2, "c", "a", 3, null);
		d.addEdge(3, "c", "d", 2, null);
		d.addEdge(4, "d", "b", 1, null);
		ShortestPathInfo [] s = d.shortestPath("a");
		for (int i = 0; i < 4;i++) {
			System.out.println(s[i]);
		}
		System.out.println("\n");
	}
	public static void three() {
		DiGraph d = new DiGraph();
		d.addNode(0, "p");
		d.addNode(1, "a");
		d.addNode(2, "g");
		d.addNode(3, "e");
		d.addEdge(0, "p", "a", 10, null);
		d.addEdge(1, "p", "g", 4, null);
		d.addEdge(2, "p", "e", 8, null);
		d.addEdge(3, "a", "p", 9, null);
		d.addEdge(4, "a", "g", 12, null);
		d.addEdge(5, "a", "e", 100, null);
		d.addEdge(6, "g", "p", 2, null);
		d.addEdge(7, "g", "a", 15, null);
		d.addEdge(8, "g", "e", 1, null);
		d.addEdge(9, "e", "p", 6, null);
		d.addEdge(10, "e", "a", 3, null);
		ShortestPathInfo [] s = d.shortestPath("p");
		for (int i = 0; i < 4;i++) {
			System.out.println(s[i]);
		}
		System.out.println("\n");
	}
	public static void four() {
		DiGraph d = new DiGraph();
		d.addNode(0, "0");
		d.addNode(1, "1");
		d.addNode(2, "2");
		d.addNode(3, "3");
		d.addNode(4, "4");
		d.addNode(5, "5");
		d.addNode(6, "6");
		d.addEdge(0, "0", "5", 3, null);
		d.addEdge(1, "3", "2", 6, null);
		d.addEdge(2, "4", "0", 1, null);
		d.addEdge(3, "4", "5", 2, null);
		d.addEdge(4, "6", "1", 4, null);
		ShortestPathInfo [] s = d.shortestPath("0");
		for (int i = 0; i < 7;i++) {
			System.out.println(s[i]);
		}
		System.out.println("\n");
	}
	public static void five() {
		DiGraph d = new DiGraph();
		d.addNode(0, "a");
		d.addNode(1, "b");
		d.addNode(2, "c");
		d.addNode(3, "d");
		d.addNode(4, "e");
		d.addEdge(0, "a", "b", 1, null);
		d.addEdge(1, "a", "c", 3, null);
		d.addEdge(2, "a", "d", 5, null);
		d.addEdge(3, "a", "e", 9, null);
		d.addEdge(4, "b", "c", 1, null);
		d.addEdge(5, "b", "d", 2, null);
		d.addEdge(6, "b", "e", 7, null);
		d.addEdge(7, "c", "d", 2, null);
		d.addEdge(8, "c", "e", 5, null);
		d.addEdge(9, "d", "e", 3, null);
		ShortestPathInfo [] s = d.shortestPath("a");
		for (int i = 0; i < 5;i++) {
			System.out.println(s[i]);
		}
		System.out.println("\n");
	}
}
