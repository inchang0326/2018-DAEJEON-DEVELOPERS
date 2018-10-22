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
			
			// 개복치의 크기보다 작은 물고기들의 위치 리스트
			for(int i=1; i<curS; i++) {
				for(int j=0; i<7 && j<locationList.get(i).size(); j++) {
					
					// 현재 개복치의 위치와 개복치 크기보다 작은 물고기 위치 사이의 거리를 구한다.
					int dist = getDist(curP, locationList.get(i).get(j), map, N);
					
					// 최소거리에 있는 물고기를 찾는다.
					if((minDist != 0 && dist != 0) && minDist > dist) {
						minValue = i;
						minIdx = j;
						minDist = dist;
						isThere = true;
					} 
					// 최소거리가 같다면
					if((minDist != 0 && dist != 0) && minDist == dist) {
						// 두 거리의 row가 같다면
						if(locationList.get(minValue).get(minIdx).getRow() == locationList.get(i).get(j).getRow()) {
							// 더 작은 col 값을 갖는 위치에 있는 물고기를 잡아먹는다.
							if(locationList.get(minValue).get(minIdx).getCol() > locationList.get(i).get(j).getCol()) {
								minValue = i;
								minIdx = j;
							}
						} 
						else {
							// row가 더 작은 위치에 있는 물고기를 잡아먹는다.
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
			
			// map안에 개복치가 잡아먹을 수 있는 물고기가 있다면
			if(isThere) {
				// 개복치가 물고기를 잡아먹는다.
				curP.eat();
				
				// 잡아 먹은 개수가 개복치 자신의 크기만큼이라면
				if(curP.getCnt() == curP.getSize()) {
					// 크기가 커진다.
					curP.sizeUp();
					// 먹은 개수를 0으로 초기화한다.
					curP.setCnt();
				}
				
				// 개복치의 현재 위치를 0으로 바꿔준다. 
				map[curR][curC] = 0;
				// 개복치가 갈 다음 위치를 저장한다.
				P nxtP = locationList.get(minValue).get(minIdx);
				int nxtR = nxtP.getRow();
				int nxtC = nxtP.getCol();
				curP.setRow(nxtR);
				curP.setCol(nxtC);
				
				// queue에 개복치의 다음 위치 삽입
				queue.add(curP);
				
				// map에서 개복치의 다음위치에 개복치의 크기를 저장한다.
				map[nxtR][nxtC] = curP.getSize();
				
				// 개복치의 크기보다 작았던, 최소거리에 있던 물고기를 리스트에서 제거한다.  
				locationList.get(minValue).remove(nxtP);
				
				// 거리 1은 시간 1분..
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
		// from에서 to까지 갈 수 있었다면
		if(flag) 
			return cnt;
		// 갈 수 없었다면
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