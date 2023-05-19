//playtime = 42:47

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Newcomer1946 {
    int x; //서류
    int y; //면접

    public Newcomer1946(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            Newcomer1946[] a = new Newcomer1946[n];
            for (int i = 0; i < n; i++) {
                String[] st = bf.readLine().split(" ");
                int t1 = Integer.parseInt(st[0]);
                int t2 = Integer.parseInt(st[1]);
                a[i] = new Newcomer1946(t1, t2);
            }
            Arrays.sort(a, (o1, o2) -> o1.x - o2.x);
            int ans = 1;
            int check = a[0].y; //y의 기준값
            //x로 내림차순 정렬을 했는데 y 값이 더 크다면 무조건 불가능함
            //x값도 크고 y값도 크기 때문, 그래서 y 기준을 마지막에 합격한 사람 순위로 바꿔줘야함
            /*
            1 4
            2 2
            3 3 (불가능)
            4 1
             */
            for (int i = 1; i < n; i++) {
                if (check > a[i].y) {
                    ans++;
                    check = a[i].y;
                }
            }
            System.out.println(ans);
        }
    }
}
