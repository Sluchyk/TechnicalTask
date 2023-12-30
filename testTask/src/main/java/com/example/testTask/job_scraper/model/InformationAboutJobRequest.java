package com.example.testTask.job_scraper.model;

import java.util.List;

public class InformationAboutJobRequest {
    private List<Job> jobItemList;
    private String totalNumberOfJobs;

    public InformationAboutJobRequest(List<Job> jobItemList, String totalNumberOfJobs) {
        this.jobItemList = jobItemList;
        this.totalNumberOfJobs = totalNumberOfJobs;
    }

    public List<Job> getJobItemList() {
        return jobItemList;
    }

    public void setJobItemList(List<Job> jobItemList) {
        this.jobItemList = jobItemList;
    }

    public String getTotalNumberOfJobs() {
        return totalNumberOfJobs;
    }

    public void setTotalNumberOfJobs(String totalNumberOfJobs) {
        this.totalNumberOfJobs = totalNumberOfJobs;
    }
}
