package com.liu.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.InputStream;

/**
 * Jsoup快速入门
 */
public class XMLDemo1 {
    public static void main(String[] args) throws Exception{
        String xmlFile = XMLDemo1.class.getClassLoader().getResource("xmlDemo1.xml").getPath();
        Document document = Jsoup.parse(new File(xmlFile), "utf-8");
        Elements names = document.getElementsByTag("name");
        Element element = names.get(0);
        String text = element.text();
        System.out.println(text);
    }
}
