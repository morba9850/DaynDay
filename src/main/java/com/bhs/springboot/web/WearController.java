package com.bhs.springboot.web;

import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.dto.WearDetailDto;
import com.bhs.springboot.dto.WearStats;
import com.bhs.springboot.dto.WeatherStats;
import com.bhs.springboot.dto.NewsStats;
import com.bhs.springboot.service.WearDataService;
import com.bhs.springboot.service.WearWordService;
import com.bhs.springboot.service.WeatherDataService;
import com.bhs.springboot.service.WeathersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Log4j2
public class WearController {


    private final WearDataService wearDataService;
    private final WearWordService wearWordService;
    private final WeatherDataService weatherDataService;
    private final WeathersService weathersService;

    @GetMapping("/wear")
    public String wear(Model model, @LoginUser SessionUser user) throws IOException {


        List<WearStats> wearStatsList = wearDataService.getWearDatas();
        List<NewsStats> wearTextList = wearWordService.getWeartextDatas();
        List<WeatherStats> weatherStatsList = weatherDataService.getWeatherDatas(user);

        for(int i = 0; i < weatherStatsList.size(); i++){
            if (weatherStatsList.get(0).getTemperature() < 6) {
                List<WearDetailDto> wearDetailDtoList = wearDataService.get5service();
                model.addAttribute("wearDetailDto", wearDetailDtoList );
                log.info(wearDetailDtoList);
            }else if(weatherStatsList.get(0).getTemperature() > 5 &&
                    weatherStatsList.get(0).getTemperature() < 11){
                List<WearDetailDto> wearDetailDtoList = wearDataService.get610service();
                model.addAttribute("wearDetailDto", wearDetailDtoList );
            }else if(weatherStatsList.get(0).getTemperature() > 10 &&
                    weatherStatsList.get(0).getTemperature() < 21){
                List<WearDetailDto> wearDetailDtoList = wearDataService.get1021service();
                model.addAttribute("wearDetailDto", wearDetailDtoList );
            }else if(weatherStatsList.get(0).getTemperature() > 20 &&
                    weatherStatsList.get(0).getTemperature() < 29){
                List<WearDetailDto> wearDetailDtoList = wearDataService.get2029service();
                model.addAttribute("wearDetailDto", wearDetailDtoList );
            }else if(weatherStatsList.get(0).getTemperature() > 28){
                List<WearDetailDto> wearDetailDtoList = wearDataService.get28service();
                model.addAttribute("wearDetailDto", wearDetailDtoList );
            }
        }

        for(int i = 0; i < weatherStatsList.size(); i++){
            if (weatherStatsList.get(0).getRain() < 21) {
                List<WearDetailDto> wearDetailDtoList2 = wearDataService.getrain20service();
                model.addAttribute("wearDetailDto2", wearDetailDtoList2 );
            } else if (weatherStatsList.get(0).getRain() > 20 &&
                    weatherStatsList.get(0).getRain() < 71){
                List<WearDetailDto> wearDetailDtoList2 = wearDataService.getrain2071service();
                model.addAttribute("wearDetailDto2", wearDetailDtoList2 );
            } else if (weatherStatsList.get(0).getRain() > 70){
                List<WearDetailDto> wearDetailDtoList2 = wearDataService.getrain70service();
                model.addAttribute("wearDetailDto2", wearDetailDtoList2 );
            }
        }


        model.addAttribute("wearStats", wearStatsList);
        System.out.println("뉴스 뿌린다");
        model.addAttribute("newsStats", wearTextList);

        System.out.println(wearTextList);

        return "wear";

    }

}

