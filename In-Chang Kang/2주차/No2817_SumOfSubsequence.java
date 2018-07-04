import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2817_SumOfSubsequence {

	public static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int size = Integer.parseInt(st.nextToken());
			int maxSum = Integer.parseInt(st.nextToken());

			int set[] = new int[size];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size; i++) {
				set[i] = Integer.parseInt(st.nextToken());
			}

			combinations(set, set.length, maxSum);
			System.out.println("#" + t + " " + cnt);
			cnt = 0;
		}
	}

	public static void combinations(int[] set, int size, int maxSum) {
		int[] data = new int[size];
		for (int i = 1; i <= set.length; i++) {
			combinations(set, data, 0, size - 1, 0, i, maxSum);
		}
	}

	private static void combinations(int[] set, int[] data, int start, int end, int index, int r, int maxSum) {
		if (index == r) {
			int sum = 0;
			for (int i = 0; i < r; i++) {
				sum += data[i];
			}
			if (sum == maxSum)
				cnt++;
		}

		for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++) {
			data[index] = set[i];
			combinations(set, data, i + 1, end, index + 1, r, maxSum);
		}
	}
}