package com.example.testTask.job_scraper.model;
public class Job {
    private String jobPageUrl;
    private String positionName;
    private String urlToOrganization;
    private String logoUrl;
    private String organizationTitle;
    private String laborFunction;
    private String address;
    private String postedDate;
    private String description;
    private String tagName;

    public Job() {
    }

    public Job(String jobPageUrl, String positionName,
               String urlToOrganization,
               String logoUrl,
               String organizationTitle,
               String laborFunction,
               String address,
               String postedDate,
               String description,
               String tagName) {
        this.jobPageUrl = jobPageUrl;
        this.positionName = positionName;
        this.urlToOrganization = urlToOrganization;
        this.logoUrl = logoUrl;
        this.organizationTitle = organizationTitle;
        this.laborFunction = laborFunction;
        this.address = address;
        this.postedDate = postedDate;
        this.description = description;
        this.tagName = tagName;
    }
    public String getJobPageUrl() {
        return jobPageUrl;
    }

    public void setJobPageUrl(String jobPageUrl) {
        this.jobPageUrl = jobPageUrl;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getUrlToOrganization() {
        return urlToOrganization;
    }

    public void setUrlToOrganization(String urlToOrganization) {
        this.urlToOrganization = urlToOrganization;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getOrganizationTitle() {
        return organizationTitle;
    }

    public void setOrganizationTitle(String organizationTitle) {
        this.organizationTitle = organizationTitle;
    }

    public String getLaborFunction() {
        return laborFunction;
    }

    public void setLaborFunction(String laborFunction) {
        this.laborFunction = laborFunction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Job{" +
                ", jobPageUrl='" + jobPageUrl + '\'' +
                ", positionName='" + positionName + '\'' +
                ", urlToOrganization='" + urlToOrganization + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", organizationTitle='" + organizationTitle + '\'' +
                ", laborFunction='" + laborFunction + '\'' +
                ", address='" + address + '\'' +
                ", postedDate=" + postedDate +
                ", description='" + description + '\'' +
                ", tagName='" + tagName + '\'' +
                '}'+'\n';
    }
}
