package com.versecode.verseproject;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class verseTest {
    public static String verseOfTheDay;

    @RequestMapping("/getverseoftheday")
    public String hello() {
        try {
            // Connect to the website and get the HTML
            Document doc = Jsoup.connect("https://www.verseoftheday.com").get();

            // Extract the verse of the day
            Element verseElement = doc.selectFirst(".bilingual-left");
            String verseText = verseElement.text();
            verseOfTheDay = verseText;
            // Print the verse of the day
            // System.out.println("Verse of the Day:");
            // System.out.println(verseText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return verseOfTheDay;
    }
}
