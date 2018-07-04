import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class No2819_AppendingNumbers {
	
	private static final int maxSize = 4;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Node> visitedNodes = new ArrayDeque<>();
		Map<Integer, Queue<Node>> nodeTree = new HashMap<>();
		Set<String> numbers = new HashSet<>();
		
		int dirX[] = new int[]{0, 0, -1, 1};
		int dirY[] = new int[]{-1, 1, 0, 0};
		int map[][] = new int[maxSize][maxSize];
		int level = 1;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			
			for(int i=0; i<maxSize; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());	
				for(int j=0; j<maxSize; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			for(int startX=0; startX<maxSize; startX++) {
				for(int startY=0; startY<maxSize; startY++) {
					
					Node startNode = new Node(startX, startY);
					startNode.setPrevNode(null);
					visitedNodes.add(startNode);
					nodeTree.put(level, visitedNodes);
					
					while(level < 7) {
						
						int lmt = nodeTree.get(level).size();
						for(int i=0; i<lmt; i++) {
							Node currNode = visitedNodes.poll();
							int currX = currNode.getX();
							int currY = currNode.getY();
							for(int j=0; j<4; j++) {
								int nextX = currX + dirX[j];
								int nextY = currY + dirY[j];
								if( (nextX >= 0 && nextX < maxSize) && (nextY >= 0 && nextY < maxSize) ) {
									Node nxtNode = new Node(nextX, nextY);
									nxtNode.setPrevNode(currNode);
									visitedNodes.add(nxtNode);
								}
							}
						}
						
						nodeTree.put(++level, visitedNodes);
					}

					Queue<Node> leaves = nodeTree.get(level);
					while(leaves.size() > 0) {
						String number = "";
						Node temp = leaves.poll();
						while(temp != null) {
							number += String.valueOf(map[temp.getX()][temp.getY()]);
							temp = temp.getPrevNode();
						}
						numbers.add(number);
					}
					
					level = 1;
					nodeTree.clear();
					visitedNodes.clear();
				}
			}
		
			System.out.println("#" + t + " " + numbers.size());		
			
			numbers.clear();
		}
	}
}

class Node {
	private int x, y;
	private Node prevNode;
	
	public Node() {
	
	}
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Node getPrevNode() {
		return prevNode;
	}
	
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
}