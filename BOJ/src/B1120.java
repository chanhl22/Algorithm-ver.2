import java.util.Scanner;

public class B1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int diff = b.length() - a.length();
        int ans = -1;
        for (int i = 0; i <= diff; i++) {
            int cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    cnt++;
                }
            }
            /*초기값을 함부로 바꾸면 증감식도 항상 맞게 변하는지 생각해야한다.
            j를 a문자열의 길이도 두었는데 초기값이 바뀌면 당연히 증감식의 범위도 바뀌어야함*/
//            for (int j = i, k = 0; j < a.length() + i; j++, k++) {
//                if (a.charAt(k) != b.charAt(j)) {
//                    cnt++;
//                }
//            }
            if (ans == -1 || ans > cnt) {
                ans = cnt;
            }
        }
        System.out.println(ans);
    }
}
