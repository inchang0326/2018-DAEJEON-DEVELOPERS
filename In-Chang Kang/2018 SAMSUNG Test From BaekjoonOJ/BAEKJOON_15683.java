import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//백준 15683번 감시

public class BAEKJOON_15683 {

	private static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");
		int row = Integer.parseInt(st[0]);
		int col = Integer.parseInt(st[1]);
		int blank = 0;
		
		ArrayList<CCTV> cctvs = new ArrayList<>();
		
		int[][] map = new int[row][col];
		
		for(int i=0; i<row; i++) {
			st = br.readLine().split(" ");
			for(int j=0; j<col; j++) {
				map[i][j] = Integer.parseInt(st[j]);
				if(map[i][j] > 0 && map[i][j] < 6)
					cctvs.add(new CCTV(i, j, map[i][j]));
				else if(map[i][j] == 0)
					blank++;
			}
		}
		
		dfs(cctvs, 0, map, row, col, 0);
		System.out.println(blank - max);
	}
	
	private static int[][] makeCopy(int[][] map, int row, int col) {
		int[][] copied = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				copied[i][j] = map[i][j];
			}
		}
		return copied;
	}
	
	public static void dfs(ArrayList<CCTV> cctvs, int idx, int[][] map, int row, int col, int cnt) {
		if(idx == cctvs.size()) {
			if(cnt > max) {
				max = cnt;
			}
			return ;
		}
		
		CCTV curCCTV = cctvs.get(idx);
		int curRow = curCCTV.getRow();
		int curCol = curCCTV.getCol();
		
		switch(curCCTV.getSortOf()) {
			case 1 : { // 1번 감시카메라
				for(int i=0; i<4; i++) {
					int temp = 0;
					int[][] copied = makeCopy(map, row, col);		
				
					if(i == 0) { // 상
						
						temp = monitorUp(copied, curRow, curCol);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 1) { // 좌
						
						temp = monitorLeft(copied, curRow, curCol);						
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 2) { // 하
						
						temp = monitorDown(copied, curRow, curCol, row);						
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 3) { // 우

						temp = monitorRight(copied, curRow, curCol, col);						
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);

					}
				}
				break;
			}
			case 2 : { // 2번 감시카메라
				for(int i=0; i<2; i++) {
					int temp = 0;
					int[][] copied = makeCopy(map, row, col);		
				
					if(i == 0) { // 상, 하
						
						temp = monitorUp(copied, curRow, curCol);
						temp += monitorDown(copied, curRow, curCol, row);						
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 1) { // 좌, 우
						
						temp = monitorLeft(copied, curRow, curCol);	
						temp += monitorRight(copied, curRow, curCol, col);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					}
				}			
				break;
			}
			case 3 : {  // 3번 감시카메라
				for(int i=0; i<4; i++) {
					int temp = 0;
					int[][] copied = makeCopy(map, row, col);		
					if(i == 0) { // 상, 우
						
						temp = monitorUp(copied, curRow, curCol);
						temp += monitorRight(copied, curRow, curCol, col);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 1) { // 상, 좌
						
						temp = monitorUp(copied, curRow, curCol);
						temp += monitorLeft(copied, curRow, curCol);	
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 2) { // 하, 좌
						
						temp = monitorDown(copied, curRow, curCol, row);
						temp += monitorLeft(copied, curRow, curCol);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 3) { // 하, 우
						
						temp = monitorDown(copied, curRow, curCol, row);
						temp += monitorRight(copied, curRow, curCol, col);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					}
				}				
				break;
			}
			case 4 : { // 4번 감시카메라
				for(int i=0; i<4; i++) {
					int temp = 0;
					int[][] copied = makeCopy(map, row, col);		
					if(i == 0) { // 상, 우, 좌
						
						temp = monitorUp(copied, curRow, curCol);
						temp += monitorRight(copied, curRow, curCol, col);
						temp += monitorLeft(copied, curRow, curCol);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 1) { // 상, 좌, 하
						
						temp = monitorUp(copied, curRow, curCol);
						temp += monitorLeft(copied, curRow, curCol);
						temp += monitorDown(copied, curRow, curCol, row);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 2) { // 하, 좌, 우
						
						temp = monitorDown(copied, curRow, curCol, row);
						temp += monitorLeft(copied, curRow, curCol);
						temp += monitorRight(copied, curRow, curCol, col);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					} else if(i == 3) { // 하, 우, 상
						
						temp = monitorDown(copied, curRow, curCol, row);
						temp += monitorRight(copied, curRow, curCol, col);
						temp += monitorUp(copied, curRow, curCol);
						dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
						
					}
				}				
				break;
			}
			case 5 : { // 5번 감시카메라
				int temp = 0;
				int[][] copied = makeCopy(map, row, col);
				
				temp = monitorUp(copied, curRow, curCol);
				temp += monitorLeft(copied, curRow, curCol);
				temp += monitorDown(copied, curRow, curCol, row);
				temp += monitorRight(copied, curRow, curCol, col);
				dfs(cctvs, idx + 1, copied, row, col, cnt + temp);
				
				break;
			}
		}
	}
	
	private static int monitorUp(int[][] target, int curRow, int curCol) {
		int cnt = 0;
		for(int j=curRow-1; j>=0; j--) {
			if(target[j][curCol] == 6) 
				break;
			if(target[j][curCol] == 0) {
				target[j][curCol] = 10;
				cnt++;
			}
		}
		return cnt;
	}
	
	private static int monitorLeft(int[][] target, int curRow, int curCol) {
		int cnt = 0;
		for(int j=curCol-1; j>=0; j--) {
			if(target[curRow][j] == 6) 
				break;
			if(target[curRow][j] == 0) {
				target[curRow][j] = 10;
				cnt++;
			}
		}
		return cnt;
	}
	
	private static int monitorDown(int[][] target, int curRow, int curCol, int row) {
		int cnt = 0;
		for(int j=curRow+1; j<row; j++) {
			if(target[j][curCol] == 6) 
				break;
			if(target[j][curCol] == 0) {
				target[j][curCol] = 10;
				cnt++;
			}
		}
		return cnt;
	}
	
	private static int monitorRight(int[][] target, int curRow, int curCol, int col) {
		int cnt = 0;
		for(int j=curCol+1; j<col; j++) {
			if(target[curRow][j] == 6) 
				break;
			if(target[curRow][j] == 0) {
				target[curRow][j] = 10;
				cnt++;
			}
		}
		return cnt;
	}
}

class CCTV {
	private int row, col, sortOf;
	
	public CCTV(int row, int col, int sortOf) {
		this.row = row;
		this.col = col;
		this.sortOf = sortOf;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getSortOf() {
		return sortOf;
	}
}