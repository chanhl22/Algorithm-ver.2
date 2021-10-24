import java.util.Scanner;

public class B2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tree = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
            if (max < tree[i]) {
                max = tree[i];
            }
        }
        int low = 0;
        int high = max;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            long temp = 0;
            for (int i = 0; i < n; i++) {
                if (tree[i] - mid < 0) {
                    continue;
                }
                temp += tree[i] - mid;
            }
            if (temp >= m) { //자른 나무 길이가 m보다 크면 하한을 올려 뒷 부분 탐색
                low = mid + 1;
            } else { //자른 나무 길이가 m보다 작으면 상한을 내려 앞 부분 탐색
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
