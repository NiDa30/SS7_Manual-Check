package com.example.recruit_pro.service;

import com.example.recruit_pro.dto.JobCreateDTO;
import com.example.recruit_pro.entity.Company;
import com.example.recruit_pro.entity.Job;
import com.example.recruit_pro.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    @Transactional
    public Job createJob(JobCreateDTO dto) {
        if (dto.getSalaryMin() != null && dto.getSalaryMax() != null && dto.getSalaryMin() > dto.getSalaryMax()) {
            throw new IllegalArgumentException("Lương tối thiểu không được lớn hơn lương tối đa");
        }

        Company company = Company.builder()
                .name(dto.getCompany().getName())
                .taxCode(dto.getCompany().getTaxCode())
                .build();

        Job job = Job.builder()
                .title(dto.getTitle())
                .salaryMin(dto.getSalaryMin())
                .salaryMax(dto.getSalaryMax())
                .company(company)
                .build();

        return jobRepository.save(job);
    }
}
