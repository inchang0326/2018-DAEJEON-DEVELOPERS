import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class No2806_NQueen {
	
	private static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int size = Integer.parseInt(br.readLine());
			
			boolean[][] queenLoc = new boolean[size][size];
					
			for(int i=0; i<size; i++) {
				Point p = new Point(i, 0);
				dfs(queenLoc, size, p);
				
				queenLoc = new boolean[size][size];
//				System.out.println("restart!!!!!!!!!!!!!!");
			}
			
			System.out.println("#" + t + " " + cnt);
			cnt = 0;
		}
	}
	
	public static void dfs(boolean[][] queenLoc, int size, Point p) {
		
		if(p.getCol() == size-1) {
			cnt++;
			return ;
		}
		
		queenLoc[p.getRow()][p.getCol()] = true;			

		for(int i=0; i<size; i++) {
			Point temp = new Point(i, p.getCol() + 1);
//			System.out.println(temp.getRow() + " " + temp.getCol());
			if(isPromising(queenLoc, size, temp)) {
//				System.out.println("@@@@@@@@@@@" + temp.getRow() + " " + temp.getCol());
				dfs(queenLoc, size, temp);
				queenLoc[temp.getRow()][temp.getCol()] = false;			
			}
		}
	}
	
	public static boolean isPromising(boolean[][] queenLoc, int size, Point p) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(queenLoc[i][j]) {
					// 같은 행
					if(i == p.getRow()) return false;
					// 같은 열
					if(j == p.getCol()) return false;
					// 대각선
					if(Math.abs(i - p.getRow()) == Math.abs(j - p.getCol())) return false;
				}
			}
		}
		
		return true;
	}
}
