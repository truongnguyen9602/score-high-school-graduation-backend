package org.truongnc.graduation.service;

import org.truongnc.graduation.entity.StatisticEntity;

public interface StatisticService {
    StatisticEntity findBySbd(String sbd);
}
