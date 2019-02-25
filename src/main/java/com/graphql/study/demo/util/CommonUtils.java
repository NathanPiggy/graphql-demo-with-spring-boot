package com.graphql.study.demo.util;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CommonUtils {

    private CommonUtils() {

    }

    public static final <E> Optional<E> findInList(List<E> list, Predicate<? super E> predicate) {
        if (null != list && list.size() > 0) {
            Optional<E> optional = list.stream().filter(predicate).findFirst();
            return optional;
        }
        return Optional.empty();
    }
}
