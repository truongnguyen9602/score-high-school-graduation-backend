package org.truongnc.graduation.service;

import org.truongnc.graduation.dto.SendScoreRequest;
import org.truongnc.graduation.entity.StatisticEntity;

public interface StatisticService {
    StatisticEntity findBySbd(String sbd);
    Boolean sendMailScore(SendScoreRequest request);
}