import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pro_1227 {

		static int map[][];
		static int result;
		static boolean outflag;
		
		static int dx[] = {0, 0, -1, 1};
		static int dy[] = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		for(int x=1; x<=10; x++) {
			int testCase = Integer.parseInt(in.readLine());
			map = new int[100][100];
			String tem;
			for(int i=0; i<100; i++) {
				tem = in.readLine();
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(""+tem.charAt(j));
				}
			}
			

			
			result = 0;
			outflag = false;
			find(1,1);
			
			System.out.println("#"+testCase+ " "+result);
		}
	}
	
	public static void find(int x, int y) {
		
		if(outflag)
			return;
		
		if(map[y][x] == 3)
		{			
			result = 1;
			outflag = true;
			return;
		}
		
		map[y][x] = -1;
		
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(ny < 0 || ny >= 100 || nx <0 || nx >= 100)
				continue;
			if(map[ny][nx] == 0 || map[ny][nx] == 3) {
				find(nx,ny);
			}
		
		}
		
	}

}
