//playtime = more than 2 hours

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9466 {
    static int[] a;
    static boolean[] finish;
    static boolean[] visit;
    static int count;

    static void dfs(int start) {
        if(visit[start]) return;
        visit[start] = true;
        int next = a[start];
        if (!visit[next]) {
            dfs(next);
        } else {
            if(finish[next] != true) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                count++;
                for(int i=next; i != start; i = a[i])
                    count++;
            }
        }
        // 모든 작업이 끝나서 더이상 사용하지 않음
        finish[start] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            a = new int[n + 1];
            String str = br.readLine();
            String[] s = str.split(" ");
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(s[i - 1]);
            }
            finish = new boolean[n + 1];
            visit = new boolean[n + 1];
            count = 0;
            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            System.out.println(n - count);
        }
    }
}

//reference : https://bcp0109.tistory.com/32