package com.example.pagination.model.filters;

import com.example.pagination.model.enums.TextFilterType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Jacksonized
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TextColumnFilter extends ColumnFilter {

    private final TextFilterType type;
    private final String value;

    @Override
    public <T> Specification<T> getSpecification(String columnName) {
        return type.getSpecification(columnName, value);
    }
}
