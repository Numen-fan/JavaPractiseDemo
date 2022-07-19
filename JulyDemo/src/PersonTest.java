import java.util.HashMap;
import java.util.Objects;

public class PersonTest {

    public static void main(String[] args) {

        Person person1 = new Person("张三", 123);
        Person person2 = new Person("张三", 123);

        System.out.println("equals:" + person1.equals(person2));
        System.out.println("hashCode:" + (person1.hashCode() == person2.hashCode()));

        HashMap<Person, Integer> map =  new HashMap<>();
        map.put(person1, 1);
        map.put(person2, 2);

        System.out.println(map.size());

    }

    static class Person {
        String name;
        int identify;

        public Person(String name, int identify) {
            this.name = name;
            this.identify = identify;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            // 不建议用 o instanceof Person, 如果o是Person的的派生类就会有问题。
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return identify == person.identify && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, identify);
        }
    }
}
