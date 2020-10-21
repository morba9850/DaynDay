package com.bhs.springboot.scheduler;

import com.bhs.springboot.dto.WearStats;
import com.bhs.springboot.service.WearWordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class WordCountScheduler {

    private final WearWordService wearWordService;


    @Scheduled(cron = "0 15 5 * * *")
    public void insertWordCountInfo() {

        wearWordService.insertWordCountInfo();


    }
}