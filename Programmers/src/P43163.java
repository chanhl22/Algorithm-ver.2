import java.util.LinkedList;
import java.util.Queue;

class Group {
    String word;
    int index;

    public Group(String word, int index) {
        this.word = word;
        this.index = index;
    }
}

class Solution8 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean ok = false;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])){
                ok = true;
            }
        }
        if (!ok) {
            answer = 0;
            return answer;
        }
        boolean[] check = new boolean[words.length];
        int[] dist = new int[words.length];
        Queue<Group> q = new LinkedList<>();
        q.add(new Group(begin, 0));
        while (!q.isEmpty()) {
            Group g = q.remove();
            String s = g.word;
            int num = g.index;
            if (s.equals(target)){
                answer = num;
                break;
            }
            int[] d = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    if (s.charAt(j) != words[i].charAt(j)){
                        d[i] += 1;
                    }
                }
            }
            for (int i = 0; i < d.length; i++) {
                if (d[i] == 1 && check[i] == false) {
                    q.add(new Group(words[i], num + 1));
                    check[i] = true;
                }
            }
        }
        return answer;
    }
}


public class K43163 {
    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        int ans = 0;
        ans = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        //ans = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println(ans);
    }
}