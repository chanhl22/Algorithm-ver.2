/**
 * playtime = 01h 12m 48s
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class People {
    int index;
    HashSet<Integer> songs = new HashSet<>();

    public People(int index) {
        this.index = index;
    }

    public void updateSongs(ArrayList<Integer> indexes, ArrayList<Integer> knowSongs) {
        if (indexes.contains(this.index)) {
            songs.addAll(knowSongs);
        }
    }

    public ArrayList<Integer> getSongs() {
        return new ArrayList<>(songs);
    }
}

public class B3018 {

    private final static Scanner sc = new Scanner(System.in);
    private static int n;
    private static int e;
    private final static List<People> peopleList = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        e = sc.nextInt();

        init();
        for (int i = 0; i < e; i++) {
            ArrayList<Integer> presentPeople = presentPeople();
            ArrayList<Integer> songs = findSongs(presentPeople, i);
            updatePeopleList(presentPeople, songs);
        }

        result();
    }

    private static ArrayList<Integer> findSongs(ArrayList<Integer> presentPeople, int song) {
        HashSet<Integer> songs = new HashSet<>();

        if (presentPeople.contains(1)) {
            songs.add(song);
        }
        if (!presentPeople.contains(1)) {
            findKnowSong(presentPeople, songs);
        }

        return new ArrayList<>(songs);
    }

    private static void findKnowSong(ArrayList<Integer> presentPeople, HashSet<Integer> songs) {
        for (People people : peopleList) {
            for (int peopleNumber : presentPeople) {
                if (people.index == peopleNumber) {
                    songs.addAll(people.getSongs());
                }
            }
        }
    }

    private static void result() {
        People sunyoung = peopleList.get(0);
        for (People people : peopleList) {
            if (people.songs.size() == sunyoung.songs.size()) {
                System.out.println(people.index);
            }
        }
    }

    private static void updatePeopleList(ArrayList<Integer> presentPeople, ArrayList<Integer> songs) {
        for (People people : peopleList) {
            people.updateSongs(presentPeople, songs);
        }
    }

    private static ArrayList<Integer> presentPeople() {
        int peopleCount = sc.nextInt();
        ArrayList<Integer> presentPeople = new ArrayList<>();
        for (int j = 0; j < peopleCount; j++) {
            presentPeople.add(sc.nextInt());
        }
        return presentPeople;
    }

    private static void init() {
        for (int i = 1; i <= n; i++) {
            peopleList.add(new People(i));
        }
    }
}