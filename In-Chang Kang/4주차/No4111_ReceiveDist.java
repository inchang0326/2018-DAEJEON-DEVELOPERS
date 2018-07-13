import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No4111_ReceiveDist {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			Set<Integer> set = new TreeSet<>();
			List<Integer> list;
			PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
			
			int n = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			int minDist = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			list = new ArrayList<>(set);

			for(int i=0; i<list.size() - 1; i++) {
				result.add(list.get(i+1) - list.get(i));
			}
			
			for(int i=0; i<k-1; i++) {
				result.poll();
			}
			
			for(int travel : result) {
				minDist += travel;
			}
			
			System.out.println("#" + t + " " + minDist);			
		}		
	}
}
