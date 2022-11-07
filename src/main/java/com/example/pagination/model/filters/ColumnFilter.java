package com.example.pagination.model.filters;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;

@RequiredArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "filterType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextColumnFilter.class, name = "text"),
        @JsonSubTypes.Type(value = SetColumnFilter.class, name = "set")
})
public abstract class ColumnFilter implements Serializable {

    protected final String filterType;

    public abstract <T> Specification<T> getSpecification(String columnName);

}
