/**
 * N으로 표현
 * playtime = 1s 34m 50s
 * 풀이횟수 = 2
 * 처음 풀 때 걸린 시간 playtime = 2s 22m 13s
 */

import java.util.ArrayList;

public class P42895 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(5, 12);
//        ans = sol.solution(2, 11);
//        ans = sol.solution(6, 6);
//        ans = sol.solution(5, 26);
//        ans = sol.solution(8, 5800); //8
//        ans = sol.solution(5, 510);
//        ans = sol.solution(5, 55);
        ans = sol.solution(5, 555);
        System.out.println(ans);
    }

    static class Solution {

        static final int MAX = 8;

        public int solution(int N, int number) {

            // 점화식으로 나타내는 방법?
            //1. 5가 1개일 때 => 5
            //2. 5가 2개일 때 => 55, 5+5, 5*5, 5/5, 5-5
            //2. 5가 2개일 때 => 55, 10, 25, 1, 0
            //3. 5가 3개일 때 => ...

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= MAX; i++) {
                list.add(new ArrayList<>());
            }

            if(N == number) {
                return 1;
            }

            list.get(1).add(N);

            int result = -1;
            for (int i = 2; i <= MAX; i++) {
                ArrayList<Integer> updateList = list.get(i);
                for (int j = 1; j < i; j++) {
                    for (Integer before : list.get(j)) {
                        for (Integer after : list.get(i - j)) {
                            updateList.add(before + after);
                            updateList.add(before - after);
                            updateList.add(before * after);
                            if (after != 0) {
                                updateList.add(before / after);
                            }
                        }
                        String str = before + String.valueOf(N);
                        updateList.add(Integer.valueOf(str));
                    }
                }
                if (checkMatch(number, updateList)) {
                    result = i;
                    break;
                }
            }

            return result;
        }

        private boolean checkMatch(int number, ArrayList<Integer> updateList) {
            for (Integer integer : updateList) {
                if (integer == number) {
                    return true;
                }
            }
            return false;
        }
    }
}

//class Solution110 {
//    static final int MAX = 8;
//
//    public int solution(int N, int number) {
//        HashSet<Integer>[] list = new HashSet[MAX + 1];
//        for (int i = 0; i <= MAX; i++) {
//            list[i] = new HashSet<>();
//        }
//        list[1].add(N);
//        for (int i = 2; i <= MAX; i++) {
//            for (int j = 1; j < i; j++) {
//                for (int pre : list[j]) {
//                    for (int post : list[i - j]) {
//                        list[i].add(pre + post);
//                        list[i].add(pre - post);
//                        list[i].add(pre * post);
//                        if (post != 0) {
//                            list[i].add(pre / post);
//                        }
//                    }
//                }
//            }
//            String str = "";
//            for (int j = 0; j < i; j++) {
//                str += String.valueOf(N);
//            }
//            list[i].add(Integer.parseInt(str));
//        }
//        int index = 0;
//        for (HashSet<Integer> check : list) {
//            if (check.contains(number)) {
//                return index;
//            }
//            index++;
//        }
//        return -1;
//    }
//}