import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_2805 {

		static int dx[] = {1, 0, -1, 0};
		static int dy[] = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader( System.in));
		
		int T = Integer.parseInt(in.readLine());
		int N;
		String temp;
		int map[][];
		int check[][];
		Queue<Info> que;
		
		for(int x=1; x<=T; x++)
		{
			N = Integer.parseInt(in.readLine());
			
			//System.out.println(Math.round(7.0/2.0));
			
			map = new int[N][N];
			
			
			
			for(int i=0; i<N; i++)
			{
				temp = in.readLine();
				
				for(int j=0; j<temp.length(); j++)
				{
					map[i][j] = Integer.parseInt(temp.charAt(j)+"");
				}
			}
			
			int result = 0;
			int endcnt = N/2;
			que = new LinkedList();
			que.add(new Info(N/2,N/2,0));
			check = new int[N][N];
			Info tem;
			check[N/2][N/2] = 1;
			while(!que.isEmpty())
			{
				tem = que.poll();
							
				if(tem.depth > endcnt)
					break;
				result += map[tem.y][tem.x];
				
				int newx,newy;
				for(int i=0; i<4; i++)
				{
					newx = tem.x +dx[i];
					newy = tem.y +dy[i];
					if(newx>=0 & newx <N && newy>=0 && newy <N &&  check[newy][newx] != 1)
					{
					que.add(new Info(newx,newy,tem.depth+1));
					check[newy][newx] = 1;
					}
				}
			}
			 
			System.out.println("#"+x+" "+result);
		}
		
	}
	static class Info{
		int x,y;
		int depth;
		
		public Info(int x, int y, int depth)
		{
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

}

//정답 .. 간단하게 하려고 해도 아무리해도 생각안남.
