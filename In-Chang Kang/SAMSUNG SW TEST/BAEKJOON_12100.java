import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2048(easy)

public class BAEKJOON_12100 {

	private static int ans = -1;
	private static final int LIMIT = 5;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}

		for (int d = 1; d < 5; d++) {
			int[] comb = new int[6];
			comb[0] = d;

			int[][] copied = new int[N][N];
			copyArray(copied, map, N);

			dfs(comb, 0, copied, N);
		}

		System.out.println(ans);
	}

	public static void copyArray(int[][] copied, int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copied[i][j] = map[i][j];
			}
		}
	}

	public static void dfs(int[] comb, int idx, int[][] map, int N) {
		if (idx == LIMIT) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = map[i][j];
					if (ans < temp)
						ans = temp;
				}
			}
			return;
		}

		int dir = comb[idx];

		switch (dir) {
		case 1: {
				toUp(map, N);
				break;
			}
			case 2: {
				toDown(map, N);
				break;
			}
			case 3: {
				toLeft(map, N);
				break;
			}
			case 4: {
				toRight(map, N);
				break;
			}
		}

		for (int d = 1; d < 5; d++) {
			comb[idx + 1] = d;

			int[][] copied = new int[N][N];
			copyArray(copied, map, N);

			dfs(comb, idx + 1, copied, N);
		}
	}

	// 위로 움직임
	public static void toUp(int[][] map, int N) {
		int i = -1;
		while (true) {
			i++;
			if (i == N)
				break;

			// 1. 위로 당기기
			for (int j = 0; j < N; j++) {
				if (map[j][i] == 0) {
					for (int z = j + 1; z < N; z++) {
						if (map[z][i] != 0) {
							int temp = map[z][i];
							map[z][i] = map[j][i];
							map[j][i] = temp;
							break;
						}
					}
				}
			}

			// 2. 한 번 합치기
			for (int j = 0; j < N - 1; j++) {
				int curR = j;
				int curC = i;
				int curV = map[curR][curC];

				int nxtR = curR + 1;
				int nxtC = curC;
				// 2-1. 범위 안이면
				if ((nxtR >= 0 && nxtR < N) && (nxtC >= 0 && nxtC < N)) {
					int nxtV = map[nxtR][nxtC];

					// 2-2. 현재 값과 다음 값이 같으면
					// ex) 4=4, 0=0
					if (curV == nxtV) {
						map[nxtR][nxtC] = 0;
						map[curR][curC] = curV + nxtV;
					}
				}
			}

			// 3. 다시 위로 당기기
			for (int j = 0; j < N; j++) {
				if (map[j][i] == 0) {
					for (int z = j + 1; z < N; z++) {
						if (map[z][i] != 0) {
							int temp = map[z][i];
							map[z][i] = map[j][i];
							map[j][i] = temp;
							break;
						}
					}
				}
			}
		}
	}

	// 아래로 움직임
	public static void toDown(int[][] map, int N) {
		int i = -1;
		while (true) {
			i++;
			if (i == N)
				break;
			// 1. 아래로 당기기
			for (int j = N - 1; j > 0; j--) {
				if (map[j][i] == 0) {
					for (int z = j - 1; z >= 0; z--) {
						if (map[z][i] != 0) {
							int temp = map[z][i];
							map[z][i] = map[j][i];
							map[j][i] = temp;
							break;
						}
					}
				}
			}

			// 2. 한 번 합치기
			for (int j = N - 1; j > 0; j--) {
				int curR = j;
				int curC = i;
				int curV = map[curR][curC];

				int nxtR = curR - 1;
				int nxtC = curC;
				// 2-1. 범위 안이면
				if ((nxtR >= 0 && nxtR < N) && (nxtC >= 0 && nxtC < N)) {
					int nxtV = map[nxtR][nxtC];

					// 2-2. 현재 값과 다음 값이 같으면
					// ex) 4=4, 0=0
					if (curV == nxtV) {
						map[nxtR][nxtC] = 0;
						map[curR][curC] = curV + nxtV;
					}
				}
			}

			// 3. 다시 아래로 당기기
			for (int j = N - 1; j > 0; j--) {
				if (map[j][i] == 0) {
					for (int z = j - 1; z >= 0; z--) {
						if (map[z][i] != 0) {
							int temp = map[z][i];
							map[z][i] = map[j][i];
							map[j][i] = temp;
							break;
						}
					}
				}
			}
		}
	}

	// 왼쪽으로 움직임
	public static void toLeft(int[][] map, int N) {
		int i = -1;
		while (true) {
			i++;
			if (i == N)
				break;
			// 1. 왼쪽으로 당기기
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					for (int z = j + 1; z < N; z++) {
						if (map[i][z] != 0) {
							int temp = map[i][z];
							map[i][z] = map[i][j];
							map[i][j] = temp;
							break;
						}
					}
				}
			}

			// 2. 한 번 합치기
			for (int j = 0; j < N; j++) {
				int curR = i;
				int curC = j;
				int curV = map[curR][curC];

				int nxtR = curR;
				int nxtC = curC + 1;

				// 2-1. 범위 안이면
				if ((nxtR >= 0 && nxtR < N) && (nxtC >= 0 && nxtC < N)) {
					int nxtV = map[nxtR][nxtC];

					// 2-2. 현재 값과 다음 값이 같으면
					// ex) 4=4, 0=0
					if (curV == nxtV) {
						map[nxtR][nxtC] = 0;
						map[curR][curC] = curV + nxtV;
					}
				}
			}

			// 3. 다시 왼쪽으로 당기기
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					for (int z = j + 1; z < N; z++) {
						if (map[i][z] != 0) {
							int temp = map[i][z];
							map[i][z] = map[i][j];
							map[i][j] = temp;
							break;
						}
					}
				}
			}
		}
	}

	// 오른쪽으로 움직임
	public static void toRight(int[][] map, int N) {
		int i = -1;
		while (true) {
			i++;
			if (i == N)
				break;
			// 1. 오른쪽으로 당기기
			for (int j = N - 1; j > 0; j--) {
				if (map[i][j] == 0) {
					for (int z = j - 1; z >= 0; z--) {
						if (map[i][z] != 0) {
							int temp = map[i][z];
							map[i][z] = map[i][j];
							map[i][j] = temp;
							break;
						}
					}
				}
			}

			// 2. 한 번 합치기
			for (int j = N - 1; j > 0; j--) {
				int curR = i;
				int curC = j;
				int curV = map[curR][curC];

				int nxtR = curR;
				int nxtC = curC - 1;

				// 2-1. 범위 안이면
				if ((nxtR >= 0 && nxtR < N) && (nxtC >= 0 && nxtC < N)) {
					int nxtV = map[nxtR][nxtC];

					// 2-2. 현재 값과 다음 값이 같으면
					// ex) 4=4, 0=0
					if (curV == nxtV) {
						map[nxtR][nxtC] = 0;
						map[curR][curC] = curV + nxtV;
					}
				}
			}

			// 3. 다시 오른쪽으로 당기기
			for (int j = N - 1; j > 0; j--) {
				if (map[i][j] == 0) {
					for (int z = j - 1; z >= 0; z--) {
						if (map[i][z] != 0) {
							int temp = map[i][z];
							map[i][z] = map[i][j];
							map[i][j] = temp;
							break;
						}
					}
				}
			}
		}
	}
}