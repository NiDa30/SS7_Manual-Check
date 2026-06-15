package com.example.recruit_pro.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobCreateDTO {

    @NotBlank(message = "Job title is required")
    private String title;

    @Min(value = 0, message = "Salary min must be at least 0")
    private Double salaryMin;

    @Min(value = 0, message = "Salary max must be at least 0")
    private Double salaryMax;

    @Valid
    @NotNull(message = "Company information is required")
    private CompanyDTO company;
}
