package com.bhs.springboot.service;

import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.domain.weathers.Weathers;
import com.bhs.springboot.dto.AreaStats;
import com.bhs.springboot.dto.WearDetailDto;
import com.bhs.springboot.dto.WeatherStats;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Connection;
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
public class WeatherDataService {
    private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36";



    private static String WEATHER_DATA_URL2 = "https://weather.naver.com/rgn/cityWetrMain.nhn";


    public List<WeatherStats> getWeatherDatas(SessionUser user) throws IOException {

        String URL = "https://n.weather.naver.com/";

        Connection conn = Jsoup.connect(URL)
                .header("Content-Type", "application/json;charset=UTF-8")
                .userAgent(USER_AGENT)
                .method(Connection.Method.GET)
                .ignoreContentType(true);

        List<WeatherStats> weatherStatsList = new ArrayList<>();

        Document doc = conn.get();

        Elements contents = doc.select("div.section_center");

        String temperatureText = contents.select("strong.current").text().trim();
        String rainText = contents.select("div.inner_card.climate_rain span.color_cell").text().trim();
        String weatherText = contents.select("div.weather_area p.summary").text();
        String ondoText = contents.select("div.degree_group strong.degree_height").text();
        String ulray = contents.select("div.degree_group strong.degree_low").text();
        System.out.println("결과볼게여");
        temperatureText = temperatureText.substring(5, 7);
        rainText = rainText.substring(5, 7);

        System.out.println(rainText);
        System.out.println(temperatureText);


        int tem2 = Integer.parseInt(temperatureText);
        int rainInt = Integer.parseInt(rainText);

        WeatherStats weatherStats = WeatherStats.builder()
                .temperature(tem2)
                .rain(rainInt)
                .weather(weatherText)
                .ondo(ondoText)
                .ulray(ulray)
                .build();



        System.out.println(weatherStats.toString());
        System.out.println("날씨 서비스 끝");
        weatherStatsList.add(weatherStats);
        return weatherStatsList;
    }

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
            System.out.println(areaStats.toString());
            areaStatsList.add(areaStats);

        }

        return areaStatsList;
    }

}