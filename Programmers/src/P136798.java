/**
 * 기사단원의 무기
 * playtime = 5m 30s
 */

public class P136798 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(5, 3, 2);
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int number, int limit, int power) {
            int[] divisor = calculate(number);

            int answer = 0;

            for (int i = 0; i < divisor.length; i++) {
                if (divisor[i] > limit) {
                    answer += power;
                    continue;
                }
                answer += divisor[i];
            }

            return answer;
        }

        private int[] calculate(int number) {
            int[] divisor = new int[number];

            for (int i = 1; i <= number; i++) {
                int count = 0;
                for (int j = 1; j * j <= i; j++) {
                    if (j * j == i) {
                        count++;
                    } else if (i % j == 0) {
                        count += 2;
                    }
                }
                divisor[i - 1] = count;
            }

            return divisor;
        }
    }
}

////playtime = 17:12
//
//class Solution136798 {
//    public int solution(int number, int limit, int power) {
//        int[] divisor = new int[number];
//        init(divisor, number);
//
//        for (int i = 0; i < number; i++) {
//            if (divisor[i] > limit) {
//                divisor[i] = power;
//            }
//        }
//
//        int answer = 0;
//        for (int i = 0; i < number; i++) {
//            answer += divisor[i];
//        }
//        return answer;
//    }
//
//    private void init(int[] divisor, int number) {
//        for (int i = 1; i <= number; i++) {
//            int count = 0;
//            for (int j = 1; j * j <= i; j++) {
//                if (j * j == i) {
//                    count++;
//                } else if (i % j == 0) {
//                    count += 2;
//                }
//            }
//            divisor[i - 1] = count;
//        }
//    }
//}
//
//public class P136798 {
//    public static void main(String[] args) {
//        Solution136798 sol = new Solution136798();
//        int ans = 0;
////        ans = sol.solution(5, 3, 2);
//        ans = sol.solution(10, 3, 2);
//        System.out.println(ans);
//    }
//}