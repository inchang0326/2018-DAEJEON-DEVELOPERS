import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Pro_3752 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int x=1; x<=T; x++) {
			
			HashSet<Integer> answer = new HashSet();
			HashSet<Integer> temp = new HashSet();
			
			int N = Integer.parseInt(in.readLine());
			answer.add(0);
			String tem[];
			tem = in.readLine().split(" ");
			for(int i=0; i<N; i++) {
				int add = Integer.parseInt(tem[i]);
				for(int ans: answer) {
					temp.add(ans+add);
				}
				for(int t : temp) {
					answer.add(t);
				}			
			}
			
			System.out.println("#"+x+" "+answer.size());
			
		}	
		
	}

}

/*
import java.util.Scanner;
 
public class Solution {
    public static int answer;
    public static boolean bt[][];
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            // solve
            answer = 0;
            N = sc.nextInt();
            int score[] = new int[N];
            int max_score = 0;
            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                max_score += score[i];
            }
            bt = new boolean[max_score+1][N];
            boolean flag_score[] = new boolean[max_score+1];
            solve(bt, score, 0, 0, N, flag_score);
             
            // print
            System.out.print("#"+t+" "+answer);
            if (t < T) System.out.println();
        }
        sc.close();
    }
     
    public static void solve(boolean bt[][], int score[], int cur_score, int idx, int N, boolean flag_score[]) {
        if (idx == N) {
            if (!flag_score[cur_score]) {
                flag_score[cur_score] = true;
                answer++;
            }
            return;
        }
        if (!bt[cur_score][idx]) {
            bt[cur_score][idx] = true;
            solve(bt, score, cur_score, idx+1, N, flag_score);
            solve(bt, score, cur_score+score[idx], idx+1, N, flag_score);
        }
    }
}

다른 풀이법

*/