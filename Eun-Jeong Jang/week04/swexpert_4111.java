import java.io.BufferedReader;
import java.io.InputStreamReader;
public class swexpert_4111 {
	static int T;
	static int N;	//	단속 카메라 개수
	static int K;	//	수신기 개수 
	static int arr[];	// x축
	static int arrlen[];	//	xj-xi 거리 
	static String x[];
	
	
	public static void swap(int x, int y, int arr[]){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		
	}
	
	public static void sort(int arr[]){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				if(arr[i] < arr[j])
					swap(i, j, arr);
			}
		}
	}
	public static int getMax(){
		int index =0;
		for(int i=1; i<arrlen.length; i++){
			if(arrlen[index]<arrlen[i])
				index = i;
		}
		int temp = arrlen[index];
		arrlen[index] = 0;
		return temp;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++){
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			String line = br.readLine();
			
			//	수신기 개수가 더 많으면 (포인트?)
			if(K>N) {
				System.out.println("#"+(i+1)+" "+0);
				continue;
			}
			// 실행 시간 줄이기 
			else{
				arr = new int[N];
				arrlen = new int[N-1];
				x =line.split(" ");
				for(int j=0; j<N; j++){
					arr[j] = Integer.parseInt(x[j]);
				}
				
				sort(arr);
				
				
				int sum =0;
				for(int j=1; j<N; j++){
					arrlen[j-1] = arr[j]-arr[j-1];
					sum += arrlen[j-1];
				}
				
				for(int j=1; j<K; j++){
					sum = (sum - getMax());
				}
				
				System.out.println("#"+(i+1)+" "+sum);
			}
		}
	}

}
