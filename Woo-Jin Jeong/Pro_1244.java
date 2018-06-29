import java.util.Arrays;
import java.util.Scanner;

public class Pro_1244 {

	
		static int cnt;
		static int temp[];
		static String num;
		static int max;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int t= in.nextInt();
		
		
		for(int i=1; i<=t; i++)
		{
			
			num = in.next();
            max = Integer.parseInt(num);
			cnt = in.nextInt();
			
			temp = new int[num.length()];
			
			
			for(int j=0; j < num.length(); j++)
			{
				temp[j] = Integer.parseInt(num.charAt(j)+"");
			}
			
			for(int j=0; j<num.length()-1; j++)
			{
				for(int k=j+1; k<num.length(); k++)
				{										
					if(temp[j] > temp[k])
						continue;
					else {
						
						
						
					
						findMax(j,k,1);
						
					}
				}
			}
			
			System.out.println("#"+i+" "+max);
		}
		
	}
	
	
	public static void findMax(int left, int right, int depth)
	{
	
		int swap;
		swap = temp[right];
		temp[right] = temp[left];
		temp[left] = swap;
		
		/*int tem = 0;
		
		String str = "";
		for(int i=0; i<temp.length; i++) {
			str+= Integer.toString(temp[i]);
		}
		
		tem = Integer.parseInt(str);
		
		if( tem < max) {
			
			swap = temp[right];
			temp[right] = temp[left];
			temp[left] = swap;
			
			return;
		}*/
		
		int result = 0;
		
		if(depth == cnt)
		{
			for(int i =0; i<temp.length; i++)
			{
				result +=  temp[i]*(int)Math.pow(10, (temp.length-i-1)) ; 
			}
			
			if (max < result)
			{
				max = result;
			}
			
		}
		else
		{
				for(int j=0; j<num.length()-1; j++)
			{
				for(int k=j+1; k<num.length(); k++)
				{	
					if(temp[j] > temp[k])
						continue;
					else {
						if(depth+1 <= cnt) {
						findMax(j,k,depth+1);
						}
						
					}
				}
			}
			
			
			
			
		}
		
		swap = temp[right];
		temp[right] = temp[left];
		temp[left] = swap;
		
	}
	
	
}

