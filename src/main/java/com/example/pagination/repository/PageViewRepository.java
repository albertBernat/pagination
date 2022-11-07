package com.example.pagination.repository;

import com.example.pagination.model.PageView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PageViewRepository<T extends PageView> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
