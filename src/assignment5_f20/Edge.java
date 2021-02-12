package assignment5_f20;

public class Edge {
	private long weight;
	private Node source;
	private Node destination;
	private long idNum;
	private String label; 
	
	public Edge (long i, Node s, Node d, long w, String l) {
		weight = w;
		source = s;
		destination = d;
		idNum = i;
		label = l;
	}
	//getters and setters
	public long getWeight() {
		return weight;
	}
	public Node getSource() {
		return source; 
	}
	public Node getDestination() {
		return destination;
	}
	public long getID() {
		return idNum;
	}
}
