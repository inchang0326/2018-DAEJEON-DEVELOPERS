import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1228_EncryptedText {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1; t<=10; t++) {
			ArrayList<String> txt = new ArrayList<>();
			
			int len = Integer.parseInt(br.readLine());
			String[] st = br.readLine().split(" ");
			for(int i=0; i<len; i++) {
				txt.add(st[i]);
			}

			int numOfoI = Integer.parseInt(br.readLine());
			String[] st2 = br.readLine().split("I");
			for(int i=1; i<st2.length; i++) {
				String[] st3 = st2[i].split(" ");
				int loc = Integer.parseInt(st3[1]);			
				for(int j=3; j<st3.length; j++) {
					txt.add(loc++, st3[j]);
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<10; i++) {
				System.out.print(txt.get(i) + " ");
			}
			System.out.println();
		}		
	}
}
