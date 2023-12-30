package com.example.testTask.job_scraper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobPageUrl;
    private String positionName;
    private String urlToOrganization;
    private String logoUrl;
    private String organizationTitle;
    private String laborFunction;
    private String address;
    private Long postedDate;
    @Column(columnDefinition = "longtext")
    private String description;
    private String tagName;

    public JobEntity(String jobPageUrl,
                     String positionName,
                     String urlToOrganization,
                     String logoUrl,
                     String organizationTitle,
                     String laborFunction,
                     String address,
                     Long postedDate,
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
    public JobEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Long postedDate) {
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
}
