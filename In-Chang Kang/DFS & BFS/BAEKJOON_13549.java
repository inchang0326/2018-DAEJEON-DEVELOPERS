import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Catch3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bfs(n, k);
	}
	
	public static void bfs(int n, int k) {		
		Queue<Subin> q = new ArrayDeque<>();
		
		boolean[] isVisited = new boolean[100000 + 1];
		int minTime = Integer.MAX_VALUE;
		
		Subin start = new Subin();
		start.setCurrLoc(n);
		start.setTime(0);
		q.add(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				
				Subin currSubin = q.poll();
				int currLoc = currSubin.getCurrLoc();
				int currTime = currSubin.getTime();

				isVisited[currLoc] = true;

				if(currLoc == k) {
					if(currTime < minTime)
						minTime = currTime;
				}
				
				if( currLoc - 1 >= 0 && !isVisited[currLoc - 1] ) {
					Subin nextSubin = new Subin();
					nextSubin.setCurrLoc(currLoc - 1);
					nextSubin.setTime(currTime + 1);
					q.add(nextSubin);
				}
				
				if( currLoc + 1 <= 100000 && !isVisited[currLoc + 1] ) {
					Subin nextSubin = new Subin();
					nextSubin.setCurrLoc(currLoc + 1);
					nextSubin.setTime(currTime + 1);
					q.add(nextSubin);
				}
				
				if( currLoc * 2 <= 100000 && !isVisited[currLoc * 2] ) {
					Subin nextSubin = new Subin();
					nextSubin.setCurrLoc(currLoc * 2);
					nextSubin.setTime(currTime);
					q.add(nextSubin);
				}
			}
			if(minTime != Integer.MAX_VALUE) break;
		}

		System.out.println(minTime);
	}
}

class Subin {
	private int currLoc;
	private int time;
	
	public Subin() {
		
	}
	public int getCurrLoc() {
		return currLoc;
	}
	public void setCurrLoc(int currLoc) {
		this.currLoc = currLoc;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}