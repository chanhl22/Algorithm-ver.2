import java.util.Scanner;

public class B13410 {
    static int reverse(int num){
        int result=0;
        while(num!=0){
            result= result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[k+1];
        for (int i = 1; i <= k; i++) {
            int temp = n*i;
            num[i] = reverse(temp);
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (ans < num[i]) {
                ans = num[i];
            }
        }
        System.out.println(ans);
    }
}
