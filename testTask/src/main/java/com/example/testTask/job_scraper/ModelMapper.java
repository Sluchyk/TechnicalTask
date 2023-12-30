package com.example.testTask.job_scraper;

import com.example.testTask.job_scraper.model.Job;
import com.example.testTask.job_scraper.model.JobEntity;
import com.example.testTask.utils.TimeUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {
    public List<JobEntity> mapJobToJobEntity(List<Job> jobs){
        List<JobEntity> mappedList = new ArrayList<>();
        for(Job job:jobs) {
            mappedList.add(new JobEntity(
                    job.getJobPageUrl(),
                    job.getPositionName(),
                    job.getUrlToOrganization(),
                    job.getLogoUrl(),
                    job.getOrganizationTitle(),
                    job.getLaborFunction(),
                    job.getAddress(),
                    TimeUtils.convertStringDateToTimeStamp(job.getPostedDate()),
                    job.getDescription(),
                    job.getTagName())
            );
        }
        return mappedList;
    }
}
