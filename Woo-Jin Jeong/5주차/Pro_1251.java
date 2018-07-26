import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Pro_1251 {

		static int x[],y[];
		static int n;
		static double map[][];
		static double e;		
		static double distance[];
		static int check[];
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();				
		for(int i=1; i<=t; i++)
		{
			n = in.nextInt();
			x = new int[n];
			y = new int[n];
			map = new double[n][n];		
			distance = new double[n];
			check = new int[n];
			for(int j=0; j<n; j++)
			{
				x[j] = in.nextInt();
			}
			for(int j=0; j<n; j++)
			{
				y[j] = in.nextInt();
			}
			
			e = in.nextDouble();
			
			for(int j=0; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    double len = Math.pow(x[j]-x[k], 2);
                    len += Math.pow(y[j]-y[k], 2);
                    map[j][k]=Math.sqrt(len);
                    map[k][j] = map[j][k];
                }
            }
			
			
			
			distance[0] = 0;
			check[0] = 1;
			
			
		/*	for(int j=0; j<n; j++)
			{
				for(int k=0; k<n; k++)
				{
					System.out.print(map[j][k]);
					if(k==n-1)
						System.out.println();
					else
						System.out.print(" ");
				}
			}*/
			
			
				
			for(int l=1; l<n; l++)
			{
				 double min = 987654321;
	                int minindex=0;
				for(int j=0; j<n; j++)
				{
					if(check[j]!=1) continue;
					for(int k=0; k<n; k++)
					{
						if(check[k]==1) continue;
                        if(min>map[j][k]) { 
                        	min = map[j][k];
                        	minindex = k;
                        }
					}
					
					
				}
		
				distance[minindex] = min;
				check[minindex] = 1;
				
				/* for(int j=0; j<n; j++)
				 {
					 System.out.print(distance[j]);
					if(j==n-1)
						System.out.println();
					else
						System.out.print(" ");
				 }*/
			}
				
				
			double sumCost = 0;
		/*	 for(int j=0; j<n; j++)
			 {
				 System.out.print(distance[j]);
				if(j==n-1)
					System.out.println();
				else
					System.out.print(" ");
			 }*/
            for(int j=0; j<n; j++) sumCost+=distance[j]*distance[j];
            System.out.println("#"+i+" "+Math.round(e*sumCost));
			
		}
		
		
	}

}

//그래프를 만들고 map , 목적지까지 각각 한번씩 거쳐가는 최단경로를 찾는다 .

//한타임씩 현재그래프에서 가장 거리가 가까운거 이어 붙이는거네 