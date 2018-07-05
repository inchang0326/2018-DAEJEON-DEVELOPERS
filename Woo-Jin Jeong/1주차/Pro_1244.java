import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Pro_1244 {
 
        static String num;
        static int numOfTime;
         
        static int D[];
         
        static int numArr[];
     
        static int max;
         
         
     
         
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        String temp[];      
        for(int x=1; x<=T; x++) {
             
            temp = in.readLine().split(" ");
            num = temp[0];
            numOfTime = Integer.parseInt(temp[1]);
            numArr = new int[num.length()];
            D = new int[10000];
            max = 0;
         
            stoa(num,numArr);
            find(numArr, 0);
             
            System.out.println("#"+x+" "+max);
        }
         
    }
    public static void find(int arr[], int cnt) {
         
        int cur = atoi(arr);
         
        if(D[cnt] > cur) {
            return;
        }
         
        if ( cnt == numOfTime  ) {
             
            if( cur > max ) {
                 
                max = atoi(arr);
            }
            return;
        }
         
        D[cnt] = cur;
         
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int temp[] = new int [arr.length];
                copy(arr,temp);
                swap(temp,i,j);             
                find(temp,cnt+1);
            }
        }
         
    }
     
     
    public static void stoa(String str,int arr[]) {
         
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(""+str.charAt(i));
        }       
         
    }
    public static int atoi(int arr[]) {
        int tem=0;
         
        for(int i=0; i<arr.length; i++) {
            tem += arr[i] * Math.pow(10, arr.length-1-i);
        }
         
        return tem;
    }
     
    public static void swap(int arr[],int i, int j) {
        int s;
         
        s = arr[j];
        arr[j] = arr[i];
        arr[i] = s;
         
    }
     
    public static void copy(int src[], int dst[]) {
         
        for(int i=0; i<src.length; i++) {
            dst[i] = src[i];
        }
         
    }
     
     
}