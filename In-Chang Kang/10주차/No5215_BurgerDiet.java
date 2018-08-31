import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No5215_BurgerDiet {

	public static int ans;
	public static int[] score, kal;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] st = br.readLine().split(" ");
			int num = Integer.parseInt(st[0]);
			int lim = Integer.parseInt(st[1]);
			score = new int[num];
			kal = new int[num];
			ans = 0;

			for (int i = 0; i < num; i++) {
				st = br.readLine().split(" ");
				score[i] = Integer.parseInt(st[0]);
				kal[i] = Integer.parseInt(st[1]);
			}

			dfs(score[0], kal[0], lim, 1, num);
			dfs(0, 0, lim, 1, num);

			System.out.println("#" + t + " " + ans);
		}
	}

	public static void dfs(int s, int k, int l, int i, int n) {
		if (k > l) {
			return;
		}

		if (s > ans) {
			ans = s;
		}

		if (i != n) {
			dfs(s + score[i], k + kal[i], l, i + 1, n);
			dfs(s, k, l, i + 1, n);
		}
	}
}
