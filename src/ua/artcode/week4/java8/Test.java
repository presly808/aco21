package ua.artcode.week4.java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 24.09.17.
 */
public class Test {

    public static void main(String[] args) {
        Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5, 6, 7);

        Consumer<Integer> a1 = Test::print;
        // in -> System.out.println(in)


        List<Integer> stream = nums.collect(Collectors.toList());



    }

    static class MyConsumer implements Consumer<Integer> {

        @Override
        public void accept(Integer integer) {
            System.out.println(integer);
        }
    }

    public static void print(Integer in){
        System.out.println(in);
    }

    public static void print(Double in){
        System.out.println(in);
    }
}
