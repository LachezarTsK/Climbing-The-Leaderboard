import java.util.*;

public class Solution {
		public static int[] getResults(HashMap<Integer, Integer> results, int[] alice) {
		int current = 0;
		int[] points = new int[alice.length];
		int index = results.keySet().size();
		for (int i = 0; i < alice.length; i++) {
			current = alice[i];
			for (int j = index; j >= 1; j -= 1) {

				if (current == results.get(j)) {
					points[i] = j;
					index = j;
					break;
				} else if (current < results.get(j)) {
					points[i] = j + 1;
					index = j;
					break;
				} else {
					points[i] = 1;

				}
			}
		}
		return points;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
		int current = 0;
		int counter = 1;

		int[] scores = new int[n];
		for (int scores_i = 0; scores_i < n; scores_i++) {
			scores[scores_i] = in.nextInt();
			if (scores_i == 0) {
				results.put(counter, scores[scores_i]);
				current = scores[scores_i];
				counter++;
			}

			else if (current > scores[scores_i]) {
				current = scores[scores_i];
				results.put(counter, current);
				counter++;
			}

		}

		int m = in.nextInt();
		int[] alice = new int[m];
		for (int alice_i = 0; alice_i < m; alice_i++) {
			alice[alice_i] = in.nextInt();
		}
		int[] position = getResults(results, alice);
		for (int i = 0; i < position.length; i++) {
			System.out.println(position[i]);
		}
	
	}
}
