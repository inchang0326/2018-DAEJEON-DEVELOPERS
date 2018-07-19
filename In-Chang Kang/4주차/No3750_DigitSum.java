import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No3750_DigitSum {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			String num = br.readLine();
			
			while(num.length() != 1) {
				num = itos(addition(num));
			}
			
			System.out.println("#" + t + " " + num);
		}
	}

	public static int addition(String num) {
		int sum = 0;
		for(int i=0; i<num.length(); i++) {
			sum += Integer.parseInt(String.valueOf(num.charAt(i)));
		}
		return sum;
	}
	
	public static String itos(int num) {
		return String.valueOf(num);
	}
}
