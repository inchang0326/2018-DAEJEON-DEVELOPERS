import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pro_1249 {

		static Queue<Info> que;
		static int n;
	
		static int map[][];
		static int di[][];
		static int dy[] = { -1,0,1,0 };        
		static int dx[] = { 0,-1,0,1 };
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();		
		String tmpstr[];
	
		for(int i=1; i<=t; i++)
		{
			n = in.nextInt();
			map = new int[n][n];
			
			tmpstr = new String[n];
			di = new int[n][n];
			
			for(int j=0; j<n; j++)
			{
				tmpstr[j] = in.next();
			}
			
			for(int j=0; j<n; j++)
			{
				for(int k=0; k<n; k++)
				{
					map[j][k] = Integer.parseInt(tmpstr[j].charAt(k)+"");
				}
			}
			
			for(int j=0; j<n; j++)
				Arrays.fill(di[j], 900000000);
		
			
			que = new LinkedList<>();			
			que.add(new Info(0,0));
			di[0][0] = 0;
		
			Info temp;		
			while( !que.isEmpty())
			{
				//System.out.println("check");
				temp = que.poll();			
				 for (int j = 0; j < 4; j++) {    //상하좌우 돌리자
			            int new_x = temp.x + dx[j];
			            int new_y = temp.y + dy[j];
			            if (0 <= new_x&&new_x < n && 0 <= new_y&&new_y < n )
			            {
			            	 if (di[temp.y][temp.x] + map[new_y][new_x] < di[new_y][new_x]) {
			                    
			                     di[new_y][new_x] = di[temp.y][temp.x] + map[new_y][new_x];
			                   
			                     que.add(new Info(new_x, new_y));  
			                 }
			            }
				 }
			}
			
			System.out.println("#"+i+" "+di[n-1][n-1]);
			
			
		}
	}
	
	static class Info
	{
		int x,y;		
		public Info(int x,int y)
		{
			this.x = x;
			this.y = y;			
		}
	}

}

///메모리랑 실행시간 너무크다



