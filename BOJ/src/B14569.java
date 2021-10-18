import java.util.Scanner;

public class B14569 {
    static boolean contains(int[] arr, int key) {
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] subject = new int[n][];
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            subject[i] = new int[k];
            for (int j = 0; j < k; j++) {
                subject[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[][] student = new int[m][];
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            student[i] = new int[k];
            for (int j = 0; j < k; j++) {
                student[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                boolean ok = true;
                for (int k = 0; k < subject[j].length; k++) {
                    //학생 시간에 과목 시간이 있는가?
                    ok = contains(student[i], subject[j][k]);
                    if (ok == false) break;
                }
                if (ok) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
