import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1860_FishshapedBun {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			int[] person = new int[11112];
			boolean flag = true;
			
			String[] st = br.readLine().split(" ");
			int N = Integer.parseInt(st[0]);
			int M = Integer.parseInt(st[1]);
			int K = Integer.parseInt(st[2]);
			
			Machine machine = new Machine(M, K);

			String[] st2 = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				person[Integer.parseInt(st2[i])]++;
			}			
			
			for(int time=0; time<11112; time++) {
				machine.working(time);

				if(person[time] != 0) {
					if(machine.acceptable(person[time])) {
						machine.serve(person[time]);
					} else {
						flag = false;
						break;
					}
				}
			}
			
			String ans = "";
			if(flag) 
				ans = "Possible";
			else 
				ans = "Impossible";
			
			System.out.println("#" + t + " " + ans);
		}		
	}
}

class Machine {
	private int bun;
	private int M, K;
	
	public Machine(int M, int K) {
		this.M = M;
		this.K = K;
	}
	
	public void working(int time) {
		if(time != 0 && time % M == 0) 
			bun += K;
	}
	
	public boolean acceptable(int person) {
		if(bun >= person)
			return true;
		else 
			return false;
	}
	
	public void serve(int person) {
		bun -= person;
	}
}