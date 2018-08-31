import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class No1949_HikingTrail_DFS {
 
    private static int ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
 
            String[] st = br.readLine().split(" ");
            int N = Integer.parseInt(st[0]);
            int K = Integer.parseInt(st[1]);
            int maxValue = 0;
            int[][] map = new int[N][N];
            boolean[][] isVisited = new boolean[N][N];
 
            for (int i = 0; i < N; i++) {
                st = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st[j]);
                    if (map[i][j] > maxValue) {
                        maxValue = map[i][j];
                    }
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxValue) {
                        DFS(map, isVisited, i, j, map[i][j], N, K, 0, false);
                    }
                }
            }
 
            System.out.println("#" + t + " " + ans);
            ans = 0;
        }
    }
 
    public static void DFS(int[][] map, boolean[][] isVisited, int r, int c, int curValue, int N, int K, int cnt, boolean construction) {
    	int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
     
        cnt++;
        isVisited[r][c] = true;
 
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
 
            if ((nr >= 0 && nr < N) && (nc >= 0 && nc < N)) {
                if (!isVisited[nr][nc]) {
                    if (curValue > map[nr][nc]) {
                        DFS(map, isVisited, nr, nc, map[nr][nc], N, K, cnt, construction);
                    } else if (curValue > map[nr][nc] - K && !construction) {
                        DFS(map, isVisited, nr, nc, map[r][c] - 1, N, K, cnt, true);
                    }
                }
            }
        }
         
        isVisited[r][c] = false;
        if (cnt > ans) {
            ans = cnt;
        }
    }
}