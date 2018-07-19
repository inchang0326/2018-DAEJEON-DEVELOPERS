import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class No4223_OvercomTrauma {

	private static PriorityQueue<Integer> sum = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Judge> comb = new ArrayList<>();
		int testCase, N, L, P, minOf;
		String name;
		Judge[] list;

		testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			N = Integer.parseInt(br.readLine());
			list = new Judge[N];
			for (int i = 0; i < N; i++) {
				L = Integer.parseInt(br.readLine());
				name = br.readLine();
				P = Integer.parseInt(br.readLine());

				Judge judge = new Judge();
				judge.setBits(name);
				judge.setScore(P);
				list[i] = judge;
			}

			// ON
			comb.add(list[0]);
			dfs(list, comb, 1, N);

			// OFF
			comb.remove(list[0]);
			dfs(list, comb, 1, N);

			if (sum.isEmpty()) {
				minOf = -1;
			} else {
				minOf = sum.poll();
			}

			System.out.println("#" + t + " " + minOf);

			sum.clear();
		}
	}

	public static void dfs(Judge[] list, ArrayList<Judge> comb, int currPos, int end) {
		if (currPos == end) {
			if (!comb.isEmpty()) {
				if(validationChk(comb)) {
					int score = 0;
					for(Judge travel : comb) {
						score += travel.getScore();
					}
					sum.add(score);
				}
			}
			return;
		} else {
			// ON
			comb.add(list[currPos]);
			dfs(list, comb, currPos + 1, end);

			// OFF
			comb.remove(list[currPos]);
			dfs(list, comb, currPos + 1, end);
		}
	}

	public static boolean validationChk(ArrayList<Judge> comb) {
		int[] bits = comb.get(0).getBits().clone();
		for (int i = 1; i < comb.size(); i++) {
			for (int j = 0; j < 7; j++) {
				if ((bits[0] == 1 && comb.get(i).getBitOf(0) == 1) && j == 0) {
					bits[3] = 1;
				}
				bits[j] = bits[j] | comb.get(i).getBitOf(j);
			}
		}
		for(int i=0; i<7; i++) {
			if(bits[i] != 1) return false;
		}
		return true;
	}
}

class Judge {
	private int[] bits;
	private int score;

	public Judge() {
		this.bits = new int[7];
		for (int i = 0; i < 7; i++) {
			this.bits[i] = 0;
		}
	}

	public int[] getBits() {
		return bits;
	}

	public int getBitOf(int index) {
		return bits[index];
	}

	public void setBits(String name) {
		String[] st = name.split(" ");
		for (int i = 0; i < st.length; i++) {
			char temp = st[i].charAt(0);
			switch (temp) {
			case 'S': {
				if (this.bits[0] == 1) {
					this.bits[3] = 1;
				} else {
					this.bits[0] = 1;
				}
				break;
			}
			case 'A': {
				this.bits[1] = 1;
				break;
			}
			case 'M': {
				this.bits[2] = 1;
				break;
			}
			case 'U': {
				this.bits[4] = 1;
				break;
			}
			case 'N': {
				this.bits[5] = 1;
				break;
			}
			case 'G': {
				this.bits[6] = 1;
				break;
			}
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}