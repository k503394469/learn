package com.liu.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * Jsoup快速入门
 */
public class XMLDemo3 {
    public static void main(String[] args) throws Exception{
        String xmlFile = XMLDemo3.class.getClassLoader().getResource("xmlDemo1.xml").getPath();
        Document document = Jsoup.parse(new File(xmlFile), "utf-8");

//        Elements name = document.select("name");
        Elements name = document.select("#s1");
        System.out.println(name);
    }
}
