package com.example.pagination.model;


import java.util.List;

public record PageResponse<T>(
        List<T> items,
        Integer pageCount,
        Long itemCount) {
}
