import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1211_Ladder2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			int testCase = Integer.parseInt(br.readLine());
			
			int[][] map = new int[100][100];
			boolean[][] isVisited = new boolean[100][100];
			for(int i=0; i<100; i++) {
				String[] st = br.readLine().split(" ");
				for(int j=0; j<st.length; j++) {
					map[i][j] = Integer.parseInt(st[j]);
					if(map[i][j] == 0) {
						isVisited[i][j] = true;
					}
				}
			}		

			int minIdx = 0;
			for(int i=1; i<100; i++) {
				if(map[0][i] == 1) {
					if(go(map, isVisited, minIdx) >= go(map, isVisited, i)) {
						minIdx = i;
					}
				}
			}
			
			System.out.println("#" + testCase + " " + minIdx);
		}
	}
	
	public static int go(int[][] map, boolean[][] isVisited, int idx) {
		ArrayList<Visited> visited = new ArrayList<>();
		int[] dirRow = {0, 0, 1};
		int[] dirCol = {-1, 1, 0};
		int result = 1, currRow = 0, currCol = idx;
		
		isVisited[currRow][currCol] = true;
		while(currRow != 99) {
			for(int i=0; i<3; i++) {
				int nextRow = currRow + dirRow[i];
				int nextCol = currCol + dirCol[i];
			
				if(inRange(nextRow, nextCol) && !isVisited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
					result += map[nextRow][nextCol];
					isVisited[nextRow][nextCol] = true;
					visited.add(new Visited(nextRow, nextCol));
					currRow = nextRow;
					currCol = nextCol;
					break;					
				}
			}
		}
		
		for(int i=0; i<visited.size(); i++) {
			isVisited[visited.get(i).getRow()][visited.get(i).getCol()] = false;	
		}
		
		return result;
	}
	
	private static boolean inRange(int row ,int col) {
		return (row >= 0 && row < 100) && (col >= 0 && col < 100);
	}
}

class Visited {
	int row, col;
	
	public Visited(int row, int col) {
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
