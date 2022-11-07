package com.example.pagination.model.filters;

import com.example.pagination.utils.PageViewSpecifications;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Getter
@Jacksonized
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SetColumnFilter extends ColumnFilter {

    protected final List<String> values;

    @Override
    public <T> Specification<T> getSpecification(String columnName) {
        return PageViewSpecifications.in(columnName, values);
    }
}
