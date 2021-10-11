import java.util.Scanner;
import java.util.Stack;

public class B2662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //투자 금액
        int m = sc.nextInt(); //기업 개수
        int[][] company = new int[m + 1][n + 1];
        int[][] d = new int[m + 1][n + 1];
        int[][] v = new int[m + 1][n + 1];
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            for (int j = 1; j <= m; j++) {
                company[j][money] = sc.nextInt();
            }
        }
        //d[n][m] : 기업의 번호 m까지 탐색할 때, 투자 금액이 n일 때 최대값
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= j; k++) {
                    int temp = d[i-1][j-k] + company[i][k];
                    if (d[i][j] < temp) {
                        d[i][j] = temp;
                        v[i][j] = k;
                    }
                }
            }
        }
        System.out.println(d[m][n]);
        Stack<Integer> s = new Stack<>();
        while (m > 0) {
            int temp = v[m][n];
            s.add(temp);
            n -= temp;
            m--;
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
}


//시간 초과 O(N! * M) = 300! * 20
//import java.util.Scanner;
//
//public class B2662 {
//    static int n;
//    static int m;
//    static int[][] company;
//    static int[][] record; //역추적
//
//    static int go(int money, int index) {
//        if (index > m) {
//            return 0;
//        }
//        int res = 0;
//        for (int i = 0; i <= money; i++) {
//            int temp = company[i][index] + go(money - i, index + 1);
//            if (res < temp) {
//                res = temp;
//                record[money][index] = i;
//            }
//        }
//        return res;
//    }
//
//    static void print() {
//        int total = n;
//        for (int i = 1; i <= m; i++) {
//            System.out.print(record[total][i] + " ");
//            total -= record[total][i];
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt(); //투자 금액
//        m = sc.nextInt(); //기업 개수
//        company = new int[n + 1][m + 1];
//        record = new int[n + 1][m + 1];
//        for (int i = 0; i < n; i++) {
//            int money = sc.nextInt();
//            for (int j = 1; j <= m; j++) {
//                company[money][j] = sc.nextInt();
//            }
//        }
//        int ans = go(n, 1);
//        System.out.println(ans);
//        print();
//    }
//}
