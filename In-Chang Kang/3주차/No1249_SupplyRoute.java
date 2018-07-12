import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No1249_SupplyRoute {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		PriorityQueue<Road> queue;
		
		int n;
		int[][] map;
		boolean[][] isVisited;
		int[] dirRow = {1, -1, 0, 0};
		int[] dirCol = {0, 0, -1, 1};
		int repairTime;
		
		for(int t=1; t<=testCase; t++) {
	
			queue = new PriorityQueue<Road>();
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			isVisited = new boolean[n][n];
			repairTime = 0;
			
			for(int i=0; i<n; i++) {
				String st = br.readLine();
				for(int j=0; j<n; j++) {				
					map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
				}
			}
			
			queue.add(new Road(0, 0, 0));
			while(!queue.isEmpty()) {
				
				Road currRoad = queue.poll();
				int currRow = currRoad.getRow();
				int currCol = currRoad.getCol();
				repairTime = currRoad.getRepair();
				
				if(currRow == n-1 && currCol == n-1) {				
					break;
				}
				
				for(int i=0; i<4; i++) {
					
					int nextRow = currRow + dirRow[i];
					int nextCol = currCol + dirCol[i];
					
					if( (nextRow >= 0 && nextRow < n) && (nextCol >= 0 && nextCol < n) ) {
						if(!isVisited[nextRow][nextCol]) {
							isVisited[nextRow][nextCol] = true;
							queue.add(new Road(nextRow, nextCol, repairTime + map[nextRow][nextCol]));						
						}
					}

				}
			}
			System.out.println("#" + t + " " + repairTime);
		}
	}
	
}

class Road implements Comparable<Road> {
	private int row, col, repair;

	public Road() {
		
	}
	
	public Road(int row, int col, int repair) {
		this.row = row;
		this.col = col;
		this.repair = repair;
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

	public int getRepair() {
		return repair;
	}
	
	public void setRepair(int repair) {
		this.repair = repair;
	}
	
	@Override
	public int compareTo(Road road) {
		if(repair < road.repair)
			return -1;
		else 
			return 1;
	}
}
