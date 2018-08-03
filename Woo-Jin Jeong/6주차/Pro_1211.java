import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pro_1211 {

      static int map[][];
      static int check[][];

      static int minTime;
      static int temMin;
      static int minIdx;
   
   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      for(int x=1; x<=10; x++) {
         int num = Integer.parseInt(in.readLine());
      
         map = new int[100][100];
         
         String temp[];
         for(int i=0; i<100; i++) {
            temp = in.readLine().split(" ");
            for(int j=0; j<100; j++) {
               map[i][j] =Integer.parseInt(temp[j]);               
            }
         }
         
         minTime = 987654321;
         minIdx = -1;
         for(int i=0; i<100; i++) {
        	 
            if(map[0][i] == 1) {      
            	temMin = 0;
            	check = new int[100][100];
            	findStartPnt(i,0,0);
               
            	if(temMin < minTime) {
            		minTime = temMin;
            		minIdx = i;
            	}
            	
            }
            
         }
            
            System.out.println("#"+x+" "+minIdx);
         
      
      }
   }
   
   public static void findStartPnt(int x, int y, int time) {
      
	   
	   
      if(y==99){
    	 
    	 temMin = time;
         return;         
      }
      
      check[y][x] = 1;
      
      if(x-1 >=0 && map[y][x-1]==1 && check[y][x-1] != 1) {
         //왼
         findStartPnt(x-1, y,time+1);
      }      
      else if(x+1 <100 && map[y][x+1]==1 && check[y][x+1] != 1 ) {
         //오
         findStartPnt(x+1, y,time+1);
         
      }else if(y+1 <100 && map[y+1][x]==1 && check[y+1][x] != 1 ){
         //직진
         findStartPnt(x, y+1,time+1);
      }
      
      
      
   }

}