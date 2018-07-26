import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pro_1204 {

		static int score[];		
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(in.readLine());
		for(int x=1; x<=T; x++){
			int num = Integer.parseInt(in.readLine());
			String temp[] = in.readLine().split(" ");
			
			score = new int[101];
			
			for(int i=0; i<1000; i++) {
				score[Integer.parseInt(temp[i])] +=1;
			}
			
			int max = -1;
			int result = 0;
			for(int i=100; i>=0; i--) {
				if(score[i] > max) {
					max = score[i];
					result = i;
				}
			}
			
			System.out.println("#"+x+" "+result);
		}
	}

}
