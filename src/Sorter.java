// Ivan Espinoza
// Project 2

import java.util.ArrayList;
import java.util.List;

public class Sorter {
    public static void mergeSort(List<CostPerPerson> list) {
        if (list.size() <= 1)
            return;

        int middle = list.size() / 2;

        List<CostPerPerson> left = new ArrayList<>();
        for (int i = 0; i < middle; i++)
            left.add(list.get(i));

        List<CostPerPerson> right = new ArrayList<>();
        for (int i = middle; i < list.size(); i++)
            right.add(list.get(i));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private static void merge(List<CostPerPerson> result, List<CostPerPerson> left,
                              List<CostPerPerson> right) {
        result.clear();
        int indexL = 0, indexR = 0;

        while (indexL < left.size() && indexR < right.size())
            result.add(left.get(indexL).compareTo(right.get(indexR)) > 0 ?
                    left.get(indexL++) : right.get(indexR++));

        while (indexL < left.size())
            result.add(left.get(indexL++));

        while (indexR < right.size())
            result.add(right.get(indexR++));
    }
}
