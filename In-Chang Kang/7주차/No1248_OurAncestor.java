import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1248_OurAncestor {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			T template = new T();

			String[] st = br.readLine().split(" ");
			int numOfN = Integer.parseInt(st[0]);
			int numOfE = Integer.parseInt(st[1]);
			int one = Integer.parseInt(st[2]);
			int another = Integer.parseInt(st[3]);
			
			template.push(null);
			for(int i=1; i<=numOfN; i++) {
				template.push(new N(i));
			}

			String[] st2 = br.readLine().split(" ");
			for(int i=0; i<numOfE; i++) {
				template.get(Integer.parseInt(st2[2*i])).add(template.get(Integer.parseInt(st2[2*i+1])));
				template.get(Integer.parseInt(st2[2*i+1])).setParent(template.get(Integer.parseInt(st2[2*i])));
			}
			
			N temp = template.get(one).getParent();
			N temp2 = template.get(another).getParent();
			while(temp != temp2) {
				if(temp2.getValue() == 1) {
					temp = temp.getParent();
					temp2 = template.get(another).getParent();
				}
				temp2 = temp2.getParent();
			}
			
			N answer = temp;
			System.out.print("#" + t + " " + answer.getValue() + " ");
			template.inOrder(answer);
			System.out.println(template.getCnt());	
		}
	}
}

class T {
	private ArrayList<N> list = new ArrayList<>();
	private int cnt;
	
	public void push(N v) {
		list.add(v);
	}
	
	public N get(int value) {
		return list.get(value);
	}
	
	public void inOrder(N n) {
		if(n == null) return ;
		inOrder(n.getLeft());
		cnt++;
		inOrder(n.getRight());
	}
	
	public int getCnt() {
		return cnt;
	}
}

class N {
	private int value;
	private int idx;
	private N parent;
	private N[] arr = new N[2];
	
	public N(int value) {
		this.value = value;
	}
	
	public void setParent(N parent) {
		this.parent = parent;
	}
	
	public int getValue() {
		return value;
	}
	
	public N getParent() {
		return parent;
	}
	
	public N getLeft() {
		return arr[0];
	}
	
	public N getRight() {
		return arr[1];
	}
	
	public void add(N n) {
		arr[idx++] = n;
	}
}