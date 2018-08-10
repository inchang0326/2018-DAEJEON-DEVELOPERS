import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1231_InOrderTraversal {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			Template template = new Template();
			template.add(null);
			int[] leftValue, rightValue;
			
			int N = Integer.parseInt(br.readLine());
			leftValue = new int[N+1];
			rightValue = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				String[] st = br.readLine().split(" ");
				int value = Integer.parseInt(st[0]);
				char alph = st[1].charAt(0);
				template.add(new Visit(value, alph));
				if(st.length > 2) {
					leftValue[i] = Integer.parseInt(st[2]);
				}
				if(st.length == 4) {
					rightValue[i] = Integer.parseInt(st[3]);
				}
			}
			
			for(int i=1; i<=N; i++) {
				template.get(i).setLeft(template.get(leftValue[i]));
				template.get(i).setRight(template.get(rightValue[i]));
			}
			
			System.out.print("#" + t + " ");
			template.inOrder(template.get(1));			
			System.out.println();
		}
	}
}

class Template {
	private ArrayList<Visit> list = new ArrayList<>();
	
	public void add(Visit v) {
		list.add(v);
	}
	
	public Visit get(int value) {
		return list.get(value);
	}
	
	public void inOrder(Visit v) {
		if(v == null) return ;
		inOrder(v.getLeft());
		System.out.print(v.getAlph());
		inOrder(v.getRight());
	}
}

class Visit {
	private int value;
	private char alph;
	private Visit left, right;

	public Visit(int value, char alph) {
		this.value = value;
		this.alph = alph;
	}
	
	public char getAlph() {
		return alph;
	}
	
	public Visit getLeft() {
		return left;
	}

	public void setLeft(Visit left) {
		this.left = left;
	}

	public Visit getRight() {
		return right;
	}

	public void setRight(Visit right) {
		this.right = right;
	}
}