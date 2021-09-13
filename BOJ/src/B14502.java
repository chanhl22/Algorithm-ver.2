import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14502 {
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int go(int[][] a, int count) {
        int ans = 0;
        if (count == 3) {
            int[][] b = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    b[i][j] = a[i][j];
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i][j] == 2) {
                        q.add(i);
                        q.add(j);
                    }
                }
            }
            while (!q.isEmpty()) {
                int nx = q.remove();
                int ny = q.remove();
                for (int i = 0; i < 4; i++) {
                    int nnx = nx + dx[i];
                    int nny = ny + dy[i];
                    if (nnx >= 0 && nnx < n && nny >= 0 && nny < m) {
                        if (b[nnx][nny] == 0) {
                            b[nnx][nny] = 2;
                            q.add(nnx);
                            q.add(nny);
                        }
                    }
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i][j] == 0) {
                        c += 1;
                    }
                }
            }
            return c;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    a[i][j] = 1;
                    int temp = go(a, count + 1);
                    if (temp > ans) {
                        ans = temp;
                    }
                    a[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        ans = go(a, 0);
        System.out.println(ans);
    }
}

//for, BFS
/*
import java.util.*;
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m;
    static int[][] a = new int[10][10];
    static int[][] b = new int[10][10];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int bfs() {
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                b[i][j] = a[i][j];
                if (b[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (b[nx][ny] == 0) {
                        b[nx][ny] = 2;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (b[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int x1=0; x1<n; x1++) {
            for (int y1=0; y1<m; y1++) {
                if (a[x1][y1] != 0) continue;
                for (int x2=0; x2<n; x2++) {
                    for (int y2=0; y2<m; y2++) {
                        if (a[x2][y2] != 0) continue;
                        for (int x3=0; x3<n; x3++) {
                            for (int y3=0; y3<m; y3++) {
                                if (a[x3][y3] != 0) continue;
                                if (x1 == x2 && y1 == y2) continue;
                                if (x1 == x3 && y1 == y3) continue;
                                if (x2 == x3 && y2 == y3) continue;
                                a[x1][y1] = 1;
                                a[x2][y2] = 1;
                                a[x3][y3] = 1;
                                int cur = bfs();
                                if (ans < cur) ans = cur;
                                a[x1][y1] = 0;
                                a[x2][y2] = 0;
                                a[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
*/


//for, DFS
/*
import java.util.*;
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m;
    static int[][] a = new int[10][10];
    static int[][] b = new int[10][10];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void dfs(int x, int y) {
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (b[nx][ny] == 0) {
                    b[nx][ny] = 2;
                    dfs(nx,ny);
                }
            }
        }
    }
    static int dfs() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                b[i][j] = a[i][j];
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (b[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (b[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int x1=0; x1<n; x1++) {
            for (int y1=0; y1<m; y1++) {
                if (a[x1][y1] != 0) continue;
                for (int x2=0; x2<n; x2++) {
                    for (int y2=0; y2<m; y2++) {
                        if (a[x2][y2] != 0) continue;
                        for (int x3=0; x3<n; x3++) {
                            for (int y3=0; y3<m; y3++) {
                                if (a[x3][y3] != 0) continue;
                                if (x1 == x2 && y1 == y2) continue;
                                if (x1 == x3 && y1 == y3) continue;
                                if (x2 == x3 && y2 == y3) continue;
                                a[x1][y1] = 1;
                                a[x2][y2] = 1;
                                a[x3][y3] = 1;
                                int cur = dfs();
                                if (ans < cur) ans = cur;
                                a[x1][y1] = 0;
                                a[x2][y2] = 0;
                                a[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
*/
