package com.example.testTask.job_scraper.httpClient;

import com.example.testTask.job_scraper.httpClient.HttpBuilderClient;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class HttpClientBuilder implements HttpBuilderClient {
    @Override
    public Response buildRequest(String uri) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(uri)
                .build();
        return okHttpClient.newCall(request).execute();
    }
}
