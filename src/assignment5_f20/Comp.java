package assignment5_f20;

import java.util.Comparator;

public class Comp implements Comparator<ShortestPathInfo> {
	public Comp() {
		
	}
	@Override	
	public int compare(ShortestPathInfo s1, ShortestPathInfo s2) {
		if (s1.getTotalWeight() < s2.getTotalWeight()) {
			return -1; 
		}
		else if (s1.getTotalWeight() == s2.getTotalWeight()){
			return 0;
		}
		else {
			return 1;
		}
	}
}

