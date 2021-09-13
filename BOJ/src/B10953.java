import java.util.Scanner;

public class B10953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0){
            String str = sc.next();
            String[] s = str.split(",");
            int ans = 0;
            for (int i = 0; i < s.length; i++) {
                ans += Integer.parseInt(s[i]);
            }
            System.out.println(ans);
            //System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
        }
    }
}
