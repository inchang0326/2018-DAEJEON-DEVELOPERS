import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// 연구소

public class BAEKJOON_14502 {

	private static int ans = -1;
	private static final int LIMIT = 3;
	private static Queue<Birus> biruses = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int row = Integer.parseInt(st[0]);
		int col = Integer.parseInt(st[1]);
		int[][] map = new int[row][col];
		
		for(int i=0; i<row; i++) {
			st = br.readLine().split(" ");
			for(int j=0; j<col; j++) {
				map[i][j] = Integer.parseInt(st[j]);
				if(map[i][j] == 2)
					biruses.add(new Birus(i, j));
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j] == 0) {
					int[][] copied = new int[row][col];
					copyArray(copied, map, row, col);
					
					copied[i][j] = 1;
					
					dfs(copied, row, col, 1);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int[][] map, int row, int col, int idx) {
		if(idx == LIMIT) {
			// 1. 2를 펼친다.
			int[] dirR = new int[] {-1, 1, 0, 0};
			int[] dirC = new int[] {0, 0, -1, 1};
			ArrayList<Birus> temp = new ArrayList<>();
			for(Birus b : biruses) {
				temp.add(b);
			}
			
			while(!biruses.isEmpty()) {
				Birus curB = biruses.poll();
				int curR = curB.getRow();
				int curC = curB.getCol();
				
				for(int i=0; i<4; i++) {
					int nxtR = curR + dirR[i];
					int nxtC = curC + dirC[i];
					
					// 범위 안에 있고, 빈 공간이라면 바이러스를 채워나간다.
					if((nxtR >=0 && nxtR < row) && (nxtC >=0 && nxtC < col) && map[nxtR][nxtC] == 0) {
						map[nxtR][nxtC] = 2;
						biruses.add(new Birus(nxtR, nxtC));
					}
				}
			}
			
			for(Birus b : temp) {
				biruses.add(b);
			}
			
			// 2. 0의 개수를 카운팅한다.
			int cnt = 0;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(map[i][j] == 0)
						cnt++;
				}
			}
			
			// 3. 최대 0의 개수를 답으로 정한다.
			if(ans < cnt)
				ans = cnt;
			
			return ;
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j] == 0) {
					int[][] copied = new int[row][col];
					copyArray(copied, map, row, col);
					
					copied[i][j] = 1;
					
					dfs(copied, row, col, idx + 1);
				}
			}
		}
	}
	
	public static void copyArray(int[][] copied, int[][] map, int row, int col) {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				copied[i][j] = map[i][j];
			}
		}
	}
}

class Birus {
	private int row, col;
	public Birus(int row, int col) {
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