import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No4301_PlantToTheMaximum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			String[] st = br.readLine().split(" ");
			int row = Integer.parseInt(st[1]);
			int col = Integer.parseInt(st[0]);
			int ans = 0;
			int rLimit, cLimit;
//			int[][] bean = new int[row][col];
			
			rLimit = (row == 1) ? 1 : row/2;
			cLimit = (col == 1) ? 1 : col/2;
			
			for(int i=0; i<rLimit; i++) {
				for(int j=0; j<cLimit; j++) {
					if(4*i < row) {
						if(4*j < col) {
//							bean[4*i][4*j] = 1;
							ans++;
						}
						if(4*j+1 < col) {
//							bean[4*i][4*j+1] = 1;
							ans++;
						}
					}
					if(4*i+1 < row) {
						if(4*j < col) {
//							bean[4*i+1][4*j] = 1;
							ans++;
						}
						if(4*j+1 < col) {
//							bean[4*i+1][4*j+1] = 1;
							ans++;
						}
					}
					if(4*i+2 < row) {
						if(4*j+2 < col) {
//							bean[4*i+2][4*j+2] = 1;
							ans++;
						}
						if(4*j+3 < col) {
//							bean[4*i+2][4*j+3] = 1;
							ans++;
						}
					}
					if(4*i+3 < row) {
						if(4*j+2 < col) {
//							bean[4*i+3][4*j+2] = 1;
							ans++;
						}
						if(4*j+3 < col) {
//							bean[4*i+3][4*j+3] = 1;
							ans++;
						}
					}
				}
			}
			
//			print(bean, row, col);			
			System.out.println("#" + t + " " + ans);
		}
	}
	
//	private static void print(int[][] bean, int row, int col) {
//		for(int i=0; i<row; i++) {
//			for(int j=0; j<col; j++) {
//				System.out.print(bean[i][j]);
//			}
//			System.out.println();
//		}
//	}
}