import java.util.Scanner;

public class No1204_FrequentestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int time, maxFreqOf;
		int[] score;
		
		for(int t=1; t<=testCase; t++) {
			time = sc.nextInt();
			score = new int[101];
			for(int i=0; i<1000; i++) {
				score[sc.nextInt()]++;
			}
			
			maxFreqOf = 0;
			for(int i=1; i<101; i++) {
				if(score[i] >= score[maxFreqOf]) {
					maxFreqOf = i;
				}
			}

			System.out.println("#" + time + " " + maxFreqOf);
		}		
		sc.close();
	}
}