package com.tekup.ex1_Strategy;

import java.util.Collections;
import java.util.List;

public class SortDescending implements  SortStrategy<Integer> {
    @Override
    public void sort(List<Integer> list) {
        list.sort(Collections.reverseOrder());
    }
}
