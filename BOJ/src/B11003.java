//playtime = 01:12:14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node3 {
    int value;
    int index;

    public Node3(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class B11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Node3> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.getLast().value > temp) {
                dq.removeLast();
            }
            dq.addLast(new Node3(temp, i));
            if (dq.getFirst().index <= i - l) {
                dq.removeFirst();
            }
            sb.append(dq.getFirst().value + " ");
        }
        System.out.println(sb.toString());
    }
}
