import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pro_4223 {

		static int N;	

		static Info info[];
		static int result;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int x=1; x<=T; x++){
			N = Integer.parseInt(in.readLine());
			
			info = new Info[N];
			
			for(int i=0; i<N; i++) {
				int len = Integer.parseInt(in.readLine());
				
				String tem[] = in.readLine().split(" ");
				String name = "";
				for(int j=0; j<len; j++) {
					name += tem[j];
				}
				int pnt = Integer.parseInt(in.readLine());
				info[i] = new Info(len,name,pnt);
			}		
			
			result = 987654321;
			
			
			//off 
			find(1,0,"",0);
			
			//on
			find(1,info[0].len,info[0].name,info[0].pnt);
			
			if(result == 987654321)
				System.out.println("#"+x+" "+-1);
			else
				System.out.println("#"+x+" "+result);
		}
	}

	
	public static void find(int pos,int curlen, String curstr, int curpnt ) {
		
		
		boolean isOk;		
		
		isOk = isSamsung(curstr, curlen);		
			if(isOk) {				
				if( curpnt < result )
				{
					result = curpnt;					
					return;
				}				
				
			}else {			
			
				//off 			
				if(pos+1<=N )
					find(pos+1, curlen, curstr, curpnt );
				
				//on
				if(pos+1<=N ) {
					int nLen = curlen+info[pos].len;
					String nx = curstr+info[pos].name;
					int nPnt = curpnt+info[pos].pnt;
				
					find(pos+1, nLen, nx, nPnt);
				}
			
			}
		
		
	}

	static class Info{
		int len;
		String name;
		int pnt;
		
		public Info(int len, String name, int pnt) {
			this.len = len;
			this.name = name;
			this.pnt = pnt;
		}
	}
	
	
	
	public static boolean isSamsung(String curstr, int curlen) {
		
		//System.out.println("str : "+str);
		
		int samsungCnt[] = new int[6];
		
		for(int i=0; i<curlen; i++) {
			if(curstr.charAt(i) == 'S')
				samsungCnt[0] += 1;
			else if(curstr.charAt(i) =='A')
				samsungCnt[1] += 1;
			else if(curstr.charAt(i) =='M')
				samsungCnt[2] += 1;
			else if(curstr.charAt(i) =='U')
				samsungCnt[3] += 1;
			else if(curstr.charAt(i) =='N')
				samsungCnt[4] += 1;
			else if(curstr.charAt(i) =='G')
				samsungCnt[5] += 1;
			else
				continue;
		}
		
		
		
		if(samsungCnt[0] >= 2 && samsungCnt[1] >= 1 && samsungCnt[2] >= 1 && samsungCnt[3] >= 1 && samsungCnt[4] >= 1 && samsungCnt[5] >= 1) {
			return true;
		}else
			return false;
		
		
	}
	
	
}

