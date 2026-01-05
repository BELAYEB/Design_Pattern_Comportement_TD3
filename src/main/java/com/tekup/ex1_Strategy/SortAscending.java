package com.tekup.ex1_Strategy;

import java.util.Collections;
import java.util.List;

public class SortAscending implements SortStrategy<Integer> {
    @Override
    public void sort(List<Integer> list) {
       Collections.sort(list);
    }
}
