import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1218_braceMatching {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int validationChk = 0;
			
			int[] numberOf = new int[8];
			int size = Integer.parseInt(br.readLine());
			String st = br.readLine();
			for (int i = 0; i < size; i++) {
				switch (st.charAt(i)) {
				case '(': {
					numberOf[0]++;
					break;
				}
				case ')': {
					numberOf[1]++;
					break;
				}
				case '[': {
					numberOf[2]++;
					break;
				}
				case ']': {
					numberOf[3]++;
					break;
				}
				case '{': {
					numberOf[4]++;
					break;
				}
				case '}': {
					numberOf[5]++;
					break;
				}
				case '<': {
					numberOf[6]++;
					break;
				}
				case '>': {
					numberOf[7]++;
					break;
				}
				}
			}
			
			if(numberOf[0] == numberOf[1] && numberOf[2] == numberOf[3] 
					&& numberOf[4] == numberOf[5] && numberOf[6] == numberOf[7]) {
				validationChk = 1;
			}
			
			System.out.println("#" + t + " " + validationChk);
		}
	}

}
