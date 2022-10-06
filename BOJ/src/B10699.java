import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class B10699 {
    public static void main(String[] args) {
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(today);
    }
}
