package com.org.core.java.demo.stream.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAllFunctionalInterfaces {
    public static void main(String[] args) {
        TestAllFunctionalInterfaces testAllFunctionalInterfaces  = new TestAllFunctionalInterfaces();
        System.out.println("***************Consumer***************");
        /**
         * Consumer having these methods
         * void accept(T t);
         * default Consumer<T> andThen(Consumer<? super T> after);
         */
        testAllFunctionalInterfaces.whenNamesPresentConsumeAll();
        testAllFunctionalInterfaces.whenNamesPresentUseBothConsumer();
        System.out.println("######################################");
        System.out.println("\n***************Supplier***************");
        /**
         * Supplier having these methods
         * IntSupplier int getAsInt();
         * DoubleSupplier double getAsDouble();
         * LongSupplier long getAsLong();
         * BooleanSupplier boolean getAsBoolean();
         */
        testAllFunctionalInterfaces.supplier();
        testAllFunctionalInterfaces.supplierWithOptional();
        System.out.println("######################################");
        System.out.println("\n***************Predicate***************");
        /**
         * Predicate having these methods
         * default Predicate<T> and(Predicate<? super T> other);
         * default Predicate<T> or(Predicate<? super T> other);
         * static <T> Predicate<T> isEquals(Object targetRef);
         * default Predicate<T> negate();
         */
        testAllFunctionalInterfaces.testPredicate();
        testAllFunctionalInterfaces.testPredicateAndComposition();
        System.out.println("######################################");
        System.out.println("\n***************Function***************");
        /**
         * Function having these methods
         * R apply(T t);
         * default <V> Function<V, R> compose(Function<? super V, ? extends T> before);
         * default <V> Function<T, V> andThen(Function<? super R, ? extends V> after);
         * static <T> Function<T, T> identity();
         */
        testAllFunctionalInterfaces.testFunctions();
        System.out.println("######################################");
    }


    public void whenNamesPresentConsumeAll(){
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);
    }

    public void whenNamesPresentUseBothConsumer(){
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }

    public void supplier(){
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }

    public void supplierWithOptional(){
        Supplier<Double> doubleSupplier = () -> Math.random();
        Optional<Double> optionalDouble = Optional.empty();
        System.out.println(optionalDouble.orElseGet(doubleSupplier));
    }

    public void testPredicate(){
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartsWithS).forEach(System.out::println);
    }

    public void testPredicateAndComposition(){
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> startPredicate = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;
        names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
    }

    public void testFunctions(){
        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");
        Function<String, Integer> nameMappingFunction = String::length;
        List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
        System.out.println(nameLength);
    }
}
