import java.util.ArrayList;
import java.util.Scanner;

public class B2331 {
    public static void main(String[] args) {
        //57, 74, 49+16 = 65, 36+25 = 61
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        arr.add(a);
        while (true) {
            int temp = arr.get(arr.size() - 1);
            int res = 0;
            while (temp > 0) {
                int n = temp % 10;
                res += (int)Math.pow(n, p);
                temp /= 10;
            }
            if (arr.contains(res)) {
                int where = arr.indexOf(res);
                for (int i = 0; i < where; i++) {
                    ans.add(arr.get(i));
                }
                break;
            }
            arr.add(res);
        }
        System.out.println(ans.size());
    }
}
