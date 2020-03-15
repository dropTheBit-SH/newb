package com.bit.demo.web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrap {

	public static void main(String[] args) {
	     try {
	         Document doc = Jsoup.connect("https://stackoverflow.com/questions").get();

	         System.out.printf("Title: %s\n", doc.title());

	         Elements summaries = doc.getElementsByClass("summary");

	         for (Element repository : summaries) {
	           String repositoryTitle = repository.getElementsByClass("question-hyperlink").text();

	           String repositoryIssues = repository.getElementsByClass("excerpt").text();

	           System.out.println(repositoryTitle + "\n\t-" + repositoryIssues);
	         }
       } catch (IOException e) {
         e.printStackTrace();
       }
	     
	     
	}

}
