package question.mote2;

class Inner {
    private int number = 1;

    public int cal(int value) {
        if (value > 30) {
            return ++number;
        } else {
            return value + number++;
        }
    }
}

public class First {

    public static void main(String[] args) {
        Inner inner = new Inner();
        System.out.println(inner.cal(11)); //12, n = 2
        System.out.println(inner.cal(22)); //24, n = 3
        System.out.println(inner.cal(33)); //4

        System.out.println(inner.cal((inner.cal(inner.cal(11))))); //26
        //15, n = 4
        //20, n = 5
        //26, n = 6
    }

}

