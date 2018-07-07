import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Catch4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bfs(n, k);
	}
	
	public static void bfs(int n, int k) {		
		Queue<Pin> q = new ArrayDeque<>();
		Map<Integer, Pin> pins = new HashMap<>();
		
		boolean[] isVisited = new boolean[100000 + 1];
		int step = 0, time = 0;
		
		Pin pin = new Pin(n); 
		q.add(pin);
		
		while(q.size() > 0) {
			
			int size = q.size();
			
			for(int i=0; i<size; i++) {

				Pin currPin = q.poll();
				int currValue = currPin.getValue();
				
				isVisited[currValue] = true;

				if(currValue == k) {
					pins.put(time, currPin);
					time++;
				}
				
				if( currValue - 1 >= 0 && !isVisited[currValue - 1] ) {
					Pin nextPin = new Pin(currValue - 1);	
					nextPin.setPrevPin(currPin);
					q.add(nextPin);
				}
				if( currValue + 1 <= 100000 && !isVisited[currValue + 1] ) {
					Pin nextPin = new Pin(currValue + 1);	
					nextPin.setPrevPin(currPin);
					q.add(nextPin);
				}
				if( currValue * 2 <= 100000 && !isVisited[currValue * 2] ) {
					Pin nextPin = new Pin(currValue * 2);	
					nextPin.setPrevPin(currPin);
					q.add(nextPin);
				}
				
			}
			
			if(time != 0) break;
			step++;
		}
		
		System.out.println(step);
		for(int i=0; i<pins.size(); i++) {
			Pin travel = pins.get(i);
			while(travel != null) {
				System.out.print(travel.getValue() + " ");
				travel = travel.getPrevPin();
			}
			System.out.println();
		}
	}
}

class Pin {
	private int value;
	private Pin prevPin;
	
	public Pin() {
		
	}
	
	public Pin(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Pin getPrevPin() {
		return prevPin;
	}
	public void setPrevPin(Pin prevPin) {
		this.prevPin = prevPin;
	}
}