import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1859_Millionaire {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			int size = Integer.parseInt(br.readLine());
			int[] num = new int[size];
			int buy = 0, sell = 0;
			long profit = 0;

		 	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			while(buy != size) {
				for(int i=buy; i<size; i++) {
					if(num[i] > num[sell]) {
						sell = i;
					}
				}
				for(int i=buy; i<sell; i++) {
					profit += num[sell] - num[i];
				}
				sell = sell + 1;
				buy = sell;
			}
			
			System.out.println("#" + t + " " + profit);
		}
	}
}