import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2805_Harvest {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int sum = 0;
			
			for(int i=0; i<n; i++) {
				String st = br.readLine();
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
				}
			}
			
			for(int i=0; i<n; i++) {
				
				for(int j=n/2-i; j<=n/2+i && i<=n/2; j++) {
					sum += map[i][j];
				}

				for(int j=i-n/2; j<=n-1-(i-n/2) && i>n/2 ; j++) {
					sum += map[i][j];				
				}
			}
			
			System.out.println("#" + t + " " + sum);	
		}		
	}

}
