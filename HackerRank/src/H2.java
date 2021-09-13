import java.util.Scanner;

public class H2 {
    public static int solve(int[] arr, int k) {
        int result = 0;
        if (k % 2 == 0) {
            result = result + Math.min(arr[k / 2], 1);
        }
        result = result + Math.min(arr[0], 1);
        for (int j = 1; j <= k / 2; j++) {
            if (j != k - j) {
                result += Math.max(arr[j], arr[k - j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt() % k]++;
        }
        System.out.println(solve(arr, k));
    }
}

//https://insanelysimple.tistory.com/195
//http://egloos.zum.com/udgrasil/v/2633637