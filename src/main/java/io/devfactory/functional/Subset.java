package io.devfactory.functional;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {

    private Subset() {}

    // 입력: [1, 4, 9]
    // 출력: [1, 4, 9], [1, 4], [1, 9], [4, 9], [1], [4], [9], []
    public static List<List<Integer>> subsets(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Collections.emptyList());
            return result;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subResult = subsets(rest);
        List<List<Integer>> subResult2 = insertAll(first, subResult);

        return concat(subResult, subResult2);
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subResult) {
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> integers : subResult) {
            List<Integer> newList = new ArrayList<>();
            newList.add(first);
            newList.addAll(integers);
            result.add(newList);
        }

        return result;
    }

    private static List<List<Integer>> concat(List<List<Integer>> subResult, List<List<Integer>> subResult2) {
        // 상황에 따라 다르나
        // 첫 번째 인수를 임의의 값으로 바꾸게 됨
        // subResult.addAll(subResult2);

        // 그러므로 아래코드가 더 바람직함
        List<List<Integer>> newList = new ArrayList<>(subResult);
        newList.addAll(subResult2);

        return newList;
    }

}
