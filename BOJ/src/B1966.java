import java.util.LinkedList;
import java.util.Scanner;

class Doc {
    int index;
    int importance;

    public Doc(int index, int importance) {
        this.index = index;
        this.importance = importance;
    }
}

public class B1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            LinkedList<Doc> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int im = sc.nextInt();
                list.add(new Doc(i, im));
            }
            int count = 0;
            while (!list.isEmpty()) {
                Doc temp = list.remove();
                boolean check = true;
                for (int i = 0; i < list.size(); i++) {
                    if (temp.importance < list.get(i).importance) {
                        list.add(temp);
                        check = false;
                        break;
                    }
                }
                if (check) {
                    count++;
                    if (m == temp.index) {
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
