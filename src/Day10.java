import java.util.ArrayList;
import java.util.Arrays;

public class Day10 {
	
	public static void permutations(String s) {
		// spawn the first copy of pHelper
		pHelper("", s);
	}

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
	
	public static void moneyChanging(int total, ArrayList<Integer> coins) {
		moneyHelper(new ArrayList<Integer>(), total, coins);
	}
	
	private static void moneyHelper(ArrayList<Integer> sofar, int remainingTotal, 
												ArrayList<Integer> remainingCoins) {
		// Base case (solution is ready!)
		if (remainingTotal == 0) {
			// print the solution
			for (Integer n : sofar) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		// Recursive step
		// For all possible choices, pick ONE choice
		// and add it to sofar		
		for (int i = 0; i < remainingCoins.size(); i++) {
			// Store the current element
			// We need to remove this from remain and
			//  add it to sofar
			int current = remainingCoins.get(i);
			// The arguments to the recursive call need to be:
			// * sofar becomes sofar + current
			// * remaining becomes remaining OMITTING character #i
			
			// set up copies of the array lists 
			ArrayList<Integer> nextSofar = new ArrayList<Integer>(sofar);
			nextSofar.add(current);
			ArrayList<Integer> nextRemainingCoins = new ArrayList<Integer>(remainingCoins);
			nextRemainingCoins.remove(i);
			
			// now we can do the recursive call
			moneyHelper(nextSofar, remainingTotal-current, nextRemainingCoins);
		}
		
	}


	public static void subsets(String s) {
		// spawn the first copy of sHelper
		sHelper("", s);
	}
	
	private static void sHelper(String sofar, String remaining) {
		// Base case (solution is ready!)
		if (remaining.isEmpty()) {
			// Print the solution
			System.out.println(sofar);
			return;
		}
		
		// Recursive steps
		
		// Pull one character out of remaining
		// (arbitrarily choose character #0)
		char current = remaining.charAt(0);
		
		// Two recursive calls:
		// (a) include current
		sHelper(sofar + current, remaining.substring(1));
		// (b) exclude current
		sHelper(sofar, remaining.substring(1));
	}
	

	
	public static void formableSums(ArrayList<Integer> coins) {
		// spawn the first copy of the helper
		formableSumsHelper(0, coins);
	}
	
	private static void formableSumsHelper(int sofar, ArrayList<Integer> remaining) {
		// base case: no more "ingredients" (remaining) left to work with
		if (remaining.isEmpty()) {
			// Print the solution
			System.out.println(sofar);
			return;
		} 
	
		// Recursive steps
		
		// Pull one coin out of remaining
		// (arbitrarily choose item #0)
		int current = remaining.get(0);
		
		ArrayList<Integer> nextRemaining = new ArrayList<Integer>(remaining);
		nextRemaining.remove(0);
		
		// Two recursive calls:
		// (a) include current
		formableSumsHelper(sofar + current, nextRemaining);
		// (b) exclude current
		formableSumsHelper(sofar, nextRemaining);
		
	}
	
	public static void formableTeams(ArrayList<String> people) {
		
	}
	
	private static void formableTeamsHelper(ArrayList<String> sofar, ArrayList<String> remaining) {
		
	}
	
	
	
	public static void main(String[] args) {
//		permutations("ABCD");
		
//		ArrayList<Integer> mycoins = new ArrayList<Integer>();
//		mycoins.add(1);
//		mycoins.add(2);
//		mycoins.add(2);
//		mycoins.add(5);
//		mycoins.add(7);
//		moneyChanging(10, mycoins);
		
//		subsets("ABCD");
		
		ArrayList<Integer> mycoins2 = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 10));
		formableSums(mycoins2);
		
	}

}
