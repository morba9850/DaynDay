package com.bhs.springboot.service;


import com.bhs.springboot.dto.WearDetailDto;
import com.bhs.springboot.dto.WearStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WearDataService {

    private static String WEAR_DATA_URL = "https://www.musinsa.com/index.php?m=street&ordw=submitdate&gender=m";
    private static String WEAR_DATA_URL2 = "https://www.musinsa.com/index.php?m=street&ordw=submitdate&gender=f";
    private static String WEAR_DATA_URL3 = "https://www.musinsa.com/index.php?m=shopstaff&gender=m&ordw=d_regis&p=1";
    private static String WEAR_DATA_URL4 = "https://www.musinsa.com/index.php?m=shopstaff&ordw=d_regis&gender=f";




    public List<WearStats> getWearDatas() throws IOException {

        List<WearStats> wearStatsList = new ArrayList<>();
        Document doc = Jsoup.connect(WEAR_DATA_URL).get();
        Document doc2 = Jsoup.connect(WEAR_DATA_URL2).get();
        Document doc3 = Jsoup.connect(WEAR_DATA_URL3).get();
        Document doc4 = Jsoup.connect(WEAR_DATA_URL4).get();

        Elements contents = doc.select("ul.snap-article-list.boxed-article-list.article-list.center.list");
        Elements contents2 = doc2.select("ul.snap-article-list.boxed-article-list.article-list.center.list");
        Elements contents3 = doc3.select("ul.snap-article-list.boxed-article-list.article-list.center.list");
        Elements contents4 = doc4.select("ul.snap-article-list.boxed-article-list.article-list.center.list");

            WearStats wearStats = WearStats.builder()
                    .photo(contents.select("img").attr("src"))
                    .photo2(contents2.select("img").attr("src"))
                    .mphoto(contents3.select("img").attr("src"))
                    .gphoto(contents4.select("img").attr("src"))
                    .build();

        wearStatsList.add(wearStats);
            System.out.println(wearStats.toString());

        return wearStatsList;

    }

    public List<WearDetailDto> get5service() throws IOException {
        List<WearDetailDto> wearDetailDtoList = new ArrayList<>();
        String top = "지금 날씨가 엄청 추워요! 패딩을 어떠신가요?";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .top(top)
                .build();
        wearDetailDtoList.add(wearDetailDto);
        return wearDetailDtoList;
    }
    public List<WearDetailDto> get610service() throws IOException {
        List<WearDetailDto> wearDetailDtoList = new ArrayList<>();
        String top = "지금 날씨가 쌀쌀하네요 코트 어떠신가요?";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .top(top)
                .build();
        wearDetailDtoList.add(wearDetailDto);
        return wearDetailDtoList;
    }
    public List<WearDetailDto> get1021service() throws IOException {
        List<WearDetailDto> wearDetailDtoList = new ArrayList<>();
        String top = "지금 날씨엔 간절기 자켓이 필요하겠어요";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .top(top)
                .build();
        wearDetailDtoList.add(wearDetailDto);
        return wearDetailDtoList;
    }
    public List<WearDetailDto> get2029service() throws IOException {
        List<WearDetailDto> wearDetailDtoList = new ArrayList<>();
        String top = "지금 날씨가 매우 좋아요! 셔츠 어떠신가요?";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .top(top)
                .build();
        wearDetailDtoList.add(wearDetailDto);
        return wearDetailDtoList;
    }
    public List<WearDetailDto> get28service() throws IOException {
        List<WearDetailDto> wearDetailDtoList = new ArrayList<>();
        String top = "날씨가 더워요~ 면티 어떠신가요?";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .top(top)
                .build();
        wearDetailDtoList.add(wearDetailDto);
        return wearDetailDtoList;
    }

    public List<WearDetailDto> getrain20service() throws IOException {
        List<WearDetailDto> wearDetailDtoList2 = new ArrayList<>();
        String shose = "비는 안올것 같아요 단화 어떠신가요? ";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .shose(shose)
                .build();
        wearDetailDtoList2.add(wearDetailDto);
        return wearDetailDtoList2;
    }
    public List<WearDetailDto> getrain2071service() throws IOException {
        List<WearDetailDto> wearDetailDtoList2 = new ArrayList<>();
        String shose = "날씨가 흐리네요 운동화 어떠세요?";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .shose(shose)
                .build();
        wearDetailDtoList2.add(wearDetailDto);
        return wearDetailDtoList2;
    }
    public List<WearDetailDto> getrain70service() throws IOException {
        List<WearDetailDto> wearDetailDtoList2 = new ArrayList<>();
        String shose = "비가올 확률이 크네요 부츠 어떠신가요?";
        WearDetailDto wearDetailDto = WearDetailDto.builder()
                .shose(shose)
                .build();
        wearDetailDtoList2.add(wearDetailDto);
        return wearDetailDtoList2;
    }

}
