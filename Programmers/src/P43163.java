/**
 * 단어 변환
 * playtime = 1s 05m 59s
 * 괜히 class 따로 안만드려다가 오히려 복잡해졌네... 그냥 클래스 만드는 게 낫겠
 */

import java.util.LinkedList;
import java.util.Queue;

public class P43163 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
//        ans = sol.solution("hit", "hot", new String[]{"hit", "hot", "lot"}); //1
        ans = sol.solution("abc", "abd", new String[]{"aab", "aba"}); //2
        //ans = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println(ans);
    }

    static class Solution {

        private static int n;

        public int solution(String begin, String target, String[] words) {
            n = words.length;
            return bfs(begin, target, words);
        }

        private int bfs(String begin, String target, String[] words) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(begin);

            int[] visited = new int[n];

            while (!queue.isEmpty()) {
                String cur = queue.remove();

                for (int i = 0; i < n; i++) {
                    String next = words[i];
                    if (next.equals(begin)) {
                        continue;
                    }
                    if (check(cur, next) && visited[i] == 0) {
                        queue.offer(next);
                        int index = findIndex(words, cur);
                        if (index == -1) {
                            visited[i] = 1;
                        } else {
                            visited[i] = 1 + visited[index];
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                if (words[i].equals(target)) {
                    result = visited[i];
                }
            }
            return result;
        }

        private int findIndex(String[] words, String cur) {
            for (int i = 0; i < n; i++) {
                if (words[i].equals(cur)) {
                    return i;
                }
            }
            return -1;
        }

        private boolean check(String cur, String next) {
            int len = cur.length();
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (cur.charAt(i) == next.charAt(i)) {
                    count++;
                }
            }
            return count >= len - 1;
        }
    }
}

//import java.util.LinkedList;
//import java.util.Queue;
//
//class Group {
//    String word;
//    int index;
//
//    public Group(String word, int index) {
//        this.word = word;
//        this.index = index;
//    }
//}
//
//class Solution8 {
//    public int solution(String begin, String target, String[] words) {
//        int answer = 0;
//        boolean ok = false;
//        for (int i = 0; i < words.length; i++) {
//            if (target.equals(words[i])){
//                ok = true;
//            }
//        }
//        if (!ok) {
//            answer = 0;
//            return answer;
//        }
//        boolean[] check = new boolean[words.length];
//        int[] dist = new int[words.length];
//        Queue<Group> q = new LinkedList<>();
//        q.add(new Group(begin, 0));
//        while (!q.isEmpty()) {
//            Group g = q.remove();
//            String s = g.word;
//            int num = g.index;
//            if (s.equals(target)){
//                answer = num;
//                break;
//            }
//            int[] d = new int[words.length];
//            for (int i = 0; i < words.length; i++) {
//                for (int j = 0; j < words[i].length(); j++) {
//                    if (s.charAt(j) != words[i].charAt(j)){
//                        d[i] += 1;
//                    }
//                }
//            }
//            for (int i = 0; i < d.length; i++) {
//                if (d[i] == 1 && check[i] == false) {
//                    q.add(new Group(words[i], num + 1));
//                    check[i] = true;
//                }
//            }
//        }
//        return answer;
//    }
//}
//
//
//public class K43163 {
//    public static void main(String[] args) {
//        Solution8 sol = new Solution8();
//        int ans = 0;
//        ans = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
//        //ans = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
//        System.out.println(ans);
//    }
//}