import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class No1227_Maze {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=0; t<10; t++) {
			int testCase = Integer.parseInt(br.readLine());
			
			int[][] map = new int[100][100];
			boolean[][] isVisited = new boolean[100][100];
			
			for(int i=0; i<100; i++) {
				String st = br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
					if(map[i][j] == 1) {
							isVisited[i][j] = true;
					}
				}
			}
			
			System.out.println("#" + testCase + " " + escape(map, isVisited));			
		}
	}
	
	public static int escape(int[][] map, boolean[][] isVisited) {

		Queue<Way> queue = new ArrayDeque<>();
		
		int[] dirRow = {-1, 0, 1, 0};
		int[] dirCol = {0, 1, 0, -1};

		queue.add(new Way(1, 1));
		
		while(!queue.isEmpty()) {
			
			Way curr = queue.poll();
			int currRow = curr.getRow();
			int currCol = curr.getCol();
			isVisited[currRow][currCol] = true;
			
			if(map[currRow][currCol] == 3) {
				return 1;
			}
			
			for(int i=0; i<4; i++) {
				
				int nextRow = currRow + dirRow[i];
				int nextCol = currCol + dirCol[i];
				
				if( !isVisited[nextRow][nextCol] ) {
					queue.add(new Way(nextRow, nextCol));
				}			
			}
		}
		return 0;
	}
}

class Way {
	private int row, col;

	public Way() {
		
	}
	
	public Way(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
