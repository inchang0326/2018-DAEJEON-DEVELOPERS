import java.util.Scanner;

public class No1206_BuildingView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		for(int t=1; t<=10; t++) {
			int cnt = 0;
			
			int h = sc.nextInt();
			int m[][] = new int[h][255];

			for(int i=0; i<h; i++) {
				int v = sc.nextInt();
				for(int j=0; j<v; j++) {
					m[i][j] = 1;
				}
			}

			for(int i=2; i<h-2; i++) {
				for(int j=0; j<255; j++) {
					if(m[i][j] == 1)
						if(m[i-1][j] != 1 && m[i+1][j] != 1 && m[i-2][j] != 1 && m[i+2][j] != 1)
							cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}	
		sc.close();
	}
}
