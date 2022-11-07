package com.example.pagination.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Builder
@Jacksonized
@EqualsAndHashCode
public class SortModel implements Serializable {
    private final String colId;

    private final String direction;

    public String getColId() {
        return colId;
    }

    public Sort.Direction getDirection() {
        if ("desc".equalsIgnoreCase(direction)) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }
}
