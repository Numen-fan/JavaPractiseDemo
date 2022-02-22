
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {

    private static final Pattern PATTERN = Pattern.compile("([\\[].{1,5}?])");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "dkasjad\r\njf   sdhf\ns";
        System.out.println(str);
        System.out.println(str.trim().replaceAll("\\t|\\r\\n|\\n", ""));

        new Thread(Demo1::printValue).start();

        User user = new User();
        user.name = "三杀";
        func(user);
        System.out.println(user.name);

        List<User> list = new ArrayList<User>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());

        List<Long> list1 = new ArrayList<>();
        list1.add(878l);
        list1.add(234l);
        System.out.println(list1.toString());

        testMatch();

    }

    private static void testMatch() {
        String str = "[大笑]你好[大哭]我不好[大哭]你好";
        Matcher matcher = PATTERN.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }


    private static void  func(User user) {
        User u = user;
        System.out.println(u.name);
        u = null;
    }


    public static void printValue() {
        System.out.print("hello word!");
    }

    static class User {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}


