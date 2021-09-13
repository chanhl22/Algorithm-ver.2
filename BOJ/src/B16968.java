//import java.util.Scanner;
//
//public class B16968 {
//    static int go(String s, int index, char last){
//        if (index == s.length()){
//            return 1;
//        }
//        int ans = 0;
//        char start = (s.charAt(index) == 'c') ? 'a' : '0';
//        char end = (s.charAt(index) == 'c') ? 'z' : '9';
//        for (char i = start; i <= end; i++) {
//            if (i != last) {
//                ans += go(s,index+1,i);
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(go(s,0, ' '));
//    }
//}


//Solve by Combination
import java.util.Scanner;

public  class B16968 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ans = 1;
        for (int i = 0; i < s.length(); i++) {
            int cnt = (s.charAt(i) == 'c') ? 26 : 10;
            if (i > 0 && s.charAt(i) == s.charAt(i-1)){
                cnt -= 1;
            }
            ans *= cnt;
        }
        System.out.println(ans);
    }
}