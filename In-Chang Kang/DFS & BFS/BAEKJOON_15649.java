import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NM1 {

	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<Integer> comb = new ArrayList<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int depth = 1;

		for (int i = 1; i <= N; i++) {
			comb.add(new Integer(i));
			dfs(comb, depth);
			comb.clear();
		}
	}

	public static void dfs(ArrayList<Integer> comb, int depth) {
		if (depth == M) {
			for (int travel : comb) {
				System.out.print(travel + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				if (!comb.contains(new Integer(i))) {
					comb.add(new Integer(i));
					dfs(comb, ++depth);
					comb.remove(new Integer(i));
					depth--;
				}
			}
		}
	}
}
