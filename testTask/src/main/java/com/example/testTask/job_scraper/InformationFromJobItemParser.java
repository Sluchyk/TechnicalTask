package com.example.testTask.job_scraper;

import static com.example.testTask.MessageConstants.NOT_FOUND;
import static com.example.testTask.MessageConstants.ZERO_JOBS_FOUND;
import static com.example.testTask.job_scraper.HtmlElementsConstants.DATA_TEST_ID_READ_MODE;
import static com.example.testTask.job_scraper.HtmlElementsConstants.HTML_ATTRIBUTE_HREF;
import static com.example.testTask.job_scraper.HtmlElementsConstants.JOB_ITEM_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.JOB_ITEM_URL;
import static com.example.testTask.job_scraper.HtmlElementsConstants.JOB_TAG_ELEMENT;
import static com.example.testTask.job_scraper.HtmlElementsConstants.JOB_TITLE_ELEMENT;
import static com.example.testTask.job_scraper.UrlConstants.URL_JOB_WEB_PAGE;
import com.example.testTask.job_scraper.httpClient.HttpClientBuilder;
import com.example.testTask.job_scraper.model.InformationAboutJobRequest;
import com.example.testTask.job_scraper.model.Job;
import com.example.testTask.job_scraper.model.JobItem;
import com.example.testTask.utils.ListConventor;
import com.example.testTask.utils.ReferenceModifier;
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
public class InformationFromJobItemParser {

    private final JobFunctionEncoder jobFunctionEncoder;
    private final FullJobInformationParser fullJobInformationParser;
    public InformationFromJobItemParser(JobFunctionEncoder jobFunctionEncoder, FullJobInformationParser fullJobInformationParser) {
        this.jobFunctionEncoder = jobFunctionEncoder;
        this.fullJobInformationParser = fullJobInformationParser;
    }


    public InformationAboutJobRequest findJobs(String[] jobFunction) throws IOException, NotFoundException {
        Response response = new HttpClientBuilder().buildRequest(ReferenceModifier.createRequestUri(URL_JOB_WEB_PAGE, jobFunctionEncoder.encodeJobFunction(jobFunction)));
        if (response.body() == null) {
            return  new InformationAboutJobRequest(null,null);
        }
        Document document = Jsoup.parse(response.body().string());
        response.close();
        List<JobItem> jobItemList = parseHtmlToJobItemObject(document);
        String totalNumberOfJobs = findNumberOfAllJobsPerRequest(document);
        List<Job> jobList = fullJobInformationParser.getFullInfoAboutJobs(jobItemList);
        return new InformationAboutJobRequest(jobList, totalNumberOfJobs);
    }

    private List<JobItem> parseHtmlToJobItemObject(Document document) throws NotFoundException {
        Elements elements = document.select(JOB_ITEM_ELEMENT);
        if (elements.isEmpty()) {
            throw new NotFoundException(ZERO_JOBS_FOUND);
        }
        List<JobItem> jobItemList = new ArrayList<>();
        for (Element element : elements) {
            if (element != null) {
                jobItemList.add(new JobItem(
                        getJobTags(element),
                        getUrlForApplication(element),
                        parseJobTitle(element)));
            }
        }
        return jobItemList;
    }

    private String getUrlForApplication(Element element) {
        String link = NOT_FOUND;
        Element linkElement = element.select(DATA_TEST_ID_READ_MODE).first();
        if (linkElement != null) {
            link = linkElement.attr(HTML_ATTRIBUTE_HREF);
        }
        if (link.startsWith("/")) {
            link = ReferenceModifier.addStartUri(link);
        }
        return link;
    }

    private String getJobTags(Element element) {
        String tags;
        Elements tagElements = element.select(JOB_TAG_ELEMENT);
        if (tagElements.isEmpty()) {
            tags = NOT_FOUND;
        } else {
            tags = ListConventor.convertListToString(tagElements);
        }
        return tags;
    }

    private String findNumberOfAllJobsPerRequest(Document document) {
        Element element = document.selectFirst(JOB_ITEM_URL);
        String result = null;
        if (element != null) {
            result = element.text();
        }
        return result;
    }
    private String parseJobTitle(Element element){
        String jobTitle = NOT_FOUND;
        Element jobTitleElement = element.selectFirst(JOB_TITLE_ELEMENT);
        if (jobTitleElement != null) {
            jobTitle = jobTitleElement.text();
        }
        return jobTitle;
    }
}
