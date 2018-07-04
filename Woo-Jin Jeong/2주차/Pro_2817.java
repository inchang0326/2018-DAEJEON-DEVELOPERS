import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pro_2817 {
	
		static int N,K;
		static int num[];
		static int result;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		String temp[];		
	
		for(int x=1; x<=T; x++)
		{
			temp = in.readLine().split(" ");
			
			N = Integer.parseInt( temp[0] );
			K = Integer.parseInt( temp[1] );
			
			temp = in.readLine().split(" ");
			
			num = new int[N];

			
			for(int i =0; i<N; i++)
			{
				num[i] = Integer.parseInt(temp[i]);
			}
			
			
			result = 0;
			
			//on
				dfs(1, 1, num[0]);

			
			//off
				dfs(1, 0, 0);
				
			
			System.out.println("#"+x+" "+result);
		}
	}
	
	public static void dfs(int curPos, int cnt, int sum) {
	
		
		
		
		if(curPos == N) {		
			
			if( sum == K && cnt >= 1) {
			
				
				/*for(int i=0; i<N; i++) {
					System.out.print(check[i]);
				}
				System.out.println();*/
				
									
				result+=1;			
				return;
			}
		}
		else {
		
		
		//on
		
			dfs(curPos+1, cnt+1, sum+num[curPos]);
	
			
		//off
			dfs(curPos+1, cnt, sum);
			
		}
		
	}

}
