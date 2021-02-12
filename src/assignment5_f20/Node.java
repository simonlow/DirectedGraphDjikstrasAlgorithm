package assignment5_f20;

import java.util.ArrayList;

public class Node {
	private String label;
	private long value;
	
	//For Dijkstras
	private boolean known;
	private long dv; //distance to Node dv
	private Node pv; 
	private ArrayList<Node> adj;
	
	public Node(String lab, long val) {
		this.label = lab;
		this.value = val;
		adj = new ArrayList<>();
		known = false; 
		pv = null; 
		dv = 0;
	}
	public void setLabel(String newLabel) {
		label = newLabel;
	}
	public void setValue(long newVal) {
		value = newVal;
	}
	public String getLabel() {
		return label;
	}
	public long getValue() {
		return value; 
	}
	public boolean getKnown() {
		return known;
	}
	public long getdv() {
		return dv;
	}
	public Node getpv() {
		return pv;
	}
	public void setKnown(boolean k) {
		known = k;
	}
	public void setdv(long d) {
		dv = d;
	}
	public void setpv(Node n) {
		pv = n;
	}
	public void addAdj(Node n) {
		adj.add(n);
	}
	public Node getAdj(int x) {
		return adj.get(x);
	}
	public int adjSize() {
		return adj.size();
	}
	public void removeAdj(Node n) {
		adj.remove(n);
	}
}
