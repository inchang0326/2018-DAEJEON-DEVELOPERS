import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1234_Password {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			String[] st = br.readLine().split(" ");
			
			int numOf = Integer.parseInt(st[0]);
			String txt = st[1];
			for(int i=0; i<txt.length()-1; i++) {
				if(txt.charAt(i) == txt.charAt(i+1)) {
					String left = txt.substring(0, i);
					String right = txt.substring(i+2, txt.length());
					txt = left + right;
					i = -1;
				}
			}
			
			System.out.println("#" + t + " " + txt);			
		}
	}
}
