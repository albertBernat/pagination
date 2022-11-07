package com.example.pagination.service;

import com.example.pagination.model.PageResponse;
import com.example.pagination.model.PageView;
import com.example.pagination.model.MyPageRequest;
import com.example.pagination.repository.PageViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class PageViewService<T extends PageView> {

    private final PageViewRepository<T> repository;

    public PageResponse<T> getLibraryPage(MyPageRequest myPageRequest) {
        Specification<T> specification = myPageRequest.getSpecification();
        Page<T> result = repository.findAll(specification, myPageRequest.asPageRequest());
        return new PageResponse<>(result.getContent(), result.getTotalPages(), result.getTotalElements());
    }
}
