

//Priority Queue 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
public class Pro_1249_2 {
    static int N;
    static int map[][];
    static boolean visited[][];
    //상 하 좌 우
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    public static void main(String...msg) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int x = 1; x<=T; x++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0 ; i < N; i++) {
                String s = in.readLine();
                for(int j = 0 ; j < N; j++) {
                    map[i][j] = Integer.parseInt(""+s.charAt(j));
                }
            }
            bfs(x);
        }
    }
    public static void bfs(int T) {
        PriorityQueue<Info> q = new PriorityQueue<Info>();
        q.add(new Info(0,0,0));
        while(!q.isEmpty()) {
            Info cur = q.poll();
            if(cur.y == N-1 && cur.x==N-1) {
                System.out.println("#"+T+" "+cur.cost);
                return;
            }
            for(int d = 0 ; d < 4; d++) {
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];
                if( ny < 0 || nx< 0 || ny>=N || nx>=N)
                    continue;
                if(visited[ny][nx])
                    continue;
                visited[ny][nx]=  true;
                q.add(new Info(ny,nx,cur.cost+map[ny][nx]));
            }
        }
    }
}
class Info implements Comparable<Info>{
    @Override
    public int compareTo(Info o) {
    
    	//앞에게 작으면 -1반환 크면 1 반환
    	
    	//오름차순 정렬
        return cost < o.cost ? -1 : 1;
    }
    int y,x,cost;
    public Info(int a,int b,int c) {
        y = a;
        x = b;
        cost =c;
    }
}


