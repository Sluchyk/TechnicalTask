package com.example.testTask.job_scraper.httpClient;

import java.io.IOException;
import okhttp3.Response;

public interface HttpBuilderClient {
    Response buildRequest(String uri) throws IOException;
}
