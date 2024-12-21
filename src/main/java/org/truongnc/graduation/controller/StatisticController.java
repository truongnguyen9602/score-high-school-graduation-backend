package org.truongnc.graduation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.truongnc.graduation.config.Api;
import org.truongnc.graduation.entity.StatisticEntity;
import org.truongnc.graduation.service.StatisticService;

@RestController
@Api(path = "/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService service;

    @GetMapping("/{sbd}")
    public StatisticEntity sendEmail(@PathVariable("sbd") String sbd) {
        return service.findBySbd(sbd);
    }




}




