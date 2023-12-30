package com.example.testTask.job_scraper;

import static com.example.testTask.MessageConstants.FIRST_DEFAULT_PATH_VARIABLE;
import static com.example.testTask.MessageConstants.MODEL_ATTRIBUTE_JOBS;
import static com.example.testTask.MessageConstants.MODEL_ATTRIBUTE_TOTAL_JOBS;
import com.example.testTask.job_scraper.model.InformationAboutJobRequest;
import com.example.testTask.job_scraper.model.Job;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {
    private final JobService jobService;
    private final InformationFromJobItemParser informationFromJobItemParser;
    private final JobFilter jobFilter;

    public JobController(InformationFromJobItemParser informationFromJobItemParser, JobService jobService, JobFilter jobFilter) {
        this.jobService = jobService;
        this.informationFromJobItemParser = informationFromJobItemParser;
        this.jobFilter = jobFilter;
    }

    @GetMapping("/job")
    public String getJobs(@RequestParam(defaultValue = FIRST_DEFAULT_PATH_VARIABLE) String[] selectedJobFunction,
                          @RequestParam(required = false) String location,
                          Model model) throws IOException, NotFoundException {

        InformationAboutJobRequest jobRequestList = informationFromJobItemParser.findJobs(selectedJobFunction);
        jobService.save(jobRequestList.getJobItemList());
        List<Job> filteredList = jobFilter.filterJobsByAddress(jobRequestList.getJobItemList(),location);
        model.addAttribute(
                MODEL_ATTRIBUTE_TOTAL_JOBS,
                jobRequestList.getTotalNumberOfJobs());

        model.addAttribute(
                MODEL_ATTRIBUTE_JOBS,
                filteredList);
        return "main";
    }
}
