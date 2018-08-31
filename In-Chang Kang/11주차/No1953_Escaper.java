import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class No1953_Escaper {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			String[] st = br.readLine().split(" ");
			int row = Integer.parseInt(st[0]);
			int col = Integer.parseInt(st[1]);
			int sRow = Integer.parseInt(st[2]);
			int sCol = Integer.parseInt(st[3]);
			int time = Integer.parseInt(st[4]);
			int[][] map = new int[row][col];
			boolean[][] isVisited = new boolean[row][col];

			for (int i = 0; i < row; i++) {
				st = br.readLine().split(" ");
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st[j]);
				}
			}

			int ans = bfs(map, isVisited, sRow, sCol, row, col, time);

			System.out.println("#" + t + " " + ans);
		}
	}

	public static int bfs(int[][] map, boolean[][] isVisited, int sRow, int sCol, int lRow, int lCol, int time) {
		Queue<Escaper> queue = new ArrayDeque<>();
		int[] dRow = null, dCol = null;
		int repeat = 0;
		int cnt = 1;

		queue.add(new Escaper(sRow, sCol));
//		System.out.println(sRow + ", " + sCol);
		isVisited[sRow][sCol] = true;
		while (!queue.isEmpty()) {
			time--;
			if (time == 0) {
				break;
			}

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Escaper cEscaper = queue.poll();
				int cRow = cEscaper.getRow();
				int cCol = cEscaper.getCol();

//				System.out.println("value : " + map[cRow][cCol] + ", time : " + time);
				switch (map[cRow][cCol]) {
				case 1: {
					dRow = new int[] { -1, 1, 0, 0 };
					dCol = new int[] { 0, 0, -1, 1 };
					repeat = 4;
					break;
				}
				case 2: {
					dRow = new int[] { -1, 1 };
					dCol = new int[] { 0, 0 };
					repeat = 2;
					break;
				}
				case 3: {
					dRow = new int[] { 0, 0 };
					dCol = new int[] { -1, 1 };
					repeat = 2;
					break;
				}
				case 4: {
					dRow = new int[] { -1, 0 };
					dCol = new int[] { 0, 1 };
					repeat = 2;
					break;
				}
				case 5: {
					dRow = new int[] { 1, 0 };
					dCol = new int[] { 0, 1 };
					repeat = 2;
					break;
				}
				case 6: {
					dRow = new int[] { 1, 0 };
					dCol = new int[] { 0, -1 };
					repeat = 2;
					break;
				}
				case 7: {
					dRow = new int[] { -1, 0 };
					dCol = new int[] { 0, -1 };
					repeat = 2;
					break;
				}
				default: {
					repeat = 0;
					break;
				}
				}
				for (int j = 0; j < repeat; j++) {
					int nRow = cRow + dRow[j];
					int nCol = cCol + dCol[j];

					if ((nRow >= 0 && nRow < lRow) && (nCol >= 0 && nCol < lCol)) {
						if (!isVisited[nRow][nCol] && map[nRow][nCol] != 0
								&& isConnected(dRow[j], dCol[j], map[cRow][cCol], map[nRow][nCol])) {
							isVisited[nRow][nCol] = true;
							queue.add(new Escaper(nRow, nCol));
//							System.out.println("방향 : " + dRow[j] + ", " + dCol[j] + ", " + map[nRow][nCol]);
//							System.out.println("추가 : " + nRow + ", " + nCol);
							cnt++;
						}
					}
				}

			}
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}

		return cnt;
	}

	private static boolean isConnected(int dRow, int dCol, int one, int another) {
		if (dRow == -1 && dCol == 0) {
			if (one == 1 && (another == 1 || another == 2 || another == 5 || another == 6)) return true;
			if (one == 2 && (another == 2 || another == 1 || another == 5 || another == 6)) return true;
			if ((one == 4 || one == 7) && (another == 1 || another == 2 || another == 5 || another == 6)) return true;
		} else if (dRow == 1 && dCol == 0) {
			if (one == 1 && (another == 1 || another == 2 || another == 4 || another == 7)) return true;
			if (one == 2 && (another == 1 || another == 2 || another == 4 || another == 7)) return true;
			if ((one == 5 || one == 6) && (another == 1 || another == 2 || another == 4 || another == 7)) return true;
		} else if (dRow == 0 && dCol == -1) {
			if ((one == 1 || one == 3 || one == 6 || one == 7) && (another == 1 || another == 3 || another == 4 || another == 5)) return true;
		} else if (dRow == 0 && dCol == 1) {
			if ((one == 1 || one == 3 || one == 4 || one == 5) && (another == 1 || another == 3 || another == 6 || another == 7)) return true;
		}
		return false;
	}
}

class Escaper {
	int row, col;

	public Escaper(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}