import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No1256_Desinence {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			
			ArrayList<String> list = new ArrayList<>(); 
			
			int num = Integer.parseInt(br.readLine());
			String txt = br.readLine();
			
			for(int i=txt.length(); i>0; i--) {
				list.add(txt.substring(i-1, txt.length()));
			}
			
			Collections.sort(list);
			
			System.out.println("#" + t + " " + list.get(num-1));
		}
	}
}
