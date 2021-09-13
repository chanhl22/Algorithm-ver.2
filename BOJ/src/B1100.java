import java.util.Scanner;

public class B1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] a = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                a[i][j] = str.charAt(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (a[i][j] == 'F') {
                            ans++;
                        }
                    }
                } else if (i % 2 == 1) {
                    if (j % 2 == 1) {
                        if (a[i][j] == 'F') {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

//Another Solution
//import java.util.Scanner;
//
//public class WhiteSpace_Sol_2 {
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    final int SIZE = 8;
//    // 체스판
//    char[][] chessBoard = new char[SIZE][SIZE];
//    // 하얀 칸 위의 말 개수
//    int num = 0;
//
//    String str = "";
//    for (int i = 0; i < SIZE; i++) {
//      str = scanner.nextLine();
//      for (int j = 0; j < SIZE; j++) {
//        chessBoard[i][j] = str.charAt(j);
//
//        // (i + j)를 2로 나눈 나머지가 0인 경우 => 하얀 칸이다.
//        if ((i + j) % 2 == 0 && chessBoard[i][j] == 'F') {
//            num++;
//        }
//      }
//    }
//
//    System.out.println(num);
//  }
//}