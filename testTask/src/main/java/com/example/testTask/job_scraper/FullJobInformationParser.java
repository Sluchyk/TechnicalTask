package com.example.testTask.job_scraper;

import static com.example.testTask.MessageConstants.NOT_FOUND;
import static com.example.testTask.job_scraper.HtmlElementsConstants.ADDRESS_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.DATE_POSTED_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.DESCRIPTION_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.HTML_ATTRIBUTE_HREF;
import static com.example.testTask.job_scraper.HtmlElementsConstants.HTML_ATTRIBUTE_SRC;
import static com.example.testTask.job_scraper.HtmlElementsConstants.HTML_TAG_IMAGE;
import static com.example.testTask.job_scraper.HtmlElementsConstants.JOB_DESCRIPTION_PAGE;
import static com.example.testTask.job_scraper.HtmlElementsConstants.LABOR_FUNCTION_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.LOGO_URL_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.ORGANIZATION_TITLE_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.URL_TO_ORGANIZATION_ELEMENT;
import com.example.testTask.job_scraper.httpClient.HttpClientBuilder;
import com.example.testTask.job_scraper.model.Job;
import com.example.testTask.job_scraper.model.JobItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class FullJobInformationParser {

    public Job getFullInfoAboutJobs(JobItem jobItem) {
        try (Response response = new HttpClientBuilder()
                .buildRequest(jobItem.getUrlApplication())) {
            Document document = Jsoup.parse(response.body().string());
            Elements elements = document.select(JOB_DESCRIPTION_PAGE);
          return parseJobInformation(elements,jobItem);
        } catch (IOException e){
            return  null;
        }
    }

    private Job parseJobInformation(Elements elements,
                                    JobItem jobItem) {
        return new Job(
                jobItem.getUrlApplication(),
                jobItem.getJobTitle(),
                parseUrlToOrganization(elements,jobItem),
                parseLogoUrl(elements),
                parseOrganizationTitle(elements),
                parseLaborFunction(elements),
                parseAddress(elements),
                parseDatePosted(elements),
                parseDescription(elements),
                jobItem.getTags()
        );
    }

    private String parseOrganizationTitle(Elements elements) {
        Element organizationTitleElement = elements.select(ORGANIZATION_TITLE_ELEMENT).first();
        return organizationTitleElement != null ? organizationTitleElement.text() : NOT_FOUND;
    }

    private String parseUrlToOrganization(Elements element,
                                          JobItem jobItem) {
        String hrefUrl = null;
        Element hrefUrlElement = element.select(URL_TO_ORGANIZATION_ELEMENT).first();
        if (hrefUrlElement != null) {
           hrefUrl = hrefUrlElement.attr(HTML_ATTRIBUTE_HREF);
        }
        return hrefUrl != null ? hrefUrl : jobItem.getUrlApplication();
    }

    private String parseLogoUrl(Elements element) {
        String srcLogoUrl = null;
        Element logoUrl = element.select(LOGO_URL_ELEMENT).first();
        if(logoUrl != null) {
            srcLogoUrl = logoUrl.select(HTML_TAG_IMAGE).attr(HTML_ATTRIBUTE_SRC);
        }
        return srcLogoUrl != null ? srcLogoUrl : NOT_FOUND;
    }

    private String parseLaborFunction(Elements element) {
        Elements elements = element.select(LABOR_FUNCTION_ELEMENT);
        Element laborFunction = null;
        if(elements.size() > 1){
            laborFunction = elements.get(1);
        }
        return laborFunction != null ? laborFunction.text() : NOT_FOUND;
    }

    private String parseAddress(Elements element) {
        Element address = element.select(ADDRESS_ELEMENT).last();
        return address != null ? address.text() : NOT_FOUND;
    }

    private String parseDatePosted(Elements element) {
        Element datePosted = element.select(DATE_POSTED_ELEMENT).first();
        if(datePosted == null) return NOT_FOUND;
        return datePosted.text();
    }

    private String parseDescription(Elements element) {
        Element description = element.select(DESCRIPTION_ELEMENT).first();
        return description != null ? description.text() : NOT_FOUND;
    }

}
