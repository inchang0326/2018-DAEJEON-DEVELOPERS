import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Pro_4111 {

		static int N,K;

		static int input[];
		static int result[];

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int x=1; x<=T; x++) {
			
			N = Integer.parseInt(in.readLine());
			K = Integer.parseInt(in.readLine());			
			
			String temp[];
			temp = in.readLine().split(" ");
		
			input = new int[N];
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(temp[i]);
			}		
			Arrays.sort(input);
			
			result = new int[N-1];			
			for(int i=0; i< result.length; i++) {
				result[i] = input[i+1]-input[i];
			}			
			Arrays.sort(result);
			
						
			int total=0;			
			if( N <= K) {
				total = 0;
			}else {
				for(int i=0; i<N-K; i++) {
					total += result[i];
				}
			}
			
			System.out.println("#"+x+" "+total);
		}
	
		
	}


}
