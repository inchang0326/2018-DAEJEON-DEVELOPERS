package practice20180320;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 백준 15686번 치킨배달

public class BAEKJOON_15686 {

	private static ArrayList<Integer> anses;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] map = new int[N][N];
		ArrayList<Chicken> points = new ArrayList<>();
		ArrayList<Chicken> data = new ArrayList<>();
		anses = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j] == 2) {
					points.add(new Chicken(i, j));
				}
			}
		}
		
		data.add(points.get(0));
		dfs(points, data, 1, M, map, N);
		data.remove(points.get(0));
		dfs(points, data, 1, M, map, N);		

		Collections.sort(anses);
		System.out.println(anses.get(0));
	}
	
	public static void dfs(ArrayList<Chicken> points, ArrayList<Chicken> data, int idx, int M, int[][] map, int N) {
		if(data.size() == M) {
			int ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) {
						int result = getShortestDist(data, i, j);
						ans += result;
					}
				}
			}
			anses.add(ans);
			
			return ;
		}
		
		if(idx != points.size()) {
			data.add(points.get(idx));
			dfs(points, data, idx + 1, M, map, N);
			
			data.remove(points.get(idx));
			dfs(points, data, idx + 1, M, map, N);
		}
	}
	
	private static int getShortestDist(ArrayList<Chicken> data, int row, int col) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<data.size(); i++) {
			Chicken chickenPoint = data.get(i);
			int chickenRow = chickenPoint.getRow();
			int chickenCol = chickenPoint.getCol();
			
			int temp = getDist(row, chickenRow, col, chickenCol);
			if(temp < min) {
				min = temp;
			}
		}
		return min;
	}
	
	private static int getDist(int row, int row2, int col, int col2) {
		return Math.abs(row - row2) + Math.abs(col - col2);
	}
}

class Chicken {
	private int row, col;
	
	public Chicken(int row, int col) {
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
