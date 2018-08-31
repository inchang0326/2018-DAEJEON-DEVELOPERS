import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class No1949_HikingTrail_BFS {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			
			String[] st = br.readLine().split(" ");
			int N = Integer.parseInt(st[0]);
			int K = Integer.parseInt(st[1]);
			int maxValue = 0, longestHikingTrail = 0;
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st[j]);
					if(map[i][j] > maxValue) {
						maxValue = map[i][j];
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == maxValue) {
						int temp = BFS(map, i, j, N, K);
						if(temp > longestHikingTrail) {
							longestHikingTrail = temp;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + longestHikingTrail);			
		}
	}
	
	public static int BFS(int[][] map, int startRow, int startCol, int N, int K) {
		Queue<Hiker> queue = new ArrayDeque<>();
		int[] dirRow = {-1, 1, 0, 0};
		int[] dirCol = {0, 0, -1, 1};
		int cnt = 0;

		queue.add(new Hiker(map, N, startRow, startCol));
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for(int i=0; i<size; i++) {

				Hiker curHiker = queue.poll();
				int curRow = curHiker.getRow();
				int curCol = curHiker.getCol();
				int curValue = curHiker.getValue();
				boolean curSign = curHiker.doesConstruction();
				
				for(int j=0; j<4; j++) {
					int nxtRow = curRow + dirRow[j];
					int nxtCol = curCol + dirCol[j];
					
					if((nxtRow >= 0 && nxtRow < N) && (nxtCol >= 0 && nxtCol < N)) {
						if(!curHiker.isVisited(nxtRow, nxtCol)) {
							Hiker nxtHiker = new Hiker();
							if(curValue > curHiker.getMapValue(nxtRow, nxtCol)) {
								nxtHiker.setRow(nxtRow);
								nxtHiker.setCol(nxtCol);
								nxtHiker.setMaps(curHiker.getValueMap(), curHiker.getVisitMap());
								nxtHiker.visit(nxtRow, nxtCol);
								if(curSign) {
									nxtHiker.setConstruction(true);
								} else {
									nxtHiker.setConstruction(false);
								}
								queue.add(nxtHiker);
							} else if(curValue > curHiker.getMapValue(nxtRow, nxtCol) - K && !curSign) {
								nxtHiker.setRow(nxtRow);
								nxtHiker.setCol(nxtCol);
								nxtHiker.setMaps(curHiker.getValueMap(), curHiker.getVisitMap());
								nxtHiker.visit(nxtRow, nxtCol);
								nxtHiker.setMapValue(nxtRow, nxtCol, curValue - 1);
								nxtHiker.setConstruction(true);	
								queue.add(nxtHiker);
							}
						}
					}
				}
			}
			
			cnt++;
		}
		
		return cnt;
	}
}

class Hiker {
	private int row, col;
	private boolean construction;
	private int[][] map;
	private boolean[][] isVisited;
	
	public Hiker() {
		
	}
	
	public Hiker(int[][] map, int N, int row, int col) {
		this.map = new int[N][N];
		this.isVisited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				this.map[i][j] = map[i][j];
			}
		}
		this.row = row;
		this.col = col;
		visit(row, col);
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
	
	public int getValue() {
		return map[row][col];
	}
	
	public int getMapValue(int row, int col) {
		return map[row][col];
	}
	
	public void setMapValue(int row, int col, int value) {
		map[row][col] = value;
	}
	
	public void setMaps(int[][] map, boolean[][] isVisited) {
		int size = map.length;
		this.map = new int[size][size];
		this.isVisited = new boolean[size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				this.map[i][j] = map[i][j];
			}
		}
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				this.isVisited[i][j] = isVisited[i][j];
			}
		}
	}
	
	public int[][] getValueMap() {
		return map;
	}
	
	public boolean[][] getVisitMap() {
		return isVisited;
	}
	
	public void visit(int row, int col) {
		isVisited[row][col] = true;
	}
	
	public boolean isVisited(int row, int col) {
		return isVisited[row][col];
	}
	
	public boolean doesConstruction() {
		return construction;
	}

	public void setConstruction(boolean construction) {
		this.construction = construction;
	}
}