import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BAEKJOON_16236 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		P start = new P();
		ArrayList<ArrayList<P>> locationList = new ArrayList<ArrayList<P>>();
		ArrayList<P> zeroList = new ArrayList<>();
		ArrayList<P> oneList = new ArrayList<>();
		ArrayList<P> twoList = new ArrayList<>();
		ArrayList<P> threeList = new ArrayList<>();
		ArrayList<P> fourList = new ArrayList<>();
		ArrayList<P> fiveList = new ArrayList<>();
		ArrayList<P> sixList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				switch(map[i][j]) {
				case 1 : {
					oneList.add(new P(i, j, 1));
					break;
				}
				case 2 : {
					twoList.add(new P(i, j, 2));
					break;
				}
				case 3 : {
					threeList.add(new P(i, j, 3));
					break;
				}
				case 4 : {
					fourList.add(new P(i, j, 4));
					break;
				}
				case 5 : {
					fiveList.add(new P(i, j, 5));
					break;
				}
				case 6 : {
					sixList.add(new P(i, j, 6));
					break;
				}
				case 9 : {
					start = new P(i, j, 2);
					break;
				}
				}
			}
		}
		locationList.add(zeroList);
		locationList.add(oneList);
		locationList.add(twoList);
		locationList.add(threeList);
		locationList.add(fourList);
		locationList.add(fiveList);
		locationList.add(sixList);
		
		Queue<P> queue = new ArrayDeque<>();
		queue.add(start);
		int time = 0;
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			int curR = curP.getRow();
			int curC = curP.getCol();
			int curS = curP.getSize();
			int minDist = Integer.MAX_VALUE;
			int minValue = -1;
			int minIdx = -1;
			boolean isThere = false;
			
			// ����ġ�� ũ�⺸�� ���� �������� ��ġ ����Ʈ
			for(int i=1; i<curS; i++) {
				for(int j=0; i<7 && j<locationList.get(i).size(); j++) {
					
					// ���� ����ġ�� ��ġ�� ����ġ ũ�⺸�� ���� ����� ��ġ ������ �Ÿ��� ���Ѵ�.
					int dist = getDist(curP, locationList.get(i).get(j), map, N);
					
					// �ּҰŸ��� �ִ� ����⸦ ã�´�.
					if((minDist != 0 && dist != 0) && minDist > dist) {
						minValue = i;
						minIdx = j;
						minDist = dist;
						isThere = true;
					} 
					// �ּҰŸ��� ���ٸ�
					if((minDist != 0 && dist != 0) && minDist == dist) {
						// �� �Ÿ��� row�� ���ٸ�
						if(locationList.get(minValue).get(minIdx).getRow() == locationList.get(i).get(j).getRow()) {
							// �� ���� col ���� ���� ��ġ�� �ִ� ����⸦ ��ƸԴ´�.
							if(locationList.get(minValue).get(minIdx).getCol() > locationList.get(i).get(j).getCol()) {
								minValue = i;
								minIdx = j;
							}
						} 
						else {
							// row�� �� ���� ��ġ�� �ִ� ����⸦ ��ƸԴ´�.
							if(locationList.get(minValue).get(minIdx).getRow() > locationList.get(i).get(j).getRow()) {
								minValue = i;
								minIdx = j;
							}
						}
						minDist = dist;
						isThere = true;
					}
				}
			}
			
			// map�ȿ� ����ġ�� ��Ƹ��� �� �ִ� ����Ⱑ �ִٸ�
			if(isThere) {
				// ����ġ�� ����⸦ ��ƸԴ´�.
				curP.eat();
				
				// ��� ���� ������ ����ġ �ڽ��� ũ�⸸ŭ�̶��
				if(curP.getCnt() == curP.getSize()) {
					// ũ�Ⱑ Ŀ����.
					curP.sizeUp();
					// ���� ������ 0���� �ʱ�ȭ�Ѵ�.
					curP.setCnt();
				}
				
				// ����ġ�� ���� ��ġ�� 0���� �ٲ��ش�. 
				map[curR][curC] = 0;
				// ����ġ�� �� ���� ��ġ�� �����Ѵ�.
				P nxtP = locationList.get(minValue).get(minIdx);
				int nxtR = nxtP.getRow();
				int nxtC = nxtP.getCol();
				curP.setRow(nxtR);
				curP.setCol(nxtC);
				
				// queue�� ����ġ�� ���� ��ġ ����
				queue.add(curP);
				
				// map���� ����ġ�� ������ġ�� ����ġ�� ũ�⸦ �����Ѵ�.
				map[nxtR][nxtC] = curP.getSize();
				
				// ����ġ�� ũ�⺸�� �۾Ҵ�, �ּҰŸ��� �ִ� ����⸦ ����Ʈ���� �����Ѵ�.  
				locationList.get(minValue).remove(nxtP);
				
				// �Ÿ� 1�� �ð� 1��..
				time += minDist;
			}
		}
		System.out.println(time);
	}
	
	public static int getDist(P from, P to, int[][] map, int N) {
		Queue<P> queue = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][N];
		int[] dirR = new int[] {-1, 1, 0, 0};
		int[] dirC = new int[] {0, 0, -1, 1};
		int cnt = 0;
		boolean flag = false;
		
		queue.add(from);
		while(!queue.isEmpty()) {
			int tmpSize = queue.size();
			for(int i=0; i<tmpSize; i++) {
				P curP = queue.poll();
				int curR = curP.getRow();
				int curC = curP.getCol();
				int curS = curP.getSize();
				
				if(curR == to.getRow() && curC == to.getCol()) {
					flag = true;
					break;
				}
				
				for(int j=0; j<4; j++) {
					int nxtR = curR + dirR[j];
					int nxtC = curC + dirC[j];
					
					if((nxtR >=0 && nxtR < N) && (nxtC >=0 && nxtC < N) && !isVisited[nxtR][nxtC] && map[nxtR][nxtC] <= curS) {
						queue.add(new P(nxtR, nxtC, curS));
						isVisited[nxtR][nxtC] = true;
					}
				}
			}
			if(flag)
				break;
			cnt++;
		}
		// from���� to���� �� �� �־��ٸ�
		if(flag) 
			return cnt;
		// �� �� �����ٸ�
		else 
			return 0;
	}
}

class P {
	private int row, col, size, cnt;
	public P() {}
	public P(int row, int col, int size) {
		this.row = row;
		this.col = col;
		this.size = size;
		this.cnt = 0;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getSize() {
		return size;
	}
	public void sizeUp() {
		size++;
	}
	public int getCnt() {
		return cnt;
	}
	public void eat() {
		cnt++;
	}
	public void setCnt() {
		cnt = 0;
	}
}