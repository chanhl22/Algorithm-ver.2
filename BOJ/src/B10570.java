import java.util.Scanner;

public class B10570 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] all = new int[1001];
            int v = sc.nextInt();
            for (int j = 0; j < v; j++) {
                int num = sc.nextInt();
                all[num]++;
            }
            int cnt = 0;
            int ans = 0;
            for (int j = 0; j < 1001; j++) {
                int temp = all[j];
                if (cnt < temp) {
                    cnt = temp;
                    ans = j;
                }
            }
            System.out.println(ans);
        }
    }
}
