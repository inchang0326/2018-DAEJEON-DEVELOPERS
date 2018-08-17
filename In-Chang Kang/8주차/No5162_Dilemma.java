import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class No5162_Dilemma {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++) {
 
            String[] st = br.readLine().split(" ");
            int A = Integer.parseInt(st[0]);
            int B = Integer.parseInt(st[1]);
            int C = Integer.parseInt(st[2]);
             
            int ans = (A>B) ? C/B : C/A;
            System.out.println("#" + t + " " + ans);
        }
    }
}