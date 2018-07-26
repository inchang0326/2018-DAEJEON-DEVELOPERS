import java.util.Arrays;
import java.util.Scanner;

public class Pro_1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		for(int i=1; i<=10; i++)
		{
			int dump = in.nextInt();
			
			int minPnt = 1;
			int maxPnt = 100;
			
			int map[] = new int[101];
			
			for(int j=1; j<=100; j++ )
			{
				map[j] = in.nextInt();
			}
			
			Arrays.sort(map);
			int temp1=0,temp2=0;
			
			
			while (dump -- >0)
			{
				temp1 = map[maxPnt];
				temp2 = map[minPnt];
				map[minPnt]++;
				map[maxPnt]--;
				
				if(map[maxPnt-1] < temp1)
					maxPnt = 100;
				else
					maxPnt -= 1;
				
				if( temp2 < map[minPnt+1])
					minPnt = 1;
				else
					minPnt += 1;
				
			}
			
	
			
			System.out.println("#"+i+" "+ (map[maxPnt]-map[minPnt]) );
			
			
		}
		

	}

}
