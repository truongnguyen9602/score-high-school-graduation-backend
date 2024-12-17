package org.truongnc.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.truongnc.graduation.entity.StatisticEntity;

@Repository
public interface StatisticRepository extends JpaRepository<StatisticEntity, String> {
    StatisticEntity findBySbd(String sbd);
}
