import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Card {
    char color;
    int number;

    public Card(char color, int number) {
        this.color = color;
        this.number = number;
    }
}

public class B2621 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Card[] cards = new Card[5];
        for (int i = 0; i < 5; i++) {
            String s = sc.next();
            int n = sc.nextInt();
            cards[i] = new Card(s.charAt(0), n);
        }
        Arrays.sort(cards, (x, y) -> x.number - y.number);
        int max = cards[4].number;
        char[] color = new char[4];
        int[] number = new int[10];
        for (int i = 0; i < 5; i++) {
            if (cards[i].color == 'R') {
                color[0]++;
            } else if (cards[i].color == 'B') {
                color[1]++;
            }else if (cards[i].color == 'Y') {
                color[2]++;
            }else if (cards[i].color == 'G') {
                color[3]++;
            }
            number[cards[i].number]++;
        }
        //각각의 색깔 개수
        //ex1) five_c == 1 이면 5개의 동일한 색깔이 같음
        //ex2) one_c == 2 이면 다른 색깔이 2개 있음
        int one_c, two_c, three_c, four_c, five_c;
        one_c = two_c = three_c = four_c = five_c = 0;
        for (int i = 0; i < 4; i++) {
            if (color[i] == 1) one_c++;
            else if (color[i] == 2) two_c++;
            else if (color[i] == 3) three_c++;
            else if (color[i] == 4) four_c++;
            else if (color[i] == 5) five_c++;
        }
        //연속된 숫자 체크
        int con = 0;
        for (int i = 0; i <= 5; i++) {
            if (number[i] == 1 && number[i+1] == 1 && number[i+2] == 1
                    && number[i+3] == 1 && number[i+4] == 1) con = 1;
        }
        //각각의 숫자 개수
        //ex1) five_n == 1 이면 5개의 동일한 숫자
        //ex2) one_n == 5 이면 다른 숫자가 5개 있음
        int one_n, two_n, three_n, four_n, five_n;
        one_n = two_n = three_n = four_n = five_n = 0;
        int[] record_two = new int[2];
        int record_three = 0;
        int record_four = 0;
        for (int i = 1; i <= 9; i++) {
            if (number[i] == 1) one_n++;
            else if (number[i] == 2) {
                two_n++;
                if (record_two[0] != 0) {
                    record_two[1] = i;
                } else {
                    record_two[0] = i;
                }
            }
            else if (number[i] == 3) {
                three_n++;
                record_three = i;
            }
            else if (number[i] == 4) {
                four_n++;
                record_four = i;
            }
            else if (number[i] == 5) five_n++;
        }
        int ans = 0;
        if(five_c == 1 && con == 1) ans = max + 900;
        else if(four_n == 1) ans = record_four + 800;
        else if(three_n == 1 && two_n == 1) ans = record_three * 10 + record_two[0] + 700;
        else if(five_c == 1) ans = max + 600;
        else if(con == 1) ans = max + 500;
        else if(three_n == 1) ans = record_three + 400;
        else if(two_n == 2) ans = Math.max(record_two[0], record_two[1]) * 10 + Math.min(record_two[0], record_two[1]) + 300;
        else if(two_n == 1) ans = record_two[0] + 200;
        else ans = max + 100;
        System.out.println(ans);
    }
}
