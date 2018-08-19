import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No1259_MetalRod {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			
			Map<Integer, Integer> rod = new HashMap<>();
			
			int num = Integer.parseInt(br.readLine());
			int[] left = new int[num];
			int[] right = new int[num];
			int cnt = 0, max = 0;
			String result = "";
			
			String[] st = br.readLine().split(" ");
			for(int i=0; i<num; i++) {
				left[i] = Integer.parseInt(st[2*i]);
				right[i] = Integer.parseInt(st[(2*i)+1]);
				rod.put(left[i], right[i]);
			}

			for(Integer key : rod.keySet()) {
				Map<Integer, Integer> copied = new HashMap<>(rod);
				String temp = getResult(key, copied);
				cnt = temp.length();
				if(cnt > max) {
					max = cnt;
					result = temp;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	// 금속막대 중 중복되는 것이 없으므로 따로 처리해주지 않아도 된다.
	public static String getResult(int key, Map<Integer, Integer> rod) {
		String result = "";
		
		int currKey = key;
		int currValue = rod.get(currKey);

		result += currKey + " " + currValue + " ";
		
		rod.remove(currKey);
		
		int nextKey = currValue;
		while(rod.containsKey(nextKey)) {
			int nextValue = rod.get(nextKey);
			
			result += nextKey + " " + nextValue + " ";
			
			rod.remove(nextKey);

			nextKey = nextValue;
		}
		
		return result;
	}
}