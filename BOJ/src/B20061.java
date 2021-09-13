import java.util.Scanner;

public class B20061 {
    static int simulate(int[][] board, int col, int type) {
        int max_row = -1;
        int ans = 0;
        //board에서 블록을 최대한 내림
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 0) {
                max_row = i;
            } else {
                break;
            }
        }
        //type == 2, col+1도 같이 내림
        if (type == 2) {
            int max_row_2 = -1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][col + 1] == 0) {
                    max_row_2 = i;
                } else {
                    break;
                }
            }
            //type == 2일 때, 비교해서 더 낮은 값 위에 다음 블록이 쌓이니까 min값을 구함
            max_row = Math.min(max_row, max_row_2);
        }
        //board에 쌓이는 블록
        board[max_row][col] = 1;
        if (type == 2) {
            board[max_row][col + 1] = 1;
        }
        if (type == 3) {
            board[max_row - 1][col] = 1;
        }
        //행/열이 다 차면 삭제
        int delete_row = -1;
        for (int i = 0; i < board.length; i++) {
            //all : 행/열에 하나라도 0이 있으면 false
            boolean all = true;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    all = false;
                }
            }
            //행/열이 다 채워져 있다면
            if (all) {
                delete_row = i;//지워지는 행/열 중 가장 아래의 행/열
                ans += 1;//ans 1증가
            }
        }
        //지워진게 있다면
        if (ans > 0) {
            for (int i = delete_row; i > 0; i--) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = 0;
                    if (i - ans > 0) {
                        board[i][j] = board[i - ans][j];
                    }
                }
            }
        }
        //연한 부분
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            //exists : 행/열에 하나라도 1이 있으면 true
            boolean exists = false;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    exists = true;
                }
            }
            //행/열이 하나라도 있으면
            if (exists) {
                cnt += 1;
            }
        }
        //연한 칸에 블록이 있다면
        if (cnt > 0){
            for (int i = board.length - 1; i >= 0; i--) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = 0;
                    if (i - cnt >= 0) {
                        board[i][j] = board[i-cnt][j];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0; //score
        int[][] green = new int[6][4];
        int[][] blue = new int[6][4];
        while (n-- > 0) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            //green board
            if (t == 1) {
                ans += simulate(green, y, 1);
            } else if (t == 2) {
                ans += simulate(green, y, 2);
            } else if (t == 3) {
                ans += simulate(green, y, 3);
            }
            //blue board
            if (t == 1) {
                ans += simulate(blue, x, 1);
            } else if (t == 2) {
                ans += simulate(blue, x, 3);
            } else if (t == 3) {
                ans += simulate(blue, x, 2);
            }
        }
        System.out.println(ans);
        //count green & blue
        int cnt = 0;
        for (int i = 0; i < green.length; i++) {
            for (int j = 0; j < green[i].length; j++) {
                if (green[i][j] > 0) {
                    cnt += 1;
                }
            }
        }
        for (int i = 0; i < blue.length; i++) {
            for (int j = 0; j < blue[i].length; j++) {
                if (blue[i][j] > 0){
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
