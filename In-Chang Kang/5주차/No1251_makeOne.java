import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No1251_makeOne {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {

			ArrayList<Island> islandList = new ArrayList<>();
			ArrayList<Turnel> turnelList = new ArrayList<>();

			int num = Integer.parseInt(br.readLine());

			// 노드(섬)
			int[][] xy = new int[num][num];
			for (int i = 0; i < 2; i++) {
				String[] st = br.readLine().split(" ");
				for (int j = 0; j < st.length; j++) {
					xy[i][j] = Integer.parseInt(st[j]);
				}
			}
			int[] parent = new int[num];
			for (int i = 0; i < num; i++) {
				islandList.add(new Island(xy[0][i], xy[1][i], i));
				parent[i] = i;
			}

			// 엣지(터널)
			double tax = Double.parseDouble(br.readLine());
			for (int i = 0; i < islandList.size(); i++) {
				Island curr = islandList.get(i);
				for (int j = i + 1; j < islandList.size(); j++) {
					Island next = islandList.get(j);
					turnelList.add(new Turnel(curr, next, getWeight(curr, next, tax)));
				}
			}

			// 최소 간선 합(최소스패닝트리)
			Collections.sort(turnelList);
			double minCost = 0;
			for (int i = 0; i < turnelList.size(); i++) {
				int s = find(parent, turnelList.get(i).getStart().getNumber());
				int e = find(parent, turnelList.get(i).getEnd().getNumber());

				if (s == e)
					continue;
				parent[s] = e;
				minCost += turnelList.get(i).getCost();
			}

			System.out.println("#" + t + " " + Math.round(minCost));
		}
	}

	public static double getWeight(Island one, Island another, double tax) {
		double result = 0.0;
		double dist = Math.sqrt(Math.pow(Math.abs(another.getX() - one.getX()), 2)
				+ Math.pow(Math.abs(another.getY() - one.getY()), 2));
		result = tax * Math.pow(dist, 2);
		return result;
	}

	public static int find(int[] parent, int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent, parent[x]);
	}
}

class Island {
	private int x, y, number;

	public Island() {

	}

	public Island(int x, int y, int number) {
		this.x = x;
		this.y = y;
		this.number = number;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNumber() {
		return number;
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