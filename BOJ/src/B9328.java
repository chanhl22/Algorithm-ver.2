import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9328 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            // 입력 (배열 테두리 추가)
            int h = sc.nextInt();
            int w = sc.nextInt();
            char[][] a = new char[h + 4][w + 4];
            for (int i = 2; i < h + 2; i++) {
                String line = sc.next();
                for (int j = 2; j < w + 2; j++) {
                    a[i][j] = line.charAt(j - 2);
                }
            }
            for (int i = 0; i < h + 4; i++) {
                a[i][0] = '*';
                a[i][1] = '.';
                a[i][w + 2] = '.';
                a[i][w + 3] = '*';
            }
            for (int i = 1; i < w + 3; i++) {
                a[0][i] = '*';
                a[1][i] = '.';
                a[h + 2][i] = '.';
                a[h + 3][i] = '*';
            }

            //key 입력
            boolean[] key = new boolean[26];
            String keys = sc.next();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    key[keys.charAt(i) - 'a'] = true;
                }
            }

            //bfs
            Queue<Integer> q = new LinkedList<>(); // bfs를 위한 큐
            boolean[][] check = new boolean[h + 4][w + 4];
            Queue<Integer>[] door = new LinkedList[26]; // 모든 문을 보관하기 위한 큐
            for (int i = 0; i < 26; i++) {
                door[i] = new LinkedList<>();
            }
            int ans = 0;
            q.add(1);
            q.add(1);
            check[1][1] = true;
            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (check[nx][ny]) continue;
                    if (a[nx][ny] == '*') continue;
                    check[nx][ny] = true;
                    if (a[nx][ny] == '.') {
                        q.add(nx);
                        q.add(ny);
                    } else if (a[nx][ny] == '$') {
                        ans += 1;
                        q.add(nx);
                        q.add(ny);
                    } else if (a[nx][ny] >= 'A' && a[nx][ny] <= 'Z') {
                        // 키가 있으면 그냥 진행
                        if (key[a[nx][ny] - 'A']) {
                            q.add(nx);
                            q.add(ny);
                        } else { // 키가 없다면 해당 door 큐에 보관
                            door[a[nx][ny] - 'A'].add(nx);
                            door[a[nx][ny] - 'A'].add(ny);
                        }
                    } else if (a[nx][ny] >= 'a' && a[nx][ny] <= 'z') {
                        q.add(nx);
                        q.add(ny);
                        // 키를 찾으면 door의 값을 전부 bfs 큐로 보냄
                        key[a[nx][ny] - 'a'] = true;
                        while(!door[a[nx][ny] - 'a'].isEmpty()){
                            q.add(door[a[nx][ny] - 'a'].remove());
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}


//Code Refactoring
//import java.util.*;
//public class B9328 {
//    static char[][] a = new char[111][111];
//    static boolean[][] c = new boolean[111][111];
//    static boolean[] key = new boolean[111];
//    static int[] dx = {0,0,1,-1};
//    static int[] dy = {1,-1,0,0};
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            for (int i=0; i<111; i++) {
//                for (int j=0; j<111; j++) {
//                    a[i][j] = 0;
//                }
//            }
//            for (int i=2; i<n+2; i++) {
//                String line = sc.next();
//                for (int j=0; j<m; j++) {
//                    a[i][j+2] = line.charAt(j);
//                }
//            }
//            n += 4;
//            m += 4;
//            for (int i=0; i<n; i++) {
//                a[i][0] = '*';
//                a[i][1] = '.';
//                a[i][m-2] = '.';
//                a[i][m-1] = '*';
//            }
//            for (int j=1; j<m-1; j++) {
//                a[0][j] = '*';
//                a[1][j] = '.';
//                a[n-2][j] = '.';
//                a[n-1][j] = '*';
//            }
//            Arrays.fill(key, false);
//            String temp = sc.next();
//            int len = temp.length();
//            if (temp.charAt(0) != '0') {
//                for (int i=0; i<len; i++) {
//                    key[temp.charAt(i)-'a'] = true;
//                }
//            }
//            int ans = 0;
//            for (int i=0; i<111; i++) {
//                Arrays.fill(c[i], false);
//            }
//            Queue<Integer> q = new LinkedList<>();
//            Queue<Integer>[] door = new LinkedList[26];
//            for (int i=0; i<26; i++) {
//                door[i] = new LinkedList<Integer>();
//            }
//            q.add(1); q.add(1);
//            c[1][1] = true;
//            while (!q.isEmpty()) {
//                int x = q.remove();
//                int y = q.remove();
//                for (int k=0; k<4; k++) {
//                    int nx = x+dx[k];
//                    int ny = y+dy[k];
//                    if (c[nx][ny]) {
//                        continue;
//                    }
//                    char w = a[nx][ny];
//                    if (w == '*') {
//                        continue;
//                    }
//                    c[nx][ny] = true;
//                    if (w == '.') {
//                        q.add(nx); q.add(ny);
//                    } else if (w == '$') {
//                        ans += 1;
//                        q.add(nx); q.add(ny);
//                    } else if (w >= 'A' && w <= 'Z') {
//                        if (key[w-'A']) {
//                            q.add(nx); q.add(ny);
//                        } else {
//                            door[w-'A'].add(nx);
//                            door[w-'A'].add(ny);
//                        }
//                    } else if (w >= 'a' && w <= 'z') {
//                        q.add(nx); q.add(ny);
//                        if (!key[w-'a']) {
//                            key[w-'a'] = true;
//                            while (!door[w-'a'].isEmpty()) {
//                                q.add(door[w-'a'].remove());
//                            }
//                        }
//                    }
//                }
//            }
//            System.out.println(ans);
//        }
//    }
//}