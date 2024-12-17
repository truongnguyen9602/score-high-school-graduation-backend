package org.truongnc.graduation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.truongnc.graduation.entity.StatisticEntity;
import org.truongnc.graduation.repository.StatisticRepository;
import org.truongnc.graduation.service.StatisticService;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    @Override
    public StatisticEntity findBySbd(String sbd) {
        StatisticEntity statisticEntity = statisticRepository.findBySbd(sbd);
        return statisticEntity;
    }
}
