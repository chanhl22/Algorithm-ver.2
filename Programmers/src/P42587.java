import java.util.*;

class Node {
    int index;
    int important;

    Node(int index, int important) {
        this.index = index;
        this.important = important;
    }
}

class Solution34 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Node> list = new LinkedList<>();
        int n = priorities.length;
        for(int i = 0; i < n; i++) {
            list.add(new Node(i, priorities[i]));
        }
        int cnt = 1;
        while(true) {
            boolean ok = true;
            Node temp = list.remove();
            for(int j = 0; j < list.size(); j++){
                if (temp.important < list.get(j).important) {
                    list.add(temp);
                    ok = false;
                    break;
                }
            }
            if (ok) {
                if (temp.index == location) {
                    answer = cnt;
                    break;
                }
                cnt++;
            }
        }
        return answer;
    }
}


public class P42587 {
    public static void main(String[] args) {
        Solution34 sol = new Solution34();
        int ans = 0;
        //ans = sol.solution(new int[]{2, 1, 3, 2}, 2);
        ans = sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(ans);
    }
}