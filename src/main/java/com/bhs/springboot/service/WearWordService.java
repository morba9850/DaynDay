package com.bhs.springboot.service;

import com.bhs.springboot.dto.NewsStats;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class WearWordService {

    private static String WORD_DATA = "https://www.musinsa.com/?m=news";

    public List<NewsStats> getWeartextDatas() throws IOException {

        List<NewsStats> wearTextList = new ArrayList<>();

        Document doc = Jsoup.connect(WORD_DATA).get();

        Elements contents = doc.select("ul.news-article-list.article-list.list li.listItem");

        for(Element content : contents) {
            Elements wearContents = content.select("div.articleInfo.info p.title");
            Elements dateContents = content.select("div.articleInfo.info div.info");
            Elements subjectContents = content.select("div.articleInfo.info div.description");
            Elements imgContents = content.select("div.articleImg a");

            String imgText = imgContents.select("img").attr("src");
            String thText = wearContents.select("a").text();
            String dateText = dateContents.select("span.date.division").text();
            String subText = subjectContents.select("p").text();

            NewsStats newsStats = NewsStats.builder()
                    .weartext(thText)
                    .weardate(dateText)
                    .wearsubject(subText)
                    .img(imgText)
                    .build();

            wearTextList.add(newsStats);


            System.out.println(newsStats.toString());

        }

        System.out.println("패션잡지 크롤링 끝");




        return wearTextList;

    }


}
