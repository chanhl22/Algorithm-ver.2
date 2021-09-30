import java.util.Scanner;

public class B4256 {
    static int[] pre, in;

    static void post(int root, int s, int e) {
        int root_index = pre[root];
        for (int i = s; i < e; i++) {
            if (in[i] == root_index) {
                post(root + 1, s, i);
                post(root + i + 1 - s, i + 1, e);
                //s를 빼야하는 이유?
                //i는 s부터 시작하기 때문
                //i는 inorder의 왼쪽 자식 부분 만큼만 움직여야 하는데
                //시작값이 0이 아니기 때문에 시작값을 빼서 왼쪽 자식의 개수만큼 맞춰줘야한다.
                System.out.print(root_index + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            pre = new int[n + 1];
            in = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                in[i] = sc.nextInt();
            }
            post(0, 0, n);
            System.out.println();
        }
    }
}
