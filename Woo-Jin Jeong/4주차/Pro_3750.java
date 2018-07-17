import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pro_3750 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		for(int x=1; x<=T; x++) {
			
			String n = in.readLine();
			int temp;
			while(n.length() != 1) {
				
				temp = 0;
				
				for(int i=0; i<n.length(); i++) {
					temp += Integer.parseInt(n.charAt(i)+"");
				}
				n = Integer.toString(temp);
			}
			
			out.write("#"+x + " "+n+"\n");
			out.flush();
			
			
		}	
		out.close();
	}

}
