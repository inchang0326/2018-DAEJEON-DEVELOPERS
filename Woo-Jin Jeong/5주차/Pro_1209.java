import java.util.Scanner;

public class Pro_1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[101][101];
		
		
		for(int i=0; i<10; i++)
		{
			int t = in.nextInt();
			for(int j=1; j<=100; j++)
			{
				for(int k=1; k<=100; k++)
				{
					arr[j][k] = in.nextInt();
				}
			}
			
			int max =0;
			int sum=0;
			int sum2=0;
			
			int indexRcr = 1;
			int indexRcc = 100;
			int resultR = 0;
			int resultL = 0;
			//가로 , 대각
			for(int j=1; j<=100; j++)
			{
				for(int k=1; k<=100; k++)
				{
					sum += arr[j][k];
					sum2 += arr[k][j];
					if( j==k)
						resultL += arr[j][k];
					else if(j == indexRcr && k == indexRcc)
					{
						resultR += arr[j][k];
						indexRcr ++;
						indexRcc --;
					}
					
				}
				if(sum > max)
					max = sum;
				if (sum2 > max)
					max = sum2;
				sum =0;
				sum2 =0;
			}
			
			if(resultR > max)
				max = resultR;
			if(resultL > max)
				max = resultL;
			
			System.out.println("#"+t+" "+max);
		}
		
	}

}
