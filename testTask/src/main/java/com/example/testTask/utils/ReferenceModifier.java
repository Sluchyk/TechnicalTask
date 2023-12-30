package com.example.testTask.utils;

public class ReferenceModifier {
    public  static  String addStartUri(String uri){
        StringBuilder stringBuilder = new StringBuilder("https://jobs.techstars.com/");
        stringBuilder.append(uri);
        return stringBuilder.toString();
    }
    public static String createRequestUri(String uri,String uriParameters){
        StringBuilder stringBuilder = new StringBuilder(uri);
        stringBuilder.append(uriParameters);
        return stringBuilder.toString();
    }
}
