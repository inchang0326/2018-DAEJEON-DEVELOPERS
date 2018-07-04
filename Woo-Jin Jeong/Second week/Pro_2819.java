import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_2819 {
	
		static String map[][];
		static int visit[][];
		
		static HashMap<String, Integer> str;
		
		//위 오른 아래 왼
		static int dirx[] = {0, 1, 0, -1};
		static int diry[] = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String temp[];
		for(int x=1; x<=T; x++) {
			
			map = new String[4][4];
			//입력
			for(int i=0; i<4; i++) {
				temp = in.readLine().split(" ");
				for(int j=0; j<4; j++) {
					map[i][j] = temp[j];
				}
			}
			
			
			
		/*	for(int i=0; i<4; i++) {
				
				for(int j=0; j<4; j++) {
					System.out.print(map[i][j]+ " ");
				}
				System.out.println();
			}*/
			
			str = new HashMap<String,Integer>();
			
			for(int i=0; i<4; i++) {
				
				for(int j=0; j<4; j++) {
					bfs(j,i);
					
				}
			}
			
	
			
			System.out.println("#"+x+" "+str.size());
			
		}
		
	}
	

	public static void bfs(int x,int y) {
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(y,x,1,map[y][x]));
		
		while(!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			String name = q.peek().name;
			int count = q.poll().count;
			if(count == 7) {
				str.put(name, 1);
				continue;
			}
			
			
			int nx,ny;
			for(int i=0; i<4; i++) {
				nx = cx+dirx[i];
				ny = cy+diry[i];
				
				if(ny>=0 && ny<4 && nx>=0 && nx<4) {					
					q.add(new Info(ny,nx,count+1,name+map[ny][nx]));					
				}		
			}
			
		}
		
	
	}
	
	public static class Info{
		int y,x,count;
		String name;
		public Info(int y,int x, int c, String name) {
			this.y = y;
			this.x = x;
			count = c;
			this.name = name;
		}
	}
}
