import java.util.*;

class Solution49 {
    public int[] solution(long n) {
        ArrayList<Integer> a = new ArrayList<>();
        while(n != 0){
            a.add((int)(n % 10));
            n /= 10;
        }
        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
}

//Another Solution
//class Solution {
//  public int[] solution(long n) {
//      String a = "" + n;
//        int[] answer = new int[a.length()];
//        int cnt=0;
//        while(n>0) {
//            answer[cnt]=(int)(n%10);
//            n/=10;
//            cnt++;
//        }
//      return answer;
//  }
//}

public class P12932 {
    public static void main(String[] args) {
        Solution49 sol = new Solution49();
        int[] ans = sol.solution(12345);
        System.out.println(Arrays.toString(ans));
    }
}