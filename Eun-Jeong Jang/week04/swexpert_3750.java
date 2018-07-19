import java.io.BufferedReader;
import java.io.InputStreamReader;
public class swexpert_3750 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		
		for(int i=0; i<T; i++){
			//int digit = Integer.parseInt(br.readLine());
			String line = br.readLine();
			//int[] digit = new int[line.length()];
			int sum =0;
			
			for(int j=0; j<line.length(); j++){
				// digit[j] = Integer.parseInt(String.valueOf(line.charAt(j)));
				// sum += digit[j];
				sum += Integer.parseInt(String.valueOf(line.charAt(j)));
			}
			
			while(sum/10 !=0){
				String number = String.valueOf(sum);
				// int[] temp = new int[number.length()];
				int midSum =0;
				for(int x=0; x<number.length(); x++){
					// temp[x] = Integer.parseInt(String.valueOf(line.charAt(x)));
					midSum += Integer.parseInt(String.valueOf(number.charAt(x)));
				}
				sum = midSum;
			}
			
			System.out.println("#"+(i+1)+" "+sum);
//			while(digit/10 != 0){
//				
//				int len = String.valueOf(digit).length();
//				for(int j=0; j<= len; j++){
//					midSum += (digit%10);
//					digit /= 10;
//				}
//				digit = midSum;
//			}
			
//			System.out.println("#"+(i+1)+" "+digit);
		}
	}

}
