package com.example.recruit_pro.controller;

import com.example.recruit_pro.dto.JobCreateDTO;
import com.example.recruit_pro.entity.Job;
import com.example.recruit_pro.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@Valid @RequestBody JobCreateDTO dto) {
        Job savedJob = jobService.createJob(dto);
        return ResponseEntity.ok(savedJob);
    }
}
