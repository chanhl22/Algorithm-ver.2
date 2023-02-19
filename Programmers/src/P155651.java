import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Room155651 {
    int roomNumber;
    boolean possible;

    public Room155651(int roomNumber, boolean possible) {
        this.roomNumber = roomNumber;
        this.possible = possible;
    }
}

class Solution155651 {
    public int solution(String[][] book_time) {
        int[][] bookTime = convertMin(book_time);
        ArrayList<Room155651> rooms = new ArrayList<>();
        rooms.add(new Room155651(1, false));
        for (int i = 0; i < bookTime.length; i++) {
            for (int j = 0; j < rooms.size(); j++) {
                if (!rooms.get(j).possible) {

                }
            }
        }


        return 0;
    }

    private int[][] convertMin(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            bookTime[i][0] = covertStringToInt(book_time[i][0]);
            bookTime[i][1] = covertStringToInt(book_time[i][1]);
        }
        Arrays.sort(bookTime, (o1, o2) -> o1[0] - o2[0]);
        return bookTime;
    }

    private int covertStringToInt(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}

public class P155651 {
    public static void main(String[] args) {
        Solution155651 sol = new Solution155651();
        int ans = sol.solution(new String[][]{
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}});
        System.out.println(ans);
    }
}