package com.example.pagination.controller;

import com.example.pagination.model.PageResponse;
import com.example.pagination.model.MyPageRequest;
import com.example.pagination.model.example.InsuranceLibraryPageView;
import com.example.pagination.service.PageViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/library/insurance", produces = MediaType.APPLICATION_JSON_VALUE)
public class InsuranceLibraryController {
    private final PageViewService<InsuranceLibraryPageView> insuranceLibraryPageViewPageViewService;

    @PostMapping("loadPage")
    public PageResponse<InsuranceLibraryPageView> getLibraryPage(@RequestBody MyPageRequest myPageRequest) {
        return insuranceLibraryPageViewPageViewService.getLibraryPage(myPageRequest);
    }
}
