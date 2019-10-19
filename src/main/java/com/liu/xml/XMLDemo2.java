package com.liu.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * Jsoup快速入门
 */
public class XMLDemo2 {
    public static void main(String[] args) throws Exception{
        String xmlFile = XMLDemo2.class.getClassLoader().getResource("xmlDemo1.xml").getPath();
        Document document = Jsoup.parse(new File(xmlFile), "utf-8");
        Elements student = document.getElementsByTag("student");
        String number = student.get(0).attr("number");
        System.out.println(number);
    }
}
