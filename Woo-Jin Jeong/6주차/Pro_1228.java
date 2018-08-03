import java.awt.PageAttributes.OriginType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Pro_1228 {

		static int N;
		static String originStr[];
		static int numOfCmd;
		
		static Queue<String> que;
		
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int x =1; x<=10; x++)
		{
			que = new ArrayDeque<>();
			
			N = Integer.parseInt(in.readLine());
			originStr = new String[N];
			String temp[];
			temp = in.readLine().split(" ");
			for(int i=0; i<temp.length; i++) {
				originStr[i] = temp[i];
			}
			
			numOfCmd = Integer.parseInt(in.readLine());
			temp = in.readLine().split(" ");
		
			
			
			
			/*	for(int i=0; i<temp.length; i++) {
				if( temp[i].equals("I")) {
					int idx = Integer.parseInt(temp[i+1]);
					int cnt = Integer.parseInt(temp[i+2]);
				
					i = i+3;					
					for(int j=0; j<cnt; j++) {
						if(idx+j >= originStr.length)
							break;
						originStr[idx+j] = temp[i+j]; 
					}
					i = i+cnt-1;
					
				}
			}
		*/
			System.out.print("#"+x+" ");
			for(int i=0; i<10; i++) {
				if(i == 9)
					System.out.println(originStr[i]);
				else
					System.out.print(originStr[i]+" ");
			}
			
		}
		
		
	}

}
