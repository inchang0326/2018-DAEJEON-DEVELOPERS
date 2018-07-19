import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NM2 {

	private static int N, M;
	private static int num[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N + 1];
		ArrayList<Integer> comb = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			num[i] = i;
		}

		// ON
		comb.add(new Integer(num[1]));
		dfs(2, comb);

		// OFF
		comb.remove(new Integer(num[1]));
		dfs(2, comb);
	}

	public static void dfs(int currPos, ArrayList<Integer> comb) {
		if (currPos == N + 1) {
			if (comb.size() == M) {
				for (int travel : comb) {
					System.out.print(travel + " ");
				}
				System.out.println();
			}
			return;
		} else {
			// ON
			comb.add(new Integer(num[currPos]));
			dfs(currPos + 1, comb);

			// OFF
			comb.remove(new Integer(num[currPos]));
			dfs(currPos + 1, comb);
		}
	}

}