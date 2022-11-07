package com.example.pagination.model.enums;

import com.example.pagination.utils.PageViewSpecifications;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public enum TextFilterType {
    CONTAINS("contains", PageViewSpecifications::contains),
    NOT_CONTAINS("notContains", PageViewSpecifications::notContains),
    EQUALS("equals", PageViewSpecifications::isEqualTo),
    NOT_EQUAL("notEqual", PageViewSpecifications::isNotEqualTo);

    @Getter
    @JsonValue
    private final String value;

    private final BiFunction<String, String, Specification<?>> func;

    @SuppressWarnings("unchecked")
    public <T> Specification<T> getSpecification(String columnName, String searchCriteria) {
        return (Specification<T>) func.apply(columnName, searchCriteria);
    }
}
