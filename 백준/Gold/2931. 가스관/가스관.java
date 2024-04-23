import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, -1, 1 };	
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.valueOf(st.nextToken());
		int x = Integer.valueOf(st.nextToken());
		map = new int[y + 1][x + 1];
		visited = new boolean[y + 1][x + 1];
		for(int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], true);
		}
		
		int mX = 0, mY = 0, zX = 0, zY = 0;
		for(int i = 1; i <= y; i++) {
			String str = br.readLine();
			for(int j = 1; j <= x; j++) {
				int block = str.charAt(j - 1);
				map[i][j] = block;
				if(block != '.') {
					visited[i][j] = false;
				}
				if(block == 'M') {
					mX = j;
					mY = i;
				}
				if(block == 'Z') {
					zX = j;
					zY = i;
				}
			}
		}
		Block mBlock = searchFirstBlock(mX, mY);
		Block zBlock = searchFirstBlock(zX, zY);
		Block mEndBlock = search(mBlock);
		Block zEndBlock = search(zBlock);
		int removedBlock = getBlock(
				mEndBlock.x, mEndBlock.y, mEndBlock.nextDirection, reverseDirection(zEndBlock.nextDirection)
				);
		System.out.println(mEndBlock.y + " " + mEndBlock.x + " " + (char) removedBlock);
		
	}

	static Block search(Block startBlock) {
		int nextX = startBlock.x + moveX[startBlock.nextDirection];
		int nextY = startBlock.y + moveY[startBlock.nextDirection];
		if(map[nextY][nextX] == '.') {
			return new Block(nextX, nextY, startBlock.nextDirection);
		}
		else {
			visited[nextY][nextX] = true;
			return search(new Block(nextX, nextY, getMoveDirection(map[nextY][nextX], startBlock.nextDirection)));
		}
	}

	static Block searchFirstBlock(int x, int y) {
		visited[y][x] = true;
		for(int i = 0; i < moveX.length; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			if((nextX <= 0 || nextY <= 0) || (nextX >= map[0].length || nextY >= map.length)) {
				continue;
			}
			if(map[nextY][nextX] != '.' && (map[nextY][nextX] != 'Z' && map[nextY][nextX] != 'M')) {
				Block block = new Block(nextX, nextY, getMoveDirection(map[nextY][nextX], i));
				visited[nextY][nextX] = true;
				return block;
			}
		}
		return null;
	}

	static int reverseDirection(int direction) {
		switch(direction) {
		case 0:
			return 1;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 2;
			default:	// ����
				return -1;
		}
	}

	static int getBlock(int x, int y, int prev, int next) {
		if(prev == next) {
			if(prev == 0 || prev == 1)
				return '-';
			else
				return '|';
		}
		else {
			for(int i = 0; i < moveX.length; i++) {
				int nextX = x + moveX[i];
				int nextY = y + moveY[i];
				if((nextX <= 0 || nextY <= 0) || (nextX >= map[0].length || nextY >= map.length)) {
					continue;
				}
				if(!visited[nextY][nextX]) {	
					return '+';
				}
			}

			if((prev == 2 && next == 0) || (prev == 1 && next == 3)) {
				return '1';
			}
			if((prev == 3 && next == 0) || (prev == 1 && next == 2)) {
				return '2';
			}
			if((prev == 0 && next == 2) || (prev == 3 && next == 1)) {
				return '3';
			}
			if((prev == 2 && next == 1) || (prev == 0 && next == 3)) {
				return '4';
			}
			return -1;
		}
		
	}

	static int getMoveDirection(int block, int prevDirection) {
		switch(block) {
		case '1':
			if(prevDirection == 2)
				return 0;
			if(prevDirection == 1)
				return 3;
			break;
		case '2':
			if(prevDirection == 3)
				return 0;
			if(prevDirection == 1)
				return 2;
			break;
		case '3':
			if(prevDirection == 0)
				return 2;
			if(prevDirection == 3)
				return 1;
			break;
		case '4':
			if(prevDirection == 0)
				return 3;
			if(prevDirection == 2)
				return 1;
			break;
		}
		return prevDirection;
	}
}

class Block {
	int x;
	int y;
	int nextDirection;
	Block() {}
	Block(int x, int y, int nextDirection) {
		this.x = x;
		this.y = y;
		this.nextDirection = nextDirection;
	}
	
	public void set(int nextX, int nextY, int nextDirection) {
		this.x = nextX;
		this.y = nextY;
		this.nextDirection = nextDirection;
	}
}