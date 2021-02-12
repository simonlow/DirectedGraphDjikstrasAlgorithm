package assignment5_f20;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class DiGraph {
	private HashMap<String, Node> nodes;
	private HashMap<Long, Edge> edges; 
	
	  public DiGraph() {
		nodes = new HashMap<>();
		edges = new HashMap<>();
	  }
	  public boolean addNode(long idNum, String label) {
		  if (nodes.containsValue(idNum) || idNum < 0) {
			  return false;
		  }
		  else if (nodes.containsKey(label) || label == null) {
			  return false; 
		  }
		  else {
			  Node n = new Node(label, idNum);
			  nodes.put(label, n);
			  return true; 
		  }
		 
	  }
	  public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		  if (edges.containsValue(idNum) || idNum < 0) {
			  return false; 
		  }
		  else if (!(nodes.containsKey(sLabel) && nodes.containsKey(dLabel))) {
			  return false;
		  }
		  for (Entry<Long, Edge> e: edges.entrySet()) {
			  if (e.getValue().getSource().getLabel().equals(sLabel) && 
					  e.getValue().getDestination().getLabel().equals(dLabel)) {
				  return false; 
			  }
		  }
		  
		  if (weight > 1) {
			  Node s = nodes.get(sLabel);
			  Node d = nodes.get(dLabel);
			  Edge e = new Edge(idNum, s, d, weight, eLabel);
			  s.addAdj(d);
			  edges.put(idNum, e);
			  return true; 
		  }
		  else {
			  Node s = nodes.get(sLabel);
			  Node d = nodes.get(dLabel);
			  Edge e = new Edge(idNum, s, d, 1, eLabel);
			  s.addAdj(d);
			  edges.put(idNum, e);
			  return true;
		  }
		  
	  }
	  public boolean delNode(String label) {
		  if (nodes.containsKey(label)) {
			  nodes.remove(label);
			  return true; 
		  }
		  else {
			  return false; 
		  } 
	  }
	  public boolean delEdge(String sLabel, String dLabel) {
		  if (numEdges() > 0) {
			  for (Entry<Long, Edge> e: edges.entrySet()) {
				  if (e.getValue().getSource().getLabel().equals(sLabel) && 
						  e.getValue().getDestination().getLabel().equals(dLabel)) {
					  //e.setValue(null);
					  e.getValue().getSource().removeAdj(nodes.get(dLabel));
					  edges.remove(e.getKey(), e.getValue());
					  return true;
				  }
			  }
			  return false; 
		  }
		  return false; 
	  }
	  public long numNodes() {
		  return nodes.size();
	  }
	  public long numEdges() {
		  return edges.size();
	  }
	  public ShortestPathInfo[] shortestPath(String label) {
		  ShortestPathInfo[] list = new ShortestPathInfo[nodes.size()];
		  Node root = nodes.get(label);
		  root.setKnown(true);
		  root.setdv(0);
		 
		  Comparator <ShortestPathInfo> comp = new Comp();
		  PriorityQueue<ShortestPathInfo> pq = new PriorityQueue<>(100, comp);
		  list[0]= new ShortestPathInfo(label, 0);
		  Node node = root;
		  int index = 1;
		  while (node.adjSize() > 0) {
			  for (int i = 0; i < node.adjSize();i++) {
				  if (node.getAdj(i).getKnown()) {
					  continue; 
				  }
				  Edge e = findEdge(node.getLabel(), node.getAdj(i).getLabel(), edges);
				  long weight = node.getdv() + e.getWeight();
			
				  //checks if there is already a dv
				  if (node.getAdj(i).getdv() == 0) {
					  node.getAdj(i).setpv(node);
					  ShortestPathInfo s = new ShortestPathInfo(node.getAdj(i).getLabel(), weight);
					  pq.add(s);
				  }
				  else if (node.getAdj(i).getdv() >= weight){
					  node.getAdj(i).setpv(node);
					  ShortestPathInfo s = new ShortestPathInfo(node.getAdj(i).getLabel(), weight);
					  pq.add(s);
				  }
				  //SPI object with old dv should already be in if it is less
			  }
			  while (nodes.get(pq.peek().getDest()).getKnown()) {
				  pq.poll();
			  }
			  node = nodes.get(pq.peek().getDest()); //node becomes the next one
			  node.setdv(pq.peek().getTotalWeight()); //update the dv and known of the new node
			  node.setKnown(true);
			  list[index++] = pq.poll();	// pop the node off the PrQueue and put it in list[]
			  if (index==list.length) {
				  break;
			  }
			  
		  }
		  if (index < list.length) {
			  for (int i = 0; i< list.length; i++) {
				  for (Entry<String, Node> n: nodes.entrySet())	{
					  if (!n.getValue().getKnown()) {
						  n.getValue().setKnown(true);
						  n.getValue().setdv(-1);
						  ShortestPathInfo s = new ShortestPathInfo(n.getKey(), -1);
						  list[index++] = s;
					  }
				  }
			  }
		  }
		  return list;
	  }
	  
	  //give sedge with given source and destination, null if it doesn't exist
	  private static Edge findEdge(String source, String dest, HashMap<Long, Edge> edg) {
		  for (Entry<Long, Edge> e: edg.entrySet()) {
			  if (e.getValue().getSource().getLabel().equals(source) && 
					  e.getValue().getDestination().getLabel().equals(dest)) {
				  return e.getValue();
			  }
		  }
		  return null;
	  }
}
