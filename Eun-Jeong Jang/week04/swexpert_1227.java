import java.io.BufferedReader;
import java.io.InputStreamReader;
public class swexpert_1227 {
	static final int T = 10;
	static final int arrlength = 100;
	static int number;
	static int graph[][] = new int [100][100];
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int result;
		
		for(int x=1; x<=T; x++){
			number = Integer.parseInt(br.readLine());
			visited = new boolean[100][100];
			for(int i=0; i<arrlength; i++){
				line = br.readLine();
				for(int j=0; j<arrlength; j++){
					graph[i][j] = Integer.parseInt(line.charAt(j)+"");				
				}
			}
					
			//	시작 점 좌표 
			result = findPath(1, 1) ? 1 : 0;
			System.out.println("#"+number+" "+result);
			
		}
		

	}
	
	//	성공 시 1, 실패 시 0
	public static boolean findPath(int x, int y){
		if(x<0 || y<0 || x>=arrlength || y>=arrlength || visited[x][y] || graph[x][y] ==1)
			return false;
//		
//		if(graph[x][y] ==1)
//			return false;
		
		//	출구를 찾았을 때, 
		if(graph[x][y] == 3)
			return true;
		//	출구를 아직 찾지 못했을 때,
		else{
			visited[x][y] = true;	//	방문 배열 체크 
			if(findPath(x-1,y)||findPath(x+1,y)||findPath(x,y-1)||findPath(x,y+1))
				return true;

		}	
		return false;
	}

}
