package com.example.pagination.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static java.text.MessageFormat.format;

@UtilityClass
public class PageViewSpecifications {

    public static <T>Specification<T> in(String columnName, List<String> values) {
        return (root, query, builder) -> builder.in(root.get(columnName).in(values));
    }

    public static <T>Specification<T> contains(String columnName, String value) {
        return  (root, query, builder) -> builder.like(root.get(columnName), format("%{0}%", value));
    }

    public static <T>Specification<T> notContains(String columnName, String value) {
        return  (root, query, builder) -> builder.notLike(root.get(columnName), format("%{0}%", value));
    }

    public static <T>Specification<T> isEqualTo(String columnName, String value) {
        return  (root, query, builder) -> builder.equal(root.get(columnName), format("{0}", value));
    }

    public static <T>Specification<T> isNotEqualTo(String columnName, String value) {
        return  (root, query, builder) -> builder.notEqual(root.get(columnName), format("{0}", value));
    }
}
