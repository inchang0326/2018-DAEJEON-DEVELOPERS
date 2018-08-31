import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No5356_SpeakVertically {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			String ans = "";
			String[][] input = new String[5][15];
			int maxLength = 0;
			
			for(int i=0; i<5; i++) {
				String[] st = br.readLine().split("");
				for(int j=0; j<st.length; j++) {
					input[i][j] = st[j];
				}
				int temp = st.length;
				if(temp > maxLength) {
					maxLength = temp;
				}
			}
			
			for(int i=0; i<maxLength; i++) {
				for(int j=0; j<5; j++) {
					if(input[j][i] != null)
						ans += input[j][i];
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
