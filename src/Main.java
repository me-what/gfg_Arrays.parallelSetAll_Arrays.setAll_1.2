import java.util.Arrays;

public class Main {
    static class Person {
        String name;
        int age;

        public Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Person p[] = { new Person("samir", 20),
                new Person("anil", 25), new Person("amit", 10),
                new Person("rohit", 17), new Person("Geek5", 19),
                new Person("sumit", 22), new Person("gourav", 24),
                new Person("sunny", 27), new Person("ritu", 28) };

        Arrays.parallelSetAll(p, e->{
            if (p[e].name.startsWith("s"))
                return new Person("You are a geek", 100);
            else
                return new Person(p[e].name, p[e].age);
        });
        System.out.println("Example 1; Modifying the name that starts with s");
        Arrays.stream(p).forEach(e->System.out.println(e.name + "   " + e.age));


        // 2
        Person p1[] = { new Person("samir", 16),
                new Person("anil", 25), new Person("amit", 10),
                new Person("rohit", 17), new Person("Geek5", 19),
                new Person("sumit", 16), new Person("gourav", 24),
                new Person("sunny", 11), new Person("ritu", 28) };

        Arrays.setAll(p1, e->{
            if (p1[e].age < 18)
                return new Person("Teenager", p1[e].age);
            else
                return new Person(p1[e].name, p1[e].age);
        });

        System.out.println("\n\nExample 2: Modifying name whose"
                + "age is less than 18");
        Arrays.stream(p1).forEach(e->System.out.println(e.name + "   " + e.age));
    }
}