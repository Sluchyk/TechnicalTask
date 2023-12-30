package com.example.testTask.utils;

import java.util.stream.Collectors;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListConventor {
    public static  String convertListToString(Elements elements){
        return elements.stream().map(Element::text).collect(Collectors.joining(", "));

    }
}
