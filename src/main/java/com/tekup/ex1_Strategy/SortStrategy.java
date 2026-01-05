package com.tekup.ex1_Strategy;

import java.util.List;

/**
 * Interface Strategy définissant le contrat pour toutes les stratégies de tri
 */
public interface SortStrategy<T> {
    public void sort(List<T> list);
}
