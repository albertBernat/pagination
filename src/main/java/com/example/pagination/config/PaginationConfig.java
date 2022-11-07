package com.example.pagination.config;


import com.example.pagination.model.example.InsuranceLibraryPageView;
import com.example.pagination.repository.InsuranceLibraryRepository;
import com.example.pagination.service.PageViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PaginationConfig {

    private final InsuranceLibraryRepository insuranceLibraryRepository;

    @Bean
    public PageViewService<InsuranceLibraryPageView> insuranceLibraryPageViewPageViewService() {
         return new PageViewService<>(insuranceLibraryRepository);
    }
}
