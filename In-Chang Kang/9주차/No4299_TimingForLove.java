import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No4299_TimingForLove {

	private static final int DAY = 11, HOUR = 11, MINUTE = 11;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			String[] st = br.readLine().split(" ");
			int D = Integer.parseInt(st[0]);
			int H = Integer.parseInt(st[1]);
			int M = Integer.parseInt(st[2]);
			
			System.out.println("#" + t + " " + getResult(D, H, M));
		}
	}
	
	public static int getResult(int D, int H, int M) {
		int dDiff = (D - DAY) * 24 * 60;
		if(dDiff < 0) return -1;
		
		int hDiff = (H - HOUR) * 60;
		if(dDiff == 0 && hDiff < 0) return -1;
				
		int mDiff = (M - MINUTE);
		if(dDiff <=0 && hDiff <= 0 && mDiff < 0) return -1;
			
		return dDiff + hDiff + mDiff;
	}
}
