//playtime = 43:53

import java.util.*;

class Pair18405 {
    int x;
    int y;
    int virus;

    public Pair18405(int x, int y, int virus) {
        this.x = x;
        this.y = y;
        this.virus = virus;
    }
}

public class B18405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n][n];
        ArrayList<Pair18405> virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) {
                    virus.add(new Pair18405(i, j, map[i][j]));
                }
            }
        }
        Collections.sort(virus, (o1, o2) -> o1.virus - o2.virus);
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        int s = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Pair18405> q = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            q.add(virus.get(i));
        }
        for (int i = 0; i < virus.size(); i++) {
            int tx = virus.get(i).x;
            int ty = virus.get(i).y;
            visited[tx][ty] = 0;
        }
        while (!q.isEmpty()) {
            Pair18405 p = q.remove();
            int sx = p.x;
            int sy = p.y;
            int sv = p.virus;
            for (int t = 0; t < 4; t++) {
                int nx = sx + dx[t];
                int ny = sy + dy[t];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (visited[nx][ny] == -1 && map[nx][ny] == 0) {
                        q.add(new Pair18405(nx, ny, sv));
                        visited[nx][ny] = visited[sx][sy] + 1;
                        map[nx][ny] = sv;
                    }
                }
            }
        }
        if (visited[x][y] <= s) {
            System.out.println(map[x][y]);
        } else {
            System.out.println("0");
        }
    }
}
