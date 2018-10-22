import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] adjMatrix;
		boolean[] isVisited;
		int n, m, v;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		adjMatrix = new int[n+1][n+1];
		isVisited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		dfs(adjMatrix, isVisited, n, v);
		System.out.println();
		isVisited = new boolean[n+1];
		bfs(adjMatrix, isVisited, n, v);
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] isVisited, int size, int from) {
		if(!isVisited[from]) {
			System.out.print(from + " ");
			isVisited[from] = true;
			for(int i=1; i<=size; i++) {
				if(adjMatrix[from][i] == 1) {
					dfs(adjMatrix, isVisited, size, i);
				}
			}
		}
	}
	
	public static void bfs(int[][] adjMatrix, boolean[] isVisited, int size, int from) {		
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(from);
		isVisited[from] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();

			System.out.print(curr + " ");
			
			for(int i=1; i<=size; i++) {
				if( (adjMatrix[curr][i] == 1) && !isVisited[i] ) {
					int next = i;
					q.add(next);
					isVisited[next] = true;
				}
			}
		}
	}
}