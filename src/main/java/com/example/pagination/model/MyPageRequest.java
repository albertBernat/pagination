package com.example.pagination.model;

import com.example.pagination.model.filters.ColumnFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Getter
@Builder
@EqualsAndHashCode
public class MyPageRequest implements Serializable {

    private final Integer page;
    private final Integer limit;
    private final Map<String, ColumnFilter> filterModel;
    private final List<SortModel> sortModel;

    @JsonIgnore
    @SuppressWarnings("unchecked")
    public <T> Specification<T> getSpecification() {
        return filterModel.entrySet().stream()
                .map(e -> (Specification<T>) e.getValue().getSpecification(e.getKey()))
                .reduce(Specification::and)
                .orElse(null);
    }

    public PageRequest asPageRequest() {
        Sort sort = sortModel.stream()
                .map(sm -> Sort.by(sm.getDirection(), sm.getColId()))
                .reduce(Sort::and)
                .orElse(Sort.unsorted());
        return PageRequest.of(page, limit, sort);
    }

}
