import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Catch2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bfs(n, k);
	}
	
	public static void bfs(int n, int k) {		
		Queue<Integer> q = new ArrayDeque<>();
		
		boolean[] isVisited = new boolean[100000 + 1];
		int time = 0, step = 0;
		
		q.add(n);
		while(q.size() > 0) {
			
			int size = q.size();
			
			for(int i=0; i<size; i++) {

				int curr = q.poll();
				isVisited[curr] = true;

				if(curr == k) {
					time++;
				}
				
				if( curr - 1 >= 0 && !isVisited[curr - 1] ) q.add(curr - 1);
				if( curr + 1 <= 100000 && !isVisited[curr + 1] ) q.add(curr + 1);
				if( curr * 2 <= 100000 && !isVisited[curr * 2] ) q.add(curr * 2);
				
			}
			
			if(time != 0) break;
			step++;
		}
		
		System.out.println(step + "\n" + time);
	}
}