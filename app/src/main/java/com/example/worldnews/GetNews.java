package com.example.worldnews;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetNews {

public Response doGet(String url) throws IOException {

final Request request = new Request.Builder().url(url).build();
final OkHttpClient client = new OkHttpClient.Builder().build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
