import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No1209_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr;
		int time, horizen, maxHorizen, vertical, maxVertical, rDiagonal, lDiagonal;
		ArrayList<Integer> max;
		
		for(int t=0; t<10; t++) {
			time = sc.nextInt();
			arr = new int[100][100];
			
			maxHorizen = 0;
			rDiagonal = 0;
			lDiagonal = 0;
			for(int i=0; i<100; i++) {	
				horizen = 0;
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
					horizen += arr[i][j];
					if(i == 99) {
						rDiagonal += arr[j][j];
						lDiagonal += arr[j][99-j];
					}
				}
				if(horizen > maxHorizen) {
					maxHorizen = horizen;
				}				
			}
			
			maxVertical = 0;
			for(int i=0; i<100; i++) {
				vertical = 0;
				for(int j=0; j<100; j++) {
					vertical += arr[j][i];
				}
				if(vertical > maxVertical) {
					maxVertical = vertical;
				}			
			}
			
			max = new ArrayList<>();
			max.add(maxHorizen);
			max.add(maxVertical);
			max.add(rDiagonal);
			max.add(lDiagonal);
			Collections.sort(max);

			System.out.println("#" + time + " " + max.get(3));
		}
		sc.close();
	}
}