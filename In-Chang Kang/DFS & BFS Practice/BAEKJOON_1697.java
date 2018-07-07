import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Catch {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(n, k));
	}
	
	public static int bfs(int n, int k) {		
		Queue<Integer> q = new ArrayDeque<>();
		
		boolean[] isVisited = new boolean[100000 + 1];
		int sec = 0;
		
		q.add(n);
		while(q.size() > 0) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int currLoc = q.poll();

				isVisited[currLoc] = true;

				if(currLoc == k) {
					return sec;
				}
				
				if( currLoc - 1 >= 0 && !isVisited[currLoc - 1] ) q.add(currLoc - 1);
				if( currLoc + 1 <= 100000 && !isVisited[currLoc + 1] ) q.add(currLoc + 1);
				if( currLoc * 2 <= 100000 && !isVisited[currLoc * 2] ) q.add(currLoc * 2);
			}
			sec++;
		}
		
		return -1;
	}
}