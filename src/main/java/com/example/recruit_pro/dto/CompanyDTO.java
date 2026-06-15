package com.example.recruit_pro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDTO {

    @NotBlank(message = "Company name is required")
    private String name;

    @NotBlank(message = "Tax code is required")
    @Size(min = 10, max = 13, message = "Tax code must be between 10 and 13 characters")
    private String taxCode;
}
