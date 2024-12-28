package org.truongnc.graduation.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailType {
    DOWNLOAD_SCORE("TRA CỨU ĐIỂM THI TỐT NGHIỆP THPT 2024", "TRA CỨU ĐIỂM THI TỐT NGHIỆP THPT 2024", "download-score.ftl", "download-score.ftl"),
    ;

    private final String subjectEn;
    private final String subjectVi;
    private final String templateEn;
    private final String templateVi;
}