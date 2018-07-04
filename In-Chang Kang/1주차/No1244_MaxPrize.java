import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1244_MaxPrize {
	
	// ���� ��ȯ Ƚ���� ���� �ִ� ����
	private static int memoByTime[] = new int[100];
	// ����ġ�⸦ ���� ����� �� ����
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
//		System.out.println("*** IN �Լ� ***");
//		System.out.println(time + "�� �̵� ���� : " + iBonus);
		
		// Break ����
		if(time == 0) 
			return 0;
		
		// ����ġ�� ����
		/*
		 *  ���� '����'�� ���� '����'�� ������ �� ������ �ִ��� �ҷ��´�. 
		 *  �ֳ��ϸ�.. ���� '����'�� ���� '����'�� ���Դٴ� ���� �� '����'�� Ž��������
		 *  ������ ������ �ִ� ������ ���� ���´ٴ� ���� �� �� �ֱ� �����̴�.
		 */
		int iBonus = convertToInt(iABonus);
		if(memoByData.contains(iBonus))
			return memoByTime[time];
		
		// ���� ����
		for(int i=0; i<iABonus.length-1; i++) {
			memoByData.add(iBonus);
			
			for(int j=i+1; j<iABonus.length; j++) {
//				System.out.println("@@@ �ε��� " + i + ", " + j);
				
				// swap
				int swap = iABonus[i];
				iABonus[i] = iABonus[j];
				iABonus[j] = swap;
				
				iBonus = convertToInt(iABonus);
				/*
				 * ������ ���� ���� �� �� ��ȯ�� �Ͼ�� ���� ���� ���Ͽ� �ִ��� ���ؾ� �Ѵ�.
				 */
				int temp = Math.max(iBonus, getMaxBonus(iABonus, time-1));
				if(temp > memoByTime[time] && time == 1) {
//					System.out.println(temp + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + time);
					memoByTime[time] = temp;
				}
				
				// swap - ���󺹱�
				swap = iABonus[i];
				iABonus[i] = iABonus[j];
				iABonus[j] = swap;				
			}
		}
		
//		System.out.println("�Լ� ������ ������.");

		// ��ȯ ����
		return memoByTime[1];
	}
	
	// String ������ int�� Array ������ ��ȯ�Ѵ�.
	public static int[] convertToIntArray(String str) {
		int[] arr = new int[str.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
		}

		return arr;
	}
	
	// int�� Array ������ int�� ������ ��ȯ�Ѵ�.
	public static int convertToInt(int[] arr) {
		String str = "";
		
		for(int i=0; i<arr.length; i++) {
			str += arr[i];
		}
	
		return Integer.parseInt(str);
	}
	
}
