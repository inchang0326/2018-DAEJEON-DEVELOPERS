import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 *  Prim은 시작 정점(A)에서 최소 가중치를 갖는 주변 정점(B)으로 연결하고
 *  시작 정점(A)과 주변 정점(B)에서 최소 가중치를 갖는 또 다른 주변 정점(C)를 연결하는 방식으로 나아간다. 
 */

public class No1251_MakeOne_Prim {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			
			int num = Integer.parseInt(br.readLine());
			
			int[][] xy = new int[num][num];
			for (int i = 0; i < 2; i++) {
				String[] st = br.readLine().split(" ");
				for (int j = 0; j < st.length; j++) {
					xy[i][j] = Integer.parseInt(st[j]);
				}
			}
			
			// Weighted Graph init
			double[][] graph = new double[num][num];
			double tax = Double.parseDouble(br.readLine());
			for (int i = 0; i < num - 1; i++) {
				for(int j = i + 1; j < num; j++) {
					graph[i][j] = getWeight(xy[0][i], xy[0][j], xy[1][i], xy[1][j], tax);
					graph[j][i] = getWeight(xy[0][i], xy[0][j], xy[1][i], xy[1][j], tax);			
				}
			}
			
			// MST - Prim
			double minCost = prim(graph, num);
			System.out.println("#" + t + " " + Math.round(minCost));
			
		}
		
	}
	
	private static double getWeight(int x1, int x2, int y1, int y2, double tax) {
		double result = 0.0;
		double dist = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) 
					+ Math.pow(Math.abs(y2 - y1), 2));
		return result = tax * Math.pow(dist, 2);
	}
	
	private static double prim(double[][] graph, int size) {	
		
		PriorityQueue<Point> visitedNodes = new PriorityQueue<>();
		boolean[] isVisited = new boolean[size];		
		double minCost = 0.0;
				
		// starting from 0
		visitedNodes.add(new Point(0, 0));
		while(!visitedNodes.isEmpty()) {
			Point now = visitedNodes.poll();
			int idx = now.getNumber();
			
			if(!isVisited[idx]) {
				isVisited[idx] = true;
				minCost += now.getCost();
				for(int i = 0; i<size; i++) {
					if(idx != i) {
						visitedNodes.add(new Point(i, graph[idx][i]));
					}
				}							
			}			
		}		
		
		return minCost;
	}
}

class Point implements Comparable<Point>{
	private int number;
	private double cost;
	
	public Point() {
	}
	
	public Point(int number, double cost) {
		this.number = number;
		this.cost = cost;
	}

	public int getNumber() {
		return number;
	}
	
	public double getCost() {
		return cost;
	}
	
	@Override
	public int compareTo(Point point) {
		if (cost < point.getCost())
			return -1;
		else
			return 1;
	}	
}