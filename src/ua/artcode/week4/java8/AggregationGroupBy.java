package ua.artcode.week4.java8;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 24.09.17.
 */
public class AggregationGroupBy {

    public static void main(String[] args) {
        List<User> str = Stream.generate(() ->
                new User(
                        generate(18, 40),
                        generate(1000, 4000),
                        genName(generate(0, 4)),
                        UserType.values()[generate(0, 4)])).limit(10).collect(Collectors.toList());
        /*str.forEach(System.out::println);*/

        double res = str.stream().mapToDouble(u -> u.salary).reduce(0, (acc, curr) -> acc + curr);

        User u1 = str.stream().reduce(null, (max, curr) -> {
            if (max == null) {
                return curr;
            }

            return max.salary < curr.salary ? curr : max;
        });

        Map<UserType, DoubleSummaryStatistics> map = str.stream().collect(
                Collectors.groupingBy((el) -> el.deparment, Collectors.summarizingDouble(el -> el.salary)));

        Map<UserType, List<User>> depUsers = str.stream().collect(Collectors.groupingBy((el) -> el.deparment));

        map.forEach((k, v) -> System.out.println(k + " " + v.getSum()));

        System.out.println(u1.salary);

        System.out.println(res);
        double sumSalaries = sumSalaries(str);
        System.out.println(sumSalaries);

    }

    private static double sumSalaries(List<User> str) {
        return str.stream().mapToDouble((usr) -> usr.salary).sum();
    }


    private static String genName(int num) {
        return new String[]{"Andrey", "Kostiy", "Ivan", "Oleg"}[num];
    }

    private static int generate(int left, int right) {
        return left + (int) (Math.random() * (right - left));
    }

    static class User {
        int id;
        int age;
        double salary;
        String name;
        UserType deparment;


        public User(int age, double salary, String name, UserType deparment) {
            this.age = age;
            this.salary = salary;
            this.name = name;
            this.deparment = deparment;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public UserType getDeparment() {
            return deparment;
        }

        public void setDeparment(UserType deparment) {
            this.deparment = deparment;
        }

        public User() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (id != user.id) return false;
            if (age != user.age) return false;
            if (Double.compare(user.salary, salary) != 0) return false;
            if (name != null ? !name.equals(user.name) : user.name != null) return false;
            return deparment == user.deparment;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = id;
            result = 31 * result + age;
            temp = Double.doubleToLongBits(salary);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (deparment != null ? deparment.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", salary=" + salary +
                    ", name='" + name + '\'' +
                    ", deparment=" + deparment +
                    '}';
        }
    }

    static enum UserType {
        TESTER, DEV, MANAGER, SUPPORT;
    }

}


