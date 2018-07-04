import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1244_MaxPrize {
	
	// 숫자 교환 횟수에 따른 최댓값 저장
	private static int memoByTime[] = new int[100];
	// 가지치기를 위한 경우의 수 저장
	private static ArrayList<Integer> memoByData = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String sBonus = st.nextToken();
			int time = Integer.parseInt(st.nextToken());
			int[] iABonus = convertToIntArray(sBonus);
			
			System.out.println("#" + t + " " + getMaxBonus(iABonus, time));
			memoByData.clear();
			memoByTime = new int[100];
		}
	}
	
	public static int getMaxBonus(int[] iABonus, int time) {		
//		int iBonus = convertIntArrToInt(iABonus);
//		System.out.println("*** IN 함수 ***");
//		System.out.println(time + "번 이동 가능 : " + iBonus);
		
		// Break 지점
		if(time == 0) 
			return 0;
		
		// 가지치기 지점
		/*
		 *  이전 '가지'와 같은 '가지'가 나왔을 때 현재의 최댓값을 불러온다. 
		 *  왜냐하면.. 이전 '가지'와 같은 '가지'가 나왔다는 말은 그 '가지'를 탐색할지라도
		 *  무조건 현재의 최댓값 이하의 값이 나온다는 것을 알 수 있기 때문이다.
		 */
		int iBonus = convertToInt(iABonus);
		if(memoByData.contains(iBonus))
			return memoByTime[time];
		
		// 행위 지점
		for(int i=0; i<iABonus.length-1; i++) {
			memoByData.add(iBonus);
			
			for(int j=i+1; j<iABonus.length; j++) {
//				System.out.println("@@@ 인덱스 " + i + ", " + j);
				
				// swap
				int swap = iABonus[i];
				iABonus[i] = iABonus[j];
				iABonus[j] = swap;
				
				iBonus = convertToInt(iABonus);
				/*
				 * 현재의 값과 다음 한 번 교환이 일어났을 때의 값을 비교하여 최댓값을 구해야 한다.
				 */
				int temp = Math.max(iBonus, getMaxBonus(iABonus, time-1));
				if(temp > memoByTime[time] && time == 1) {
//					System.out.println(temp + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + time);
					memoByTime[time] = temp;
				}
				
				// swap - 원상복귀
				swap = iABonus[i];
				iABonus[i] = iABonus[j];
				iABonus[j] = swap;				
			}
		}
		
//		System.out.println("함수 밖으로 나간다.");

		// 반환 지점
		return memoByTime[1];
	}
	
	// String 변수를 int형 Array 변수로 변환한다.
	public static int[] convertToIntArray(String str) {
		int[] arr = new int[str.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
		}

		return arr;
	}
	
	// int형 Array 변수를 int형 변수로 변환한다.
	public static int convertToInt(int[] arr) {
		String str = "";
		
		for(int i=0; i<arr.length; i++) {
			str += arr[i];
		}
	
		return Integer.parseInt(str);
	}
	
}
