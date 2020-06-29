//날씨데이터 넣으려구 dto 만듬
package com.bhs.springboot.domain.weathers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Document(collection = "weathers")
public class Weathers {

    @Id
    private String id;

    private int temperature;
    private int rain;




    @Builder
    public Weathers(int temperature, int rain) {
        this.temperature = temperature;
        this.rain = rain;




    }



}
