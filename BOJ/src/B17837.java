import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Piece2 {
	int no;
	int dir;

	Piece2(int no, int dir) {
		this.no = no;
		this.dir = dir;
	}
}

class Pair17837 {
	int row;
	int col;
	int index;

	Pair17837(int row, int col, int index) {
		this.row = row;
		this.col = col;
		this.index = index;
	}
}

public class B17837 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void go(ArrayList<Piece2>[][] a, Pair17837[] where, int x, int y, int nx, int ny, int index) {
		for (int i = index; i < a[x][y].size(); i++) {
			Piece2 p = a[x][y].get(i);
			a[nx][ny].add(p);
			where[p.no] = new Pair17837(nx, ny, a[nx][ny].size() - 1);
		}
		a[x][y] = new ArrayList<>(a[x][y].subList(0, index));
	}

	static int opposite(int dir) {
		if (dir == 0) {
			dir = 1;
		} else if (dir == 1) {
			dir = 0;
		} else if (dir == 2) {
			dir = 3;
		} else if (dir == 3) {
			dir = 2;
		}
		return dir;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] board = new int[n][n];
		ArrayList<Piece2>[][] a = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				a[i][j] = new ArrayList<>();
			}
		}
		Pair17837[] where = new Pair17837[k];
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int dir = sc.nextInt() - 1;
			a[x][y].add(new Piece2(i, dir));
			where[i] = new Pair17837(x, y, a[x][y].size() - 1);
		}

		// 1000������ �̵��ϰ� ������ ���ٸ� -1
		for (int turn = 1; turn <= 1000; turn++) {
			// �� ������ ������� �̵�
			for (int i = 0; i < k; i++) {
				int x = where[i].row;
				int y = where[i].col;
				int index = where[i].index;
				int dir = a[x][y].get(index).dir;
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				// �����ȿ� ���� ������ �Ķ����� ������ ���
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					// ���� �ȿ� ���µ� �Ķ����̶�� ������ �ݴ��
					if (board[nx][ny] == 2) {
						a[x][y].get(index).dir = opposite(dir);
					}
				} else {
					a[x][y].get(index).dir = opposite(dir);
				}
				// �̵����� �ʰ� ���� ��ġ���� ���⸸ �ٲ����ϱ� �̵��ϴ� ĭ���� ��ǥ�� ������ ���� �������
				dir = a[x][y].get(index).dir;
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (board[nx][ny] == 0) {
						go(a, where, x, y, nx, ny, index);
					} else if (board[nx][ny] == 1) {
						//���⼭ ���� ����� �ȵǴ� ������
						//temp��� ���ο� ����Ʈ�� ���� �ѱ�°� �ƴ� a[][] arraylist�� �Ϻθ� �����ͼ� �ӽ÷� ���
						//���� a[][] arraylist �Ϻκи� ������ �ٲٴ� ���̱� �����̴�. ex) 1234 -> 1243
						//a[][] arraylist�� �״�� ���!!!!
						//���� ���� �Ѱ��ִ°� �ƴ�, �� �޸𸮸� ������ �ʿ䰡 ���� ����, a[][] arraylist�� �״�� �Ѱ��ֱ� ����
						//���� go�Լ��� ���� ������ִ°� ����
						List<Piece2> temp = a[x][y].subList(index, a[x][y].size());
						Collections.reverse(temp);
						go(a, where, x, y, nx, ny, index);
					}
					if (a[nx][ny].size() >= 4) {
						System.out.println(turn);
						System.exit(0);
					}
				} else {
				}
			}
		}
		System.out.println(-1);
	}
}