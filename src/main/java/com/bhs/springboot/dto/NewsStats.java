package com.bhs.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class NewsStats {

    private String img;
    private String wearsubject;
    private String weartext;
    private String weardate;
}
