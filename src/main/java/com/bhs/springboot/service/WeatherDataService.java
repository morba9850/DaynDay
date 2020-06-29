package com.bhs.springboot.service;

import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.domain.weathers.Weathers;
import com.bhs.springboot.dto.AreaStats;
import com.bhs.springboot.dto.WearDetailDto;
import com.bhs.springboot.dto.WeatherStats;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class WeatherDataService {

       private static String WEATHER_DATA_URL2 = "https://weather.naver.com/rgn/cityWetrMain.nhn";

    @Transactional
    public List<AreaStats> getAreaDatas() throws IOException {
        List<AreaStats> areaStatsList = new ArrayList<>();
        Document doc2 = Jsoup.connect(WEATHER_DATA_URL2).get();
        Elements contents2 = doc2.select("table tbody tr");
        for (Element content2 : contents2) {
            Elements tdContents2 = content2.select("td");
            String thText = content2.select("th").text();
            if(thText.isEmpty()) {
                break;
            }

            String srcText = tdContents2.select("p.icon img").attr("src");
            String ulText = tdContents2.select("ul.text").text();

            AreaStats areaStats = AreaStats.builder()
                    .area(thText)
                    .img(srcText)
                    .weather(ulText)
                    .build();

            System.out.println(areaStats.toString());

            areaStatsList.add(areaStats);

        }

        return areaStatsList;
    }

}