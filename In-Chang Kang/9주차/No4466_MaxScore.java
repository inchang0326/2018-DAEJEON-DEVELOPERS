import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No4466_MaxScore {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			
			ArrayList<Integer> score = new ArrayList<>();

			String[] st = br.readLine().split(" ");
			int N = Integer.parseInt(st[0]);
			int K = Integer.parseInt(st[1]);
			int max = 0;
			
			st = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				score.add(Integer.parseInt(st[i]));
			}
			
			Collections.sort(score, Collections.reverseOrder());
			for(int i=0; i<K; i++) {
				max += score.get(i);
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
