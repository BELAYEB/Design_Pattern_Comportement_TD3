package com.tekup.ex1_Strategy;

import java.util.List;

public class Sorter<T> {

    private SortStrategy<T> strategy;

    public void setStrategy(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(List<T> list) {
        strategy.sort(list);
    }
}
