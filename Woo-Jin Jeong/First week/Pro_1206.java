import java.util.Scanner;

public class Pro_1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
				
		for(int i =1; i<=10; i++)
		{
			int n = in.nextInt();
			int cnt=0;
			int map [] = new int[n];
			for(int j=0; j<map.length; j++)
			{
				map[j] = in.nextInt();
			}
			
			int temp = 0;
			
			
			
			for(int j=2; j<map.length-2; j++)
			{
				temp = map[j];
				if(map[j] == 0)
					continue;
				while (temp>=0)
				{
					if(temp > map[j+1] && temp > map[j-1] && temp > map[j-2] && temp > map[j+2])
					{
						cnt++;
						temp--;
					}
					else
					{
						break;
					}
				}
			}
		
	
			System.out.println("#"+i +" " + cnt);
			
		}
		
		
	}

}

//���� 

/*0 0 225 214 82 73 241 233 179 219 
135 62 36 13 6 71 179 77 67 139 
31 90 9 37 93 203 150 69 19 137 
28 174 32 80 64 54 18 0 158 73 
173 20 0 102 107 48 50 161 246 145
225 31 0 153 185 157 44 126 153 233
0 201 83 103 191 0 45 0 131 87 
97 105 97 209 157 22 0 29 132 74
2 232 44 203 0 51 0 244 212 212 
89 53 50 244 207 144 72 143 0 0*/