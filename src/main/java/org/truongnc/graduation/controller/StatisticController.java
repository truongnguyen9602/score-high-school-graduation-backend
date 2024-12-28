package org.truongnc.graduation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.truongnc.graduation.config.Api;
import org.truongnc.graduation.dto.SendEmailRequest;
import org.truongnc.graduation.dto.SendScoreRequest;
import org.truongnc.graduation.entity.StatisticEntity;
import org.truongnc.graduation.service.StatisticService;

@RestController
@Api(path = "/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService service;

    @GetMapping("/{sbd}")
    public StatisticEntity findBySdb(@PathVariable("sbd") String sbd) {
        return service.findBySbd(sbd);
    }

    @PostMapping("/send-mail")
    public Boolean sendEmail(@RequestBody SendScoreRequest request) {
        return service.sendMailScore(request);
    }

}

