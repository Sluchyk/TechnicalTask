package com.example.testTask.job_scraper.model;

public class JobItem {
    private String tags;
    private String urlApplication;
    private String jobTitle;

    public JobItem(String tags,
                   String urlApplication,
                   String jobTitle) {
        this.tags = tags;
        this.urlApplication = urlApplication;
        this.jobTitle = jobTitle;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrlApplication() {
        return urlApplication;
    }

    public void setUrlApplication(String urlApplication) {
        this.urlApplication = urlApplication;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "JobItem{" +
                "tags='" + tags + '\'' +
                ", urlApplication='" + urlApplication + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}' +'\n';
    }
}
