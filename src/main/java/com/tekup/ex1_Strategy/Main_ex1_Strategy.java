package com.tekup.ex1_Strategy;

public class Main_ex1_Strategy {

    public static void main(String[] args) {
        Sorter<Integer> intSorter = new Sorter<>();
        java.util.List<Integer> intList = java.util.Arrays.asList(5, 2, 8, 1, 4);

        intSorter.setStrategy(new SortAscending());
        intSorter.sort(intList);
        System.out.println("Sorted in Ascending Order: " + intList);

        intSorter.setStrategy(new SortDescending());
        intSorter.sort(intList);
        System.out.println("Sorted in Descending Order: " + intList);

        Sorter<String> stringSorter = new Sorter<>();
        java.util.List<String> stringList = java.util.Arrays.asList("apple", "banana", "kiwi", "cherry", "blueberry");

        stringSorter.setStrategy(new SortByLength());
        stringSorter.sort(stringList);
        System.out.println("Sorted by Length: " + stringList);

    }
}
