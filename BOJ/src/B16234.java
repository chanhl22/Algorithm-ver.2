/**
 * playtime = 39:48
 * 풀이횟수 = 2
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16234 {

    private static int n;
    private static int l;
    private static int r;
    private static int[][] people;
    private final static int[] dx = {0, 0, -1, 1};
    private final static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        people = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                people[i][j] = sc.nextInt();
            }
        }
    }

    private static void solution() {
        int answer = 0;
        while (true) {
            if (bfs()) {
                answer++;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean bfs() {
        boolean isOk = false;
        boolean[][] isVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisit[i][j]) {
                    continue;
                }
                isVisit[i][j] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                q.add(j);
                Queue<Integer> store = new LinkedList<>();
                store.add(i);
                store.add(j);
                int sum = people[i][j];
                while (!q.isEmpty()) {
                    int x = q.remove();
                    int y = q.remove();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (!isVisit[nx][ny]) {
                                if (Math.abs(people[x][y] - people[nx][ny]) >= l && Math.abs(people[x][y] - people[nx][ny]) <= r) {
                                    q.add(nx);
                                    q.add(ny);
                                    isVisit[nx][ny] = true;
                                    store.add(nx);
                                    store.add(ny);
                                    sum += people[nx][ny];
                                    isOk = true;
                                }
                            }
                        }
                    }
                }

                int value = sum / (store.size() / 2);
                while (!store.isEmpty()) {
                    int x = store.remove();
                    int y = store.remove();
                    people[x][y] = value;
                }
            }
        }
        return isOk;
    }
}

/* Standard solution

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16234 {
	static int n;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static boolean bfs(int[][] a, int l, int r) {
		boolean[][] c = new boolean[n][n];
		boolean ok = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == false) {
					Queue<Integer> q = new LinkedList<>();
					q.add(i);
					q.add(j);
					Queue<Integer> s = new LinkedList<>();
					s.add(i);
					s.add(j);
					c[i][j] = true;
					int sum = a[i][j];
					while (!q.isEmpty()) {
						int x = q.remove();
						int y = q.remove();
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								if (c[nx][ny] == true) continue;
								int diff = a[x][y] - a[nx][ny];
								if (diff < 0) {
									diff *= -1;
								}
								if (diff >= l && diff <= r) {
									q.add(nx);
									q.add(ny);
									s.add(nx);
									s.add(ny);
									c[nx][ny] = true;
									ok = true;
									sum += a[nx][ny];
								}
							}
						}
					}
					int val = sum / (s.size() / 2);
					while (!s.isEmpty()) {
						int x = s.remove();
						int y = s.remove();
						a[x][y] = val;
					}
				}
			}
		}
		return ok;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int[][] a = new int[n][n];
		for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
		int ans = 0;
		while (true) {
			if (bfs(a,l,r)) {
				ans += 1;
			}
			else {
				break;
			}
		}
		System.out.println(ans);
	}
}
*/
