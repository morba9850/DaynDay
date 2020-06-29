package com.bhs.springboot.dto;

import com.bhs.springboot.domain.weathers.Weathers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class WeatherStats {
    private String id;
    private int temperature;
    private int rain;


    @Builder
    public WeatherStats(String id, int temperature, int rain) {

        this.temperature = temperature;
        this.rain = rain;

    }

    public Weathers toDocument() {
        return Weathers.builder()
                .temperature(temperature)
                .rain(rain)
                .build();
    }





}
