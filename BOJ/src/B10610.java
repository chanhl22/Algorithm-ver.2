import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        //1. 마지막 자리는 무조건 0
        //2. 마지막 자리를 제외한 수를 합했을때 무조건 3의 배수
        int sum = 0;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
            a.add(num.charAt(i)- '0');
        }
        Collections.sort(a);
        Collections.reverse(a);
        if (sum % 3 == 0 && a.get(a.size()-1) == 0) {
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i));
            }
        }else {
            System.out.println(-1);
        }
        /*
        Collections.sort(list);
        if(list.get(0)==0 && sum %3 == 0) {
            for(int i=list.size()-1; i>=0; i--)
                System.out.print(list.get(i));
        }
        else
            System.out.println(-1);
         */
    }
}
