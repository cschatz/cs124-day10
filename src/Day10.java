import java.util.ArrayList;

public class Day10 {

	private static void pHelper(String sofar, String remaining) {
		// Base case (solution is ready!)
		if (remaining.isEmpty()) {
			// print the solution
			System.out.println(sofar);
		}
		
		// Recursive step
		// For all possible choices, pick ONE choice
		// and add it to sofar		
		for (int i = 0; i < remaining.length(); i++) {
			// Store the current element
			// We need to remove this from remain and
			//  add it to sofar
			char current = remaining.charAt(i);
			// The arguments to the recursive call need to be:
			// * sofar becomes sofar + current
			// * remaining becomes remaining OMITTING character #i
			pHelper(sofar + current, 
					remaining.substring(0, i) + remaining.substring(i+1));
		}
		
	}
	
	
	public static void permutations(String s) {
		// spawn the first copy of pHelper
		pHelper("", s);
	}
	
	public static void subsets(String s) {
		
	}
	
	public static void main(String[] args) {
		permutations("ABCD");
	}

}
