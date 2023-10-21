//playtime = 1:00:39

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class CheckIndex18870 {
    int index;
    int num;

    public CheckIndex18870(int index, int num) {
        this.index = index;
        this.num = num;
    }
}

public class B18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<CheckIndex18870> pq = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);
        for (int i = 0; i < n; i++) {
            pq.add(new CheckIndex18870(i, sc.nextInt()));
        }
        CheckIndex18870[] answer = new CheckIndex18870[n];
        int idx = 0; //answer의 index
        int temp = 0; //값이 같은 경우 ret을 증가시키지 않기 위한 임시 저장 변수
        int ret = 0; //정답을 출력하기 위해 바뀌는 데이터
        while (!pq.isEmpty()) {
            CheckIndex18870 remove = pq.remove();
            if (temp == remove.num) {
                ret--;
            }
            temp = remove.num;
            remove.num = ret++;
            answer[idx++] = remove;
        }
        Arrays.sort(answer, (o1, o2) -> o1.index - o2.index);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i].num).append(" ");
        }
        System.out.println(sb.toString());
    }
}
