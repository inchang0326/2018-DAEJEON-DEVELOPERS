import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Pro_1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int result;
		String str;
		Stack<Integer> stack = new Stack<>();
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('(', 1);
		map.put('[', 2);
		map.put('{', 3);
		map.put('<', 4);
		map.put(')', 5);
		map.put(']', 6);
		map.put('}', 7);
		map.put('>', 8);
		int temp;
		for(int i=1; i<=10; i++)
		{
			result = -1;
			int len = in.nextInt();
			
			str = in.next();
			
			int j;
			for(j =0; j<str.length(); j++)
			{
				if(str.charAt(j) == '(' || str.charAt(j) == '[' || str.charAt(j) == '{' || str.charAt(j) == '<' )
				{
					stack.add(map.get(str.charAt(j)));
					
				}
				else
				{
					if(stack.isEmpty())
					{
						result = 0;
						break;
					}
					else
					{
						temp = stack.pop();
						if(temp != ( map.get(str.charAt(j)) % 5 +1 ) )
						{
							result = 0;
							break;
						}
						else 
							result = 1;
					}
				}
			}
			
			if(stack.isEmpty() && (j == str.length()))
				result = 1;
			
			System.out.println("#"+i+" "+result);
			
		}
		
	}

}


//성공

//인데 .. 조금 다 길다 ...