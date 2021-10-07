class Solution39 {
    static String[] str_day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    static int[] month_day = { 31,29,31,30,31,30,31,31,30,31,30,31 };

    public String solution(int month, int day) {
        String answer = "";
        int total_day = 0;
        // 달
        for(int i=1; i<month; i++)
        {
            total_day += month_day[i-1];
        }
        // 일
        total_day += day-1;

        // 2016.1.1 = 금
        int answer_day = (5 + total_day) % 7;
        answer = str_day[answer_day];

        return answer;
    }
}

public class P320108_2 {
    public static void main(String[] args) {
        Solution39 sol = new Solution39();
        String ans = sol.solution(5, 24);
        System.out.println(ans);
    }
}

//윤년 추가
//윤년 여부
//      void IsLeapYear(int year)
//      {
//          if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
//              month_day[1] = 29;
//      }
//
//    // 날짜이름
//    string getDayName(int year, int month, int day)
//    {
//        int total_day = 0;
//
//        // 년
//        IsLeapYear(year);
//
//        // 달
//        for(int i=1; i<month; i++)
//        {
//            total_day += month_day[i-1];
//        }
//        // 일
//        total_day += day-1;
//
//        // 2016.1.1 = 금
//        int answer_day = (5 + total_day) % 7;
//
//        return str_day[answer_day];
//    }
