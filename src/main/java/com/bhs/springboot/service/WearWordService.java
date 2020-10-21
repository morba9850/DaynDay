package com.bhs.springboot.service;

import com.bhs.springboot.dto.WearStats;
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

    public List<WearStats> getWeartextDatas() throws IOException {

        List<WearStats> wearTextList = new ArrayList<>();

        Document doc = Jsoup.connect(WORD_DATA).get();

        String contents = doc.select("ul.news-article-list.article-list.list").text();


        WearStats wearStats = WearStats.builder()
                .weartext(contents)
                .build();

        wearTextList.add(wearStats);

        System.out.println("패션잡지 크롤링 끝");
        System.out.println(wearStats.toString());

        return wearTextList;

    }

    public void insertWordCountInfo() {


    }
}
