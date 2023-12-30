package com.example.testTask.job_scraper;

import com.example.testTask.job_scraper.model.Job;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class JobFilter {
    public List<Job> filterJobsByAddress(List<Job> jobs, String addressFilter) {
        if(addressFilter == null) {
            return jobs;
        }
        return jobs.stream()
                .filter(job -> job.getAddress().contains(addressFilter))
                .collect(Collectors.toList());
    }
}
