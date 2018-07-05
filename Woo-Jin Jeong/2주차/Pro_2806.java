import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pro_2806 {

		static int N;
		static int check[];
		static int cnt;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int x=1; x<=T; x++) {
			
			N = Integer.parseInt(in.readLine());
			
			//인덱스행의 x값 저장
			check = new int[N];
			cnt = 0;
		
					
				find(0);		
			
		
			
			System.out.println("#"+ x + " " + cnt);
		}
		
		
	}
	
	public static void find( int nexty){
		
		if( nexty == check.length) {
			
			cnt ++;	
			return;
		}
		
				for( int j=0; j<N; j++) {
					
					if(checkQueen(j, nexty)) {
						check[nexty] = j;
						find( nexty+1);						
					}
					
				}				
			
		
	
	}
	public static boolean checkQueen(int x, int y){
		
		for(int i=0; i<y; i++){			
			//직각위치 거나 대각위치에 있을 때  
			//x차이와 y차이는 같다 
			
			if(check[i] == x || Math.abs(i-y)== Math.abs(check[i] - x))
				return false;
		}
		
		return true;
	}

}
