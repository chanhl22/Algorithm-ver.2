/**
 * playtime = 46:23
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1388 {
    private static int N;
    private static int M;
    private static char[][] BOARD;

    public static void main(String[] args) {
        input();
        count();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        BOARD = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                BOARD[i][j] = input.charAt(j);
            }
        }
    }

    private static void count() {
        int answer = 0;
        answer += countRow();
        answer += countColumn();
        System.out.println(answer);
    }

    private static int countRow() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean[] isVisited = new boolean[M];
            for (int j = 0; j < M; j++) {
                if (BOARD[i][j] == '-' && !isVisited[j]) {
                    bfs(BOARD[i], isVisited, '-', j, M);
                    count++;
                }
            }
        }
        return count;
    }

    private static int countColumn() {
        int count = 0;
        for (int j = 0; j < M; j++) {
            boolean[] isVisited = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (BOARD[i][j] == '|' && !isVisited[i]) {
                    bfs(convert(j), isVisited, '|', i, N);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(char[] chars, boolean[] isVisited, char checkChar, int index, int maxIndex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        isVisited[index] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int nx = x + 1;
            if (nx < maxIndex && chars[nx] == checkChar && !isVisited[nx]) {
                isVisited[nx] = true;
                q.add(nx);
            }
        }
    }

    private static char[] convert(int y) {
        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            result[i] = BOARD[i][y];
        }
        return result;
    }
}
