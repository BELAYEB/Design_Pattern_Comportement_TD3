package com.tekup.ex1_Strategy;

import java.util.Comparator;

public class SortByLength implements SortStrategy<String> {
    @Override
    public void sort(java.util.List<String> list) {
        list.sort(Comparator.comparing(String::length));
    }
}
