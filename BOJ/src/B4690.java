public class B4690 {
    public static void main(String[] args) {
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                if (a < b) continue;
                for (int c = 2; c <= 100; c++) {
                    if (a < c) continue;
                    for (int d = 1; d <= 100; d++) {
                        if (a < d) continue;
                        if (b < c && b < d && c < d) {
                            if (a * a * a == b * b * b + c * c * c + d * d * d) {
                                System.out.println("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")");
                            }
                        }
                    }
                }
            }
        }
    }
}
