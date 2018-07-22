import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class No1251_makeOne {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			ArrayList<Island> islandList = new ArrayList<>();
			PriorityQueue<Turnel> turnelList = new PriorityQueue<>();

			int num = Integer.parseInt(br.readLine());

			// Island(N) init
			int[][] xy = new int[num][num];
			for (int i = 0; i < 2; i++) {
				String[] st = br.readLine().split(" ");
				for (int j = 0; j < st.length; j++) {
					xy[i][j] = Integer.parseInt(st[j]);
				}
			}
			for (int i = 0; i < num; i++) {
				Island island = new Island(xy[0][i], xy[1][i]);
				island.setParent(island);
				islandList.add(island);
			}

			// Turnel(E) init
			double tax = Double.parseDouble(br.readLine());
			for (int i = 0; i < islandList.size(); i++) {
				Island curr = islandList.get(i);
				for (int j = i + 1; j < islandList.size(); j++) {
					Island next = islandList.get(j);
					turnelList.add(new Turnel(curr, next, getWeight(curr, next, tax)));
				}
			}

			// MST - Kruskal
			double minCost = 0;
			while(!turnelList.isEmpty()) {
				Turnel turnel = turnelList.poll();
				Island sParent = findParent(turnel.getStart());
				Island eParent = findParent(turnel.getEnd());
				
				// Cycle check, if their parents are not identical then it's safe.
				if(sParent != eParent) {
					sParent.setParent(eParent);
					minCost += turnel.getCost();
				}
			}
			System.out.println("#" + t + " " + Math.round(minCost));
		}
	}

	private static double getWeight(Island one, Island another, double tax) {
		double result = 0.0;
		double dist = Math.sqrt(Math.pow(Math.abs(another.getX() - one.getX()), 2)
				+ Math.pow(Math.abs(another.getY() - one.getY()), 2));
		result = tax * Math.pow(dist, 2);
		return result;
	}

	
	
	private static Island findParent(Island island) {
		if(island.getParent() == island) {
			return island;
		} else {
			return findParent(island.getParent());	
		}
	}
}

class Island {
	private int x, y;
	private Island parent;

	public Island() {

	}

	public Island(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Island getParent() {
		return parent;
	}
	
	public void setParent(Island parent) {
		this.parent = parent;
	}
}

class Turnel implements Comparable<Turnel> {
	private Island start, end;
	private double cost;

	public Turnel() {

	}

	public Turnel(Island start, Island end, double cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	public Island getStart() {
		return start;
	}

	public Island getEnd() {
		return end;
	}

	public double getCost() {
		return cost;
	}

	@Override
	public int compareTo(Turnel turnel) {
		if (cost < turnel.getCost())
			return -1;
		else
			return 1;
	}
}