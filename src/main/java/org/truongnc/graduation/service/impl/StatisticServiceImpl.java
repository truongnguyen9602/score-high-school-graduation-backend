package org.truongnc.graduation.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.truongnc.graduation.dto.Email;
import org.truongnc.graduation.dto.SendScoreRequest;
import org.truongnc.graduation.entity.StatisticEntity;
import org.truongnc.graduation.repository.StatisticRepository;
import org.truongnc.graduation.service.EmailService;
import org.truongnc.graduation.service.StatisticService;
import org.truongnc.graduation.type.EmailType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;
    private final EmailService emailService;

    @Override
    public StatisticEntity findBySbd(String sbd) {
        StatisticEntity statisticEntity = statisticRepository.findBySbd(sbd);
        if (Objects.isNull(statisticEntity)) {
            log.warn("Object not found for {}", sbd);
            throw new ObjectNotFoundException(StatisticEntity.class, sbd);
        }
        return statisticEntity;
    }

    @Override
    public Boolean sendMailScore(SendScoreRequest request) {
        StatisticEntity entity = findBySbd(request.getSbd());

        Map<String, Object> variables = new HashMap<>();
        variables.put("sbd", entity.getSbd());
        variables.put("message", entity.buildScoreString());

        Email email = Email.builder().mailTo(request.getMailTo()).subject(EmailType.DOWNLOAD_SCORE.getSubjectVi()).template(EmailType.DOWNLOAD_SCORE.getTemplateVi()).variables(variables).build();
        emailService.sendHtmlMail(email);
        return null;
    }
}
