import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Pro_1824 {

		static char map[][];
		static int visit[][][];
		static int R,C;
		
		//오 아래 왼 위
		static int dirX[] = {1, 0, -1, 0};
		static int dirY[] = {0, 1, 0, -1};
		
		static int curX,curY,curDir,mem;
		
		static Random random = new Random(System.currentTimeMillis());
		
		static Queue<Info> q;
		
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int x=1; x<=T; x++) {
			
			String temp[];
			temp = in.readLine().split(" ");
			
			R = Integer.parseInt(temp[0]);
			C = Integer.parseInt(temp[1]);
			
			map = new char[R][C];
			visit = new int[R][C][4];
			
			boolean isCheck;
			isCheck = false;
			//입력
			String tem;
			for(int i=0; i<R; i++) {
				tem = in.readLine();				
				for(int j=0; j<C; j++) {
					map[i][j] = tem.charAt(j);
					if(map[i][j] == '@')
						isCheck = true;
				}
			}
			
			curX = 0;
			curY = 0;
			curDir = 0;
			mem = 0;
			
			int time=0;
			
			boolean result;
			
			result = true;
			
			q = new LinkedList();
			q.add(new Info(curY,curX,curDir));
			
			if ( isCheck) {
				
			
				while(!q.isEmpty()) {
					
					int cx = q.peek().x;
					int cy = q.peek().y;
					int cd = q.poll().dir;
					
					if( map[cy][cx] == '@') {
						result =true;
						break;
					}
					
					visit[cy][cx][cd] += 1;
					if(visit[cy][cx][cd] > 15) {
						result = false;
						break;
					}
					
					int nextDir = check(map[cy][cx], cd);
					//? 걸렸을 때
					if( nextDir == 5) {
						
						for(int i=0; i<4; i++) {
							
							int ny = cy + dirY[i];
							int nx = cx + dirX[i];
							if( ny < 0)
								ny = R-1;
							if( nx < 0)
								nx = C-1;
							if( ny >= R)
								ny = 0;
							if( nx >= C)
								nx = 0;
							
							q.add(new Info(ny,nx,i));
							
						}
						
						
					}else {
						
						int ny = cy + dirY[nextDir];
						int nx = cx + dirX[nextDir];
						if( ny < 0)
							ny = R-1;
						if( nx < 0)
							nx = C-1;
						if( ny >= R)
							ny = 0;
						if( nx >= C)
							nx = 0;
						
						q.add(new Info(ny,nx,nextDir));
						
						
					}
				
					
					
				}
			
			
			}else {
				result = false;
			}
			
			if(result) 
				System.out.println("#"+x+" YES");
			else
				System.out.println("#"+x+" NO");
						
			
		}
	}
	
	public static int check(char c, int cdir) {
		
		if(c == '<') {
			return  2;
		}else if( c == '>') {
			
			return 0;
			
		}else if( c == '^') {
			
			return 3;
		}else if( c == 'v') {
			
			return 1;
		}else if( c == '_') {
			
			if( mem == 0) {
				return 0;
			}else { 
				return 2;
			}
		}else if( c == '|') {
			
			if( mem == 0) {
				return 1;
			}else { 
				return 3;
			}
			
		}else if( c == '?') {
			 
			return 5;
			//curDir = random.nextInt(4);
			//System.out.println(curDir);
		}else if( c >= '0' && c <= '9') {
	
			mem = Integer.parseInt(c+"");
	
		}else if( c == '+') {
			
			mem += 1;
			if(mem >15)
				mem = 0;
			
		}else if( c == '-') {
			mem -= 1;
			if(mem <0)
				mem = 15;
		}
		
		return cdir;
		
	}
	
	static class Info{
		
		int y,x,dir;
		public Info(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
		
		
	}
	
	
	

}
