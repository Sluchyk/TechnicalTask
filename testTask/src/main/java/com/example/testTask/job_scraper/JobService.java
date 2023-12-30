package com.example.testTask.job_scraper;

import com.example.testTask.job_scraper.model.Job;
import com.example.testTask.job_scraper.model.JobEntity;
import com.example.testTask.job_scraper.model.JobRepository;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class JobService {
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    public JobService(JobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }
    public void save(List<Job> list){
        List<JobEntity> jobEntitiesList = mapToJobEntity(list);
        jobRepository.saveAll(jobEntitiesList);
    }
    private List<JobEntity> mapToJobEntity(List<Job> list){
            return modelMapper.mapJobToJobEntity(list);
    }
}
