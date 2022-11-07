package com.example.pagination.model.example;

import com.example.pagination.model.PageView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceLibraryPageView implements PageView {
    @Id
    private Long insuranceId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String carModel;

    private String carMake;

    private String ownerName;

    private String ownerLastName;

}
