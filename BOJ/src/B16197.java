import java.util.Scanner;

public class B16197 {
	static char[][] arr;
	static int n;
	static int m;
	static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};

    static int go (int step, int x1, int y1, int x2, int y2) {
    	if (step == 11) {
    		return -1;
    	}
    	boolean fail1 = false;
    	boolean fail2 = false;
    	if (x1<0 || x1>=n || y1<0 || y1>=m) fail1 = true;
    	if (x2<0 || x2>=n || y2<0 || y2>=m) fail2 = true;
    	if (fail1 && fail2) return -1;
    	if (fail1 || fail2) {
    		return step;
    	}
    	int ans = -1;
    	for (int i = 0; i < 4; i++) {
			int nx1 = x1 + dx[i];
			int ny1 = y1 + dy[i];
			int nx2 = x2 + dx[i];
			int ny2 = y2 + dy[i];
			//��� �ȿ� �ְų� #�̰ų�
			//���� �ִٸ� ������ ������ �ֱ� ���� (�ϳ��� ������ ���� �ִ�.)
			if (0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m && arr[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if (0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m && arr[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }
			int count = go (step + 1, nx1, ny1, nx2, ny2);
			if (count == -1) continue;
			if (ans > count || ans == -1) {
				ans = count;
			}
		}
    	return ans;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		arr = new char[n][m];
		int x1,y1,x2,y2;
		x1=y1=x2=y2=-1;
		
		for (int i = 0; i < n; i++) {
			String a = sc.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = a.charAt(j);
				if (arr[i][j] == 'o') {
					if (x1 == -1) {
						x1 = i;
						y1 = j;						
					}
					else {
						x2 = i;
						y2 = j;
					}
					arr[i][j] = '.';
				}
			}
		}
		System.out.println(go(0, x1, y1, x2, y2));
	}

}
