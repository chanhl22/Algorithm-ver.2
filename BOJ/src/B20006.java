/**
 * playtime = 48:46
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Room {
    private int count;
    private final ArrayList<Member> members = new ArrayList<>();

    public Room(Member member) {
        members.add(member);
        count++;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMember(Member member) {
        members.add(member);
        count++;
    }
}

class Member {
    private int level;
    private String name;

    public Member(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}

public class B20006 {
    private static int p;
    private static int m;
    private static final ArrayList<Room> rooms = new ArrayList<>();
    private static final ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        p = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < p; i++) {
            members.add(new Member(sc.nextInt(), sc.next()));
        }
    }

    private static void solution() {
        for (int i = 0; i < p; i++) {
            if (!findRoomAndEnterRoom(i)) {
                makeRoom(i);
            }
        }
        print();
    }

    private static void print() {
        for (Room room : rooms) {
            if (room.getCount() == m) {
                System.out.println("Started!");
                room.getMembers().sort(Comparator.comparing(Member::getName));
                for (Member member : room.getMembers()) {
                    System.out.println(member.getLevel() + " " + member.getName());
                }
            } else {
                System.out.println("Waiting!");
                room.getMembers().sort(Comparator.comparing(Member::getName));
                for (Member member : room.getMembers()) {
                    System.out.println(member.getLevel() + " " + member.getName());
                }
            }
        }
    }

    private static void makeRoom(int index) {
        rooms.add(new Room(members.get(index)));
    }

    private static boolean findRoomAndEnterRoom(int index) {
        for (Room room : rooms) {
            if (room.getCount() < m && checkLevel(members.get(index).getLevel(), room.getMembers().get(0).getLevel())) {
                room.setMember(members.get(index));
                return true;
            }
        }
        return false;
    }

    private static boolean checkLevel(int level, int firstRoomMemberLevel) {
        return firstRoomMemberLevel - 10 <= level
                && firstRoomMemberLevel + 10 >= level;
    }
}
