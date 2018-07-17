import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Pro_1859 {

		static int N;
		static int price[];		
		static long result;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int x=1; x<=T; x++) {
			N = Integer.parseInt(in.readLine());
			
			price = new int[N];
			String temp[];
			temp = in.readLine().split(" ");
			for(int i=0; i<N; i++) {
				price[i] = Integer.parseInt(temp[i]);
			}
			result = 0;
			int temMax = 0;
			for(int i=N-1; i>=0; i--) {
				if(temMax > price[i])
					result += temMax - price[i];
				else
					temMax = price[i];
				
				
			}
			
			System.out.println("#"+x+" "+result);
			
		}
		
		
	}

}
