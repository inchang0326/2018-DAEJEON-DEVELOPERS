import java.util.Arrays;
import java.util.Scanner;

public class No1208_Flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dump;
		int[] arr;
		
		for(int t=1; t<=10; t++) {
			dump = sc.nextInt();
			arr = new int[100];
			                    
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			for(int i=0; i<dump; i++) {
				arr[99]--;// max
				arr[0]++;// min
				Arrays.sort(arr);	
			}
			
			System.out.println("#" + t + " " + (arr[99] - arr[0]));
		}			
		sc.close();
	}
}
